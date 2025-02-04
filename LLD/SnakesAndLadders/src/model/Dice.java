package model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;//for multiple dices
    public static int min = 1;
    public static int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int roll(){
        int totalSum = 0;
        int diceUsed = 0;

        while(diceUsed < this.diceCount){
            totalSum += ThreadLocalRandom.current().nextInt(min, max + 1);
            diceUsed++;
        }
        return totalSum;
    }
}
