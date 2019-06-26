package com.ioconnectservices.memorygame;

import android.support.test.rule.ActivityTestRule;

import com.ioconnectservices.memorygame.view.GameActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.CoreMatchers.not;

public class GameActivityTest {

    @Rule
    public ActivityTestRule<GameActivity> gameActivityTestRule = new
            ActivityTestRule<>(GameActivity.class);

    @Test
    public void displayWinnerToastOnGameEnded() {
        givenGameHasEnded();

        onView(withText(R.string.game_ended_text))
                .inRoot(withDecorView(not(gameActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    private void givenGameHasEnded() {
        gameActivityTestRule.getActivity().onGameEnded(true);
    }
}
