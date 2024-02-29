package com.fiqrikm18;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solution("12:05:45PM");
    }

    public static void solution(String time) {
        String[] timeArr = time.split(":");
        DecimalFormat formatter = new DecimalFormat("00", new DecimalFormatSymbols());
        String formattedTime = "";
        String hour = "";
        String minutes = "";
        String seconds = "";

        if (timeArr[timeArr.length - 1].contains("PM")) {
            int checkHour = Integer.parseInt(timeArr[0]) + 12 == 24 ? 0 : Integer.parseInt(timeArr[0]) + 12;
            hour = formatter.format(checkHour);
        }
        else hour = formatter.format(Integer.parseInt(timeArr[0]));

        minutes = formatter.format(Integer.parseInt(timeArr[1]));
        seconds = formatter.format(Integer.parseInt(timeArr[timeArr.length - 1].substring(0, timeArr.length - 2)));

        formattedTime = hour + ":" + minutes + ":" + seconds;
        System.out.println(formattedTime);
    }
}