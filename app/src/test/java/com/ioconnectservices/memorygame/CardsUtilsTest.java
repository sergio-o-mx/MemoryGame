package com.ioconnectservices.memorygame;

import com.ioconnectservices.memorygame.model.Card;
import com.ioconnectservices.memorygame.model.Game;
import com.ioconnectservices.memorygame.utils.CardsUtils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardsUtilsTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game(3, 4);
    }

    @Test
    public void testGetCardResource_success() {
        assertEquals(CardsUtils.getCardResource(0), R.mipmap.spade_01);
        assertEquals(CardsUtils.getCardResource(8), R.mipmap.spade_09);
    }

    @Test
    public void testGetCardResource_fail() {
        assertNotEquals(CardsUtils.getCardResource(0), R.mipmap.spade_02);
        assertNotEquals(CardsUtils.getCardResource(9), R.mipmap.spade_03);
    }

    @Test
    public void testGetCardValue_success() {
        int midIndicator = (game.getTotalCards() / 2) - 1;

        Card card01 = new Card(0);
        Card card02 = new Card(0);
        Card card03 = new Card(1);
        Card card04 = new Card(1);
        Card card05 = new Card(2);
        Card card06 = new Card(2);
        Card card07 = new Card(3);
        Card card08 = new Card(3);
        Card card09 = new Card(4);
        Card card10 = new Card(4);
        Card card11 = new Card(5);
        Card card12 = new Card(5);

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

        assertEquals(CardsUtils.getCardValue(0, midIndicator), 0);
        assertEquals(CardsUtils.getCardValue(2, midIndicator), 1);
        assertEquals(CardsUtils.getCardValue(4, midIndicator), 2);
    }

    @Test
    public void testGetCardValue_fail() {
        int midIndicator = (game.getTotalCards() / 2) - 1;

        Card card01 = new Card(0);
        Card card02 = new Card(0);
        Card card03 = new Card(1);
        Card card04 = new Card(1);
        Card card05 = new Card(2);
        Card card06 = new Card(2);
        Card card07 = new Card(3);
        Card card08 = new Card(3);
        Card card09 = new Card(4);
        Card card10 = new Card(4);
        Card card11 = new Card(5);
        Card card12 = new Card(5);

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

        assertNotEquals(CardsUtils.getCardValue(0, midIndicator), 3);
        assertNotEquals(CardsUtils.getCardValue(2, midIndicator), 4);
        assertNotEquals(CardsUtils.getCardValue(4, midIndicator), 5);
    }
}
