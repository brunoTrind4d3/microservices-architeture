package com.trindade.microservices.domain.util;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class ConvertUtils {

    public static Date toDate(String date) {
        try {
            var format = new SimpleDateFormat("yyyy-MM-dd");
            if (date == null) {
                return null;
            }
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date) {
        var format = new SimpleDateFormat("yyyy-MM-dd");

        if (date == null) {
            return null;
        }
        return format.format(date);
    }

    public static String toIndicator(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return Boolean.TRUE.equals(bool) ? "S" : "N";
    }

    public static Boolean toBoolean(String indicator) {
        if (indicator == null) {
            return Boolean.FALSE;
        }
        return "S".equals(indicator);
    }
}
