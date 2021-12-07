package com.yourcodereview.dev.yudin.banknotecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BanknoteCalculatorTest {
    Calculator banknoteCalculator = new BanknoteCalculator();

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs1000() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 1000 - Amount: 5");

        int sum = 5000;
        String banknotes = "1000";

        StringBuilder actual = banknoteCalculator.calculate(sum, banknotes);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs1000_500() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 1000 - Amount: 5").append("\n");
        expected.append("Banknote: 500 - Amount: 1");

        int sum = 5500;
        String input = "1000, 500";

        StringBuilder actual = banknoteCalculator.calculate(sum, input);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs1000_500_50() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 1000 - Amount: 0").append("\n");
        expected.append("Banknote: 500 - Amount: 0").append("\n");
        expected.append("Banknote: 50 - Amount: 6");

        int sum = 331;
        String input = "1000, 500, 50";

        StringBuilder actual = banknoteCalculator.calculate(sum, input);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs20_100_1() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 100 - Amount: 2").append("\n");
        expected.append("Banknote: 20 - Amount: 2").append("\n");
        expected.append("Banknote: 1 - Amount: 18");

        int sum = 258;
        String input = "20, 100, 1";

        StringBuilder actual = banknoteCalculator.calculate(sum, input);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs20_100_1_WithWhiteSpacesAtStartAndEnd() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 100 - Amount: 2").append("\n");
        expected.append("Banknote: 20 - Amount: 2").append("\n");
        expected.append("Banknote: 1 - Amount: 18");

        int sum = 258;
        String input = " 20,100,1 ";

        StringBuilder actual = banknoteCalculator.calculate(sum, input);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldCountAmountBanknote_WhenInputIs1_2_100() {
        StringBuilder expected = new StringBuilder();

        expected.append("Banknote: 100 - Amount: 56").append("\n");
        expected.append("Banknote: 2 - Amount: 34").append("\n");
        expected.append("Banknote: 1 - Amount: 1");

        int sum = 5669;
        String input = "1, 2, 100";

        StringBuilder actual = banknoteCalculator.calculate(sum, input);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void calculate_ShouldThrowIllegalArgumentException_WhenInputIsEmptyString() {
        int sum = 258;
        String input = "  ";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteCalculator.calculate(sum, input));

        String expected = "Input cannot be empty";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void calculate_ShouldThrowIllegalArgumentException_WhenInputIsNull() {
        int sum = 258;
        String input = null;

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteCalculator.calculate(sum, input));

        String expected = "Input cannot be null";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void calculate_ShouldThrowIllegalArgumentException_WhenInputIsDoesNotExistBanknotes() {
        int sum = 258;
        String input = "35, 50";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteCalculator.calculate(sum, input));

        String expected = "[35] There is no such banknote.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void calculate_ShouldThrowIllegalArgumentException_WhenInputIsLetters() {
        int sum = 258;
        String input = "a, b, c";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteCalculator.calculate(sum, input));

        String expected = "Input can be only positive numbers";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void calculate_ShouldThrowIllegalArgumentException_WhenInputIsNumbersAndLetters() {
        int sum = 258;
        String input = "29847nsnsba";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteCalculator.calculate(sum, input));

        String expected = "Input can be only positive numbers";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}

