package com.ioconnectservices.memorygame.utils;

public class StringUtils {

    public static String stringFromNumbers(int... numbers) {
        StringBuilder sNumbers = new StringBuilder();
        for (int number : numbers)
            sNumbers.append(number);
        return sNumbers.toString();
    }

    public static int[] numbersFromString(String key) {
        int[] numbers = new int[2];
        numbers[0] = Integer.parseInt(key.substring(0, 1));
        numbers[1] = Integer.parseInt(key.substring(1, 2));
        return numbers;
    }
}
