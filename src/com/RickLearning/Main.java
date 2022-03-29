package com.RickLearning;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = 0;
        byte years = 1;
        float annualInterest = 0;

        principal = (int)readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000);
        years = (byte)readNumber("Period (years): ", 1, 30);
        annualInterest = (float)readNumber("Annual Interest Rate %: ", 1, 30);

        double monthlyMortgage = calculateMortgage(principal, annualInterest, years);
        String monthlyMortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyMortgage);
        System.out.println("Your monthly mortgage payment is " + monthlyMortgageFormatted);

    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;

            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short totalMonths = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / totalMonths / PERCENT;

        double monthlyMortgage = principal
                * ((monthlyInterest * (Math.pow(1 + monthlyInterest, totalMonths)))
                / (Math.pow(1 + monthlyInterest, totalMonths) -1));

        return monthlyMortgage;
    }
}
