package com.fiqrikm18;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    public static void main(String[] args) {
        solution(new int[] {-4, 3, -9, 0, 4, 1});
    }

    public static void solution(int[] arr) {
        DecimalFormat formatter = new DecimalFormat("0.000000", new DecimalFormatSymbols());
        int positiveNumber = 0;
        int negativeNumber = 0;
        int zero = 0;

        for (int number : arr) {
            if (number == 0) {
                zero++;
            } else if (number < 0) {
                negativeNumber++;
            } else {
                positiveNumber++;
            }
        }

        System.out.println(formatter.format((double) positiveNumber/arr.length));
        System.out.println(formatter.format((double) negativeNumber/arr.length));
        System.out.println(formatter.format((double) zero/arr.length));
    }
}