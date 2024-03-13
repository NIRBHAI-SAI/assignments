package com.targetready.assignments.day3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();//get the name of the text file


        String[] lines = readFile(fileName);// read the file and get the array

        // try catch block is used here
        // lines[] will be null is error occurs(file not found)
        //lines will be an empty array {} if empty file is given in input



        if(lines != null && lines.length == 0){
            System.err.println("empty file");

        }
        else if(lines != null){

            contents(lines);

            //to display the longest line
            String L = TextFileAnalyzer.findLongestLine(lines);
            System.out.println(L);

            //to display the shortest line
            String S = TextFileAnalyzer.findShortestLine(lines);
            System.out.println(S);

            //to display word count.
            WordCountArray(lines);

            //to display sorted word count
            sortWordCountArray(lines);

        }

    }

    private static void contents(String[] lines){
        System.out.println("Contents : ");

        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
    public static String[] readFile(String filename) {
        try (
                FileReader reader = new FileReader(filename+".txt");
                BufferedReader in = new BufferedReader(reader)
        ){

             return in.lines().toArray(String[]::new);

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return null;

        //NO NEED TO CLOSE THE FILES AS TRY BLOCK CLOSES THEM
    }

    private static void sortWordCountArray(String[] lines) {
        int[] wordCount = TextFileAnalyzer.countWords(lines);
        TextFileAnalyzer.sortWordCount(wordCount);
        System.out.println("Sorted Word count:");
        for (int j : wordCount) {
            System.out.printf("%d words ", j);
            System.out.println();
        }
        System.out.println();
    }

    private static void WordCountArray(String[] lines) {
        int[] wordCount = TextFileAnalyzer.countWords(lines);

        System.out.println("Word count for each line:");
        for (int i = 0; i < wordCount.length; i++) {
            System.out.printf("Line %d : %d words",i+1,wordCount[i]);
            System.out.println();
        }
        System.out.println();
    }



    public static class TextFileAnalyzer {
        public static String findLongestLine(String[] lines){
            String longestLine="";
            int count =0;
            int idx=0;
            for(String line: lines){
                count++;
                if(line.length() >longestLine.length()){
                    longestLine = line;
                    idx = count;
                }
            }
            return "longest line : \nline " + idx + " : " + longestLine;
        }

        public static String findShortestLine(String[] lines){
            String shortestLine=lines[0];
            int count =0;
            int idx=0;
            for(String line: lines){
                count++;
                if(line.length() <shortestLine.length()){
                    shortestLine = line;
                    idx = count;
                }
            }
            return "Shortest Line :\nline " + idx + " : " + shortestLine;
        }
        public static int[] countWords(String[] lines) {
            int[] wordCount = new int[lines.length];
            int i=0;
            for(String line:lines){
                wordCount[i] = line.length();
                i++;
            }
            return wordCount;
        }

        public static void sortWordCount(int[] wordCounts) {
            // Implementation to sort word counts
            Arrays.sort(wordCounts);
            int n =wordCounts.length;
            for (int i = 0; i <n/2; i++) {
                int temp = wordCounts[i];
                wordCounts[i] = wordCounts[n-1-i];
                wordCounts[n-1-i]=temp;
            }
        }



    }



}
