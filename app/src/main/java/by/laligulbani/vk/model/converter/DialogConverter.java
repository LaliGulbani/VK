package by.laligulbani.vk.model.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import by.laligulbani.vk.entity.dialog.Dialog;

import static java.util.Locale.getDefault;

public class DialogConverter implements IConverter<Dialog> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("h:mm a", getDefault());

    @Override
    public Dialog convert(final Dialog source) {

        final Dialog dialog = new Dialog();
        dialog.setBody(source.getBody());
        dialog.setDate(DATE_FORMAT.format(new Date(1000 * Long.valueOf(source.getDate()))));
        dialog.setUid(source.getUid());

        return dialog;
    }
}
