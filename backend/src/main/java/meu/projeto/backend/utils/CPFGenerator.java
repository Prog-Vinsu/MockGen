package meu.projeto.backend.utils;

import java.util.Random;
import java.util.Arrays;

public class CPFGenerator {
    public static String generateCPF() {
        Random random = new Random();
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = random.nextInt(10);
        }

        int firstDigit = calculateDigit(numbers, 10);
        int secondDigit = calculateDigit(appendDigit(numbers, firstDigit), 11);

        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d",
                numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5],
                numbers[6], numbers[7], numbers[8], firstDigit, secondDigit);
    }

    private static int calculateDigit(int[] numbers, int weight) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * (weight - i);
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : (11 - remainder);
    }

    private static int[] appendDigit(int[] numbers, int digit) {
        int[] result = Arrays.copyOf(numbers, numbers.length + 1);
        result[numbers.length] = digit;
        return result;
    }
}