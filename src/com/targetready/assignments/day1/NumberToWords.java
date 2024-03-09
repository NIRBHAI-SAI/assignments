package com.targetready.assignments.day1;

import java.util.Scanner;

// int max range is 2,14,74,83,647 > 99,99,99,999
public class NumberToWords {

    public static String wordsRecursive(int num){
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teen = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teen[(num % 10)];
        } else if (num < 100) {
            return tens[(num / 10)] + " " + units[(num % 10)];
        } else if (num < 1000) {
            return units[num / 100] + " hundred and " + wordsRecursive(num % 100);
        } else if (num < 10000) {
            return units[num / 1000] + " thousand " + wordsRecursive(num % 1000);
        } else if (num < 100000) {
            return wordsRecursive(num / 1000) + " thousand " + wordsRecursive(num % 1000);
        } else if (num < 10000000) {
            return wordsRecursive(num / 100000) + " lakh " + wordsRecursive(num% 100000);
        } else if (num < 1000000000) {
            return wordsRecursive(num / 10000000) + " crore " + wordsRecursive(num % 10000000);
        }
        return "";

    }
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n>=1 && n<=999999999){
            System.out.printf("%s", wordsRecursive(n));
        }
        else{
            System.out.println("INVALID INPUT");
        }


    }
}
