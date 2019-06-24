package com.ioconnectservices.memorygame.model;

public class Card {

    private int value;
    private boolean isFound;

    public Card(int value) {
        this.value = value;
        isFound = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isNotFound() {
        return !isFound;
    }

    public void setFound(boolean found) {
        this.isFound = found;
    }
}
