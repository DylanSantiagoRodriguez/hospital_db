package com.hospital.version1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }
}
