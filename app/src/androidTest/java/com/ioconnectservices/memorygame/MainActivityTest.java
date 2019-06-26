package com.ioconnectservices.memorygame;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import com.ioconnectservices.memorygame.view.GameActivity;
import com.ioconnectservices.memorygame.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void launchGameWith4x3TypeBoard() {
        Intents.init();

        onView(withText(R.string.main_game_type_4x3))
                .perform(click());

        intended(hasComponent(GameActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void launchGameWith4x4TypeBoard() {
        Intents.init();

        onView(withText(R.string.main_game_type_4x4))
                .perform(click());

        intended(hasComponent(GameActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void launchGameWith4x5TypeBoard() {
        Intents.init();

        onView(withText(R.string.main_game_type_4x5))
                .perform(click());

        intended(hasComponent(GameActivity.class.getName()));
        Intents.release();
    }

}
