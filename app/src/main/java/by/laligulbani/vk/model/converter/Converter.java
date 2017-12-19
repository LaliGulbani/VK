package by.laligulbani.vk.model.converter;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {

    Converter() {

    }

    public static String getDate(String milliSeconds) {
        Date date = new Date(milliSeconds);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateformat = new SimpleDateFormat("h:mm a");
        return dateformat.format(date);
    }
}
