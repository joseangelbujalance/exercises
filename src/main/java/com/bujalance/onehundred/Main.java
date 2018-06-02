package com.bujalance.onehundred;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int TARGETED_RESULT = 100;

    public static void main(String[] args) {
        String sequence = "123";
        printAllCombinations(sequence, 1);
    }

    private static void printAllCombinations(final String sequence, int index) {
        if (index >= sequence.length()) {
            System.out.println(sequence);
            return;
        }

        String alreadyTreated = sequence.substring(0, index);
        String toTreat = sequence.substring(index);
        int newIndex = index + 2;
        printAllCombinations(alreadyTreated + "+" + toTreat, newIndex);
        printAllCombinations(alreadyTreated + "-" + toTreat, newIndex);
        printAllCombinations(alreadyTreated + "#" + toTreat, newIndex);
    }
}
