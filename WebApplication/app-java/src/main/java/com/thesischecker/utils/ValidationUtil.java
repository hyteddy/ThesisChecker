package com.thesischecker.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class with validates method
 * @author Tomasz Morek
 */
public final class ValidationUtil {

    /**
     * Validate date if format is correct
     * @param date
     * @return
     */
    public static boolean validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date preDate = sdf.parse(date);
            String parsedDate = sdf.format(preDate);
            if (date.equals(parsedDate)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Check if date from is before date to
     * Use only if you have valid dates!
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public static boolean validateDateRange(String dateFrom, String dateTo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date from = sdf.parse(dateFrom);
            Date to = sdf.parse(dateTo);
            if (from.equals(to)) {
                return true;
            } else {
                return from.before(to);
            }
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Parse date from String to Date
     * Use only if you have valid date or if String date is empty
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null && date.length() > 0) {
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }
}
