package com.ioconnectservices.memorygame.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;
import android.os.Handler;

import com.ioconnectservices.memorygame.R;
import com.ioconnectservices.memorygame.model.Card;
import com.ioconnectservices.memorygame.model.Game;

import java.util.Random;

import static com.ioconnectservices.memorygame.utils.CardsUtils.getCardResource;
import static com.ioconnectservices.memorygame.utils.CardsUtils.getCardValue;
import static com.ioconnectservices.memorygame.utils.StringUtils.numbersFromString;
import static com.ioconnectservices.memorygame.utils.StringUtils.stringFromNumbers;

public class GameViewModel extends ViewModel {

    private int cols;
    private int rows;

    private static final int CARD_BACK_RESOURCE = R.mipmap.card_back;

    private String firstKey = "";
    private String secondKey = "";

    private Game game;

    public ObservableArrayMap<String, Integer> cards;

    public void init(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cards = new ObservableArrayMap<>();
        randomizeCards();
    }

    private void randomizeCards() {
        game = new Game(rows, cols);
        int midIndicator = (game.getTotalCards() / 2) - 1;
        int totalCardsSetCounter = 0;
        while (totalCardsSetCounter < game.getTotalCards()) {
            int random1 = new Random().nextInt(rows);
            int random2 = new Random().nextInt(cols);
            if (game.cards[random1][random2] == null) {
                game.cards[random1][random2] = new Card(getCardValue(totalCardsSetCounter, midIndicator));
                cards.put(stringFromNumbers(random1, random2), CARD_BACK_RESOURCE);
                totalCardsSetCounter++;
            }
        }
    }

    public void onClickedCardAt(int col, int row) {
        if (firstKey.equals("") && game.cards[col][row].isNotFound()) {
            firstKey = String.valueOf(col) + String.valueOf(row);
            cards.put(stringFromNumbers(col, row), getCardResource(game.cards[col][row].getValue()));
        } else if (secondKey.equals("") && game.cards[col][row].isNotFound()) {
            secondKey = String.valueOf(col) + String.valueOf(row);
            cards.put(stringFromNumbers(col, row), getCardResource(game.cards[col][row].getValue()));
            checkIfCardsMatch();
        }
    }

    public MutableLiveData<Boolean> hasGameEnded() {
        return game.gameEnded;
    }

    private void checkIfCardsMatch() {
        if (game.doCardsMatch(firstKey, secondKey)) {
            game.cards[numbersFromString(firstKey)[0]][numbersFromString(firstKey)[1]].setFound(true);
            game.cards[numbersFromString(secondKey)[0]][numbersFromString(secondKey)[1]].setFound(true);
            firstKey = "";
            secondKey = "";
            if (game.hasGameEnded()) {
                new Handler().postDelayed(() -> {
                    cards.clear();
                    randomizeCards();
                }, 1500);
            }
        } else {
            new Handler().postDelayed(() -> {
                cards.put(firstKey, CARD_BACK_RESOURCE);
                cards.put(secondKey, CARD_BACK_RESOURCE);
                firstKey = "";
                secondKey = "";
            }, 1500);
        }
    }
}
