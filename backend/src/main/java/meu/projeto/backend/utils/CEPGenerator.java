package meu.projeto.backend.utils;

import java.util.Random;

public class CEPGenerator {
    public static String generateCEP() {
        Random random = new Random();
        
        int part1 = random.nextInt(90000) + 10000; 
        int part2 = random.nextInt(900) + 100; 
        
        return String.format("%05d-%03d", part1, part2);
    }
}
