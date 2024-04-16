package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {
 
    public static List<Integer> getDaysOfCurrentWeek() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        List<Integer> daysOfWeek = new ArrayList<>();
        LocalDate date = firstDayOfCurrentWeek;
        while (date.getDayOfWeek() != DayOfWeek.SATURDAY) { 
            daysOfWeek.add(date.getDayOfMonth());
            date = date.plusDays(1);
        }
        daysOfWeek.add(date.getDayOfMonth());
        return daysOfWeek;
    }
     
    public static int getCurrentDay() {
        LocalDate today = LocalDate.now();
        return today.getDayOfMonth();
    }
     
     public static String getCurrentMonthAndYear() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return today.format(formatter);
    }
     
    public static LocalDate stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return LocalDate.parse(date, formatter);
    }
     
    public static boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
