package ru.jblab.subscribe.util;

import ru.jblab.subscribe.form.FilterForm;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ainurminibaev on 06.11.15.
 */
public class Utils {

    public static FilterForm fixForm(FilterForm filterForm) {
        if (filterForm == null) {
            filterForm = new FilterForm();
        }
        if (filterForm.getPage() == null) {
            filterForm.setPage(0);
        }
        return filterForm;
    }

    public static String cutByWord(String str, int length) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("(?<=.{" + length + "})\\b.*", "");
    }

    public static String toRusString(Long time) {
        Locale russian = new Locale("ru");
        String[] newMonths = {
                "января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(russian);
        dfs.setMonths(newMonths);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, russian);
        SimpleDateFormat sdf = (SimpleDateFormat) df;
        sdf.setDateFormatSymbols(dfs);
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(time);
        return sdf.format(date.getTime());
    }

    public static void main(String[] args) {
        System.out.println(toRusString(new Date().getTime()));
    }

}
