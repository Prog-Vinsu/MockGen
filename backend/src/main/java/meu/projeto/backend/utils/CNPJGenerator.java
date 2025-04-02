package meu.projeto.backend.utils;

import java.util.Arrays;
import java.util.Random;

public class CNPJGenerator {
    public static String generateCNPJ() {
        Random random = new Random();
        int[] numbers = new int[12];
        
        for (int i = 0; i < 12; i++) {
            numbers[i] = random.nextInt(10);
        }
        
        int firstDigit = calculateDigit(numbers, new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});
        int secondDigit = calculateDigit(appendDigit(numbers, firstDigit), new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});

        return String.format("%02d.%03d.%03d/%04d-%02d", 
                numbers[0], numbers[1] * 100 + numbers[2] * 10 + numbers[3], 
                numbers[4] * 100 + numbers[5] * 10 + numbers[6],
                numbers[7] * 1000 + numbers[8] * 100 + numbers[9] * 10 + numbers[10],
                firstDigit * 10 + secondDigit);
    }

    private static int calculateDigit(int[] numbers, int[] weights) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * weights[i];
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
