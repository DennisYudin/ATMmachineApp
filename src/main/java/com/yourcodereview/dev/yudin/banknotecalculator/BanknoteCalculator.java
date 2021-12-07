package com.yourcodereview.dev.yudin.banknotecalculator;

import com.yourcodereview.dev.yudin.banknote.BanknoteResolver;
import com.yourcodereview.dev.yudin.banknote.Resolver;

import java.util.Arrays;
import java.util.Collections;

public class BanknoteCalculator implements Calculator {
    private static final String DIGITS_REGEX = "[0-9]+";
    private static final String INPUT_NULL_MESSAGE = "Input cannot be null";
    private static final String INPUT_EMPTY_MESSAGE = "Input cannot be empty";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "Input can be only positive numbers";

    private Resolver banknoteResolver = new BanknoteResolver();

    @Override
    public StringBuilder calculate(int sum, String input) {

        StringBuilder result = new StringBuilder();

        Integer[] banknotes = getSortedBanknotes(input);

        for (int banknote : banknotes) {
            int count = 0;

            while (sum >= banknote) {
                sum = sum - banknote;
                count++;
            }
            result.append("Banknote: ").append(banknote)
                    .append(" - ")
                    .append("Amount: ").append(count)
                    .append("\n");
        }
        result.deleteCharAt(result.length() - 1);

        return result;
    }

    private Integer[] getSortedBanknotes(String input) {

        String[] banknotesStringArray = getBanknotes(input);

        int amountBanknotes = banknotesStringArray.length;

        Integer[] banknotes = new Integer[amountBanknotes];

        for (int i = 0; i < amountBanknotes; i++) {
            String banknote = banknotesStringArray[i];

            validateByDigits(banknote);

            banknoteResolver.resolve(banknote);

            banknotes[i] = Integer.parseInt(banknote);
        }
        Arrays.sort(banknotes, Collections.reverseOrder());

        return banknotes;
    }

    private String[] getBanknotes(String input) {

        validateByNullOrEmpty(input);

        String inputWithoutSpaces = input.replaceAll("\\s", "");

        String[] banknotesStringArray = inputWithoutSpaces.split(",");

        return banknotesStringArray;
    }

    private void validateByDigits(String input) {
        if (!input.matches(DIGITS_REGEX)) {
            throw new IllegalArgumentException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private void validateByNullOrEmpty(String input) {
        if (input == null)
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
        }
    }
}
