package com.bujalance.onehundred;

import org.mariuszgromada.math.mxparser.Expression;

public class Main {

    private static int TARGETED_RESULT = 100;

    public static void main(String[] args) {
        String sequence = "123456789";
        char[] signs = new char[] {'+', '-', '_'};
        printCombinations(1, sequence, signs, true);
    }

    private static void printCombinations(int index, final String sequence, final char[] signs, final boolean onlySolutions) {
        if (index >= sequence.length()) {
            if (onlySolutions) {
                if (sequenceIsSolution(sequence, TARGETED_RESULT)) {
                    System.out.println(sequence);
                }
            } else {
                System.out.println(sequence);
            }
            return;
        }

        String alreadyTreated = sequence.substring(0, index);
        String toTreat = sequence.substring(index);
        int newIndex = index + 2;
        for (char sign : signs) {
            printCombinations(newIndex, alreadyTreated + sign + toTreat, signs, onlySolutions);
        }
    }

    private static boolean sequenceIsSolution(final String sequence, final int targetedResult) {
        Expression expression = new Expression(sequence.replaceAll("_", ""));
        double result = expression.calculate();
        return result == targetedResult;
    }
}
