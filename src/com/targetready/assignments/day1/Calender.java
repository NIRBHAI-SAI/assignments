package com.targetready.assignments.day1;
import java.util.Scanner;

public class Calender {
    public static void printCalender(int month,int year){
        //starting date.
        int d = 1;
        int m = 1;
        int y = 1;
        int dy = 0;

        String[] days = { "SUN", "MON", "TUE", "WED","THU", "FRI", "SAT" };
        String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL","MAY","JUNE", "JULY","AUGUST","SEPTEMBER","OCTOBER", "NOVEMBER", "DECEMBER" };
        int[] daysInAMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Till condition holds true
        while (d != 1 || m != month || y != year) {

            dy++;//increase day
            d++;//increase date

            if (d > daysInAMonth[m - 1]) {
                m++;//increase month only if days exceeds the limit
                d = 1;
            }

            if (m > 12) {
                m = 1;//increase the year if month is more than 12
                y++;
                daysInAMonth[1] = isLeapYear(y);
            }

            if (dy == 7) {//if day exceeds 6 drop it to 0
                dy = 0;
            }
        }
//        System.out.printf("day-date-month-year:: %s,%d,%s,%d",days[dy],d,months[m-1],year);
        System.out.printf("MONTH : %s" , months[m-1]);

        daysInAMonth[1] = isLeapYear(y);

        System.out.println();
        // print days
        for (int k = 0; k < 7; k++) {
            System.out.print("   " + days[k]);
        }

        System.out.println();


        // Printing the calendar
        for (int i = 0; i < dy; i++)
            System.out.print("      ");
        for (int i = 1; i <= daysInAMonth[month - 1]; i++) {
            System.out.printf(" %4d ", i);

            if ((i + dy) % 7 == 0)
                System.out.println();
        }

    }

    private static int isLeapYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            return 29;
        }
        return 28;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month:");
        int month = sc.nextInt();
        System.out.print("Enter year:");
        int year = sc.nextInt();

        if(isValid(month,year)){
            printCalender(month,year);
        }
        else {
            System.out.print("INVALID MONTH OR YEAR");
        }

    }

    private static boolean isValid(int m, int y) {
        return m > 0 && m <= 12 && y > 0;
    }
}