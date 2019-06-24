package com.ioconnectservices.memorygame.utils;

import com.ioconnectservices.memorygame.R;

public class CardsUtils {

    private static final int[] CARDS_RESOURCES = new int[]{
            R.mipmap.spade_01,
            R.mipmap.spade_02,
            R.mipmap.spade_03,
            R.mipmap.spade_04,
            R.mipmap.spade_05,
            R.mipmap.spade_06,
            R.mipmap.spade_07,
            R.mipmap.spade_08,
            R.mipmap.spade_09,
            R.mipmap.spade_10,
    };

    public static int getCardResource(int cardValue) {
        return CARDS_RESOURCES[cardValue];
    }

    public static int getCardValue(int totalCardsSetCounter, int midIndicator) {
        return totalCardsSetCounter > midIndicator ?
                totalCardsSetCounter - (midIndicator + 1) :
                totalCardsSetCounter;
    }
}
