package com.example.admission_help.universityInfo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class daysleft {

    static boolean leapYear(int year) {
        boolean leap = false;
        // if the year is divided by 4
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        } else
            leap = false;
        return leap;
    }
    public static String dayleft(String examdate) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss z");
        Date date = new Date();
        formatDate.setTimeZone(TimeZone.getTimeZone("IST"));
        String today = formatDate.format(date);
        System.out.println(today);
        int d1, d2, m1, m2, y1, y2;
        d1 = (today.charAt(0) - '0') * 10 + (today.charAt(1) - '0');
        d2 = (examdate.charAt(0) - '0') * 10 + (examdate.charAt(1) - '0');
        m1 = (today.charAt(3) - '0') * 10 + (today.charAt(4) - '0');
        m2 = (examdate.charAt(3) - '0') * 10 + (examdate.charAt(4) - '0');
        y1 = (today.charAt(6) - '0') * 1000 + (today.charAt(7) - '0') * 100 + (today.charAt(8) - '0') * 10 + (today.charAt(9) - '0');
        y2 = (examdate.charAt(6) - '0') * 1000 + (examdate.charAt(7) - '0') * 100 + (examdate.charAt(8) - '0') * 10 + (examdate.charAt(9) - '0');
        // System.out.println(d1+" "+m1+" "+y1);
        //System.out.println(d2+" "+m2+" "+y2);
        int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        if (d1 == d2 && m1 == m2 && y1 == y2) days = 0;

        else if (m1 == m2 && y1 == y2) {
            if (d1 >= d2) days = 0;
            else days = d2 - d1;
        } else {
            days = month[m1 - 1] - d1; // Calculating number of days remaining for complete m1 month
            if (m1 == 2 && leapYear(y1)) days++;
            int h = m1 + 1; // now from next month calculating days
            for (int i = y1; i <= y2; i++) {
                for (int j = h; j <= 12; j++) {
                    if (i == y2 && j == m2)  // in last month (month that is described in your 2nd date) only adding the days
                    {
                        days += d2;
                        break;
                    } else if (m2 == 2 && leapYear(y1)) days += 29;
                    else {
                        days += month[j - 1]; // simply summing all the months
                    }
                }
                h = 1; // when year changes (j reset) it will start from month 1st=> January
            }
        }
        //System.out.println(days);
        return String.valueOf(days);
    }
}
