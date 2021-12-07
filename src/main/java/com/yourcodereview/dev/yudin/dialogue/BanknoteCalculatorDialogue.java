package com.yourcodereview.dev.yudin.dialogue;

import com.yourcodereview.dev.yudin.banknotecalculator.BanknoteCalculator;
import com.yourcodereview.dev.yudin.banknotecalculator.Calculator;

import java.util.Scanner;

public class BanknoteCalculatorDialogue implements Dialogue {
    private static final String GREETING_MESSAGE = "ATM machine greetings to you!";
    private static final String SUM_MESSAGE = "Enter sum: ";
    private static final String NOTES_MESSAGE = "Enter banknotes: ";
    private static final String REPEAT_MESSAGE = "Do you wanna to try again? [yes/no]";
    private static final String USER_ANSWER = "Answer: ";
    private static final String ERROR_MESSAGE = "Sum cannot be less or equals zero";
    private static final String INCORRECT_INPUT_MESSAGE = "Incorrect input. ";

    private Calculator banknoteCalculator = new BanknoteCalculator();

    @Override
    public void start(Scanner scanner) {
        String userAnswer;

        do {
            System.out.println(GREETING_MESSAGE);

            int sum = validateInputSum(scanner);

            scanner.nextLine();

            printResult(sum, scanner);

            userAnswer = tryAgain(scanner);
        } while ("yes".equals(userAnswer));
    }

    private void printResult(int inputSum, Scanner scanner) {
        String userInputNotes;
        boolean goodInput = false;
        do {
            System.out.print(NOTES_MESSAGE);

            userInputNotes = scanner.nextLine();
            try {
                System.out.println(banknoteCalculator.calculate(inputSum, userInputNotes));
                goodInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(INCORRECT_INPUT_MESSAGE + ex.getMessage());
            }
        } while (!goodInput);
    }

    private int validateInputSum(Scanner scanner) {
        int userInputSum;
        boolean goodInput = false;
        do {
            System.out.print(SUM_MESSAGE);
            userInputSum = scanner.nextInt();
            try {
                validate(userInputSum);
                goodInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(INCORRECT_INPUT_MESSAGE + ex.getMessage());
            }
        } while (!goodInput);

        return userInputSum;
    }

    private void validate(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private String tryAgain(Scanner scanner) {
        System.out.println(REPEAT_MESSAGE);
        System.out.print(USER_ANSWER);

        String answer = scanner.nextLine().toLowerCase();
        System.out.println();

        return answer;
    }
}
