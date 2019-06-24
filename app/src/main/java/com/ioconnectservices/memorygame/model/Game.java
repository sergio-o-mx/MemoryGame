package com.ioconnectservices.memorygame.model;

import android.arch.lifecycle.MutableLiveData;

import static com.ioconnectservices.memorygame.utils.StringUtils.numbersFromString;

public class Game {

    private int totalCards;

    public Card cards[][];

    public MutableLiveData<Boolean> gameEnded = new MutableLiveData<>();

    public Game(int rows, int cols) {
        cards = new Card[rows][cols];
        totalCards = rows * cols;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public boolean hasGameEnded() {
        if (areAllPairsFound()) {
            gameEnded.setValue(true);
            return true;
        }
        return false;
    }

    public boolean doCardsMatch(String key1, String key2) {
        return cards[numbersFromString(key1)[0]][numbersFromString(key1)[1]].getValue() ==
                cards[numbersFromString(key2)[0]][numbersFromString(key2)[1]].getValue();
    }

    public boolean areAllPairsFound() {
        for (Card[] row : cards)
            for (Card card : row)
                if (card.isNotFound())
                    return false;
        return true;
    }
}
