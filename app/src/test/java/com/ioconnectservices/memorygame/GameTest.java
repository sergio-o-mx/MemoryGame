package com.ioconnectservices.memorygame;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.ioconnectservices.memorygame.model.Card;
import com.ioconnectservices.memorygame.model.Game;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GameTest {

    private Game game;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        game = new Game(3, 4);
    }

    @Test
    public void testGetTotalCards() {
        assertEquals(game.getTotalCards(), 12);
    }

    @Test
    public void testHasGameEnded() {
        Card card01 = new Card(0);
        card01.setFound(true);
        Card card02 = new Card(0);
        card02.setFound(true);
        Card card03 = new Card(1);
        card03.setFound(true);
        Card card04 = new Card(1);
        card04.setFound(true);
        Card card05 = new Card(2);
        card05.setFound(true);
        Card card06 = new Card(2);
        card06.setFound(true);
        Card card07 = new Card(3);
        card07.setFound(true);
        Card card08 = new Card(3);
        card08.setFound(true);
        Card card09 = new Card(4);
        card09.setFound(true);
        Card card10 = new Card(4);
        card10.setFound(true);
        Card card11 = new Card(5);
        card11.setFound(true);
        Card card12 = new Card(5);
        card12.setFound(true);

        game.cards[0][0] = card01;
        game.cards[0][1] = card02;
        game.cards[0][2] = card03;
        game.cards[0][3] = card04;
        game.cards[1][0] = card05;
        game.cards[1][1] = card06;
        game.cards[1][2] = card07;
        game.cards[1][3] = card08;
        game.cards[2][0] = card09;
        game.cards[2][1] = card10;
        game.cards[2][2] = card11;
        game.cards[2][3] = card12;

        boolean hasGameEnded = game.hasGameEnded();
        assertTrue(hasGameEnded);
    }

    @Test
    public void testDoCardsMatch() {
        Card card01 = new Card(0);
        card01.setFound(true);
        Card card02 = new Card(0);
        card02.setFound(true);

        game.cards[0][0] = card01;
        game.cards[0][1] = card02;

        String key1 = "00";
        String key2 = "01";

        boolean doCardsMatch = game.doCardsMatch(key1, key2);
        assertTrue(doCardsMatch);
    }

    @Test
    public void testAreAllPairsFound() {
        Card card01 = new Card(0);
        card01.setFound(true);
        Card card02 = new Card(0);
        card02.setFound(true);
        Card card03 = new Card(1);
        card03.setFound(true);
        Card card04 = new Card(1);
        card04.setFound(true);
        Card card05 = new Card(2);
        card05.setFound(true);
        Card card06 = new Card(2);
        card06.setFound(true);
        Card card07 = new Card(3);
        card07.setFound(true);
        Card card08 = new Card(3);
        card08.setFound(true);
        Card card09 = new Card(4);
        card09.setFound(true);
        Card card10 = new Card(4);
        card10.setFound(true);
        Card card11 = new Card(5);
        card11.setFound(true);
        Card card12 = new Card(5);
        card12.setFound(true);

        game.cards[0][0] = card01;
        game.cards[0][1] = card02;
        game.cards[0][2] = card03;
        game.cards[0][3] = card04;
        game.cards[1][0] = card05;
        game.cards[1][1] = card06;
        game.cards[1][2] = card07;
        game.cards[1][3] = card08;
        game.cards[2][0] = card09;
        game.cards[2][1] = card10;
        game.cards[2][2] = card11;
        game.cards[2][3] = card12;

        boolean areAllPairsFound = game.areAllPairsFound();
        assertTrue(areAllPairsFound);
    }
}
