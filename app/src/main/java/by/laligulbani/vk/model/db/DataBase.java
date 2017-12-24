package by.laligulbani.vk.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.messages.Dialog;

import static java.lang.String.valueOf;
import static java.util.Collections.emptyList;

public class DataBase extends SQLiteOpenHelper implements IDataBase {

    private static final String TABLE_MESSAGE = "message";
    private static final String KEY_ID_USER = "_id_user";
    private static final String KEY_BODY = "_body";
    private static final String KEY_DATA = "_data";

    private static final String TABLE_USERS = "users";
    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_NAME = "_name";
    private static final String KEY_LASTNAME = "_lastname";
    private static final String KEY_CITY = "_city";
    private static final String KEY_BIRTHDAY = "_birthday";
    private static final String KEY_COUNT_FRIENDS = "_count_friends";
    private static final String KEY_COUNT_COMMON = "_count_common";
    private static final String KEY_COUNT_VIDEOS = "_count_videos";
    private static final String KEY_COUNT_FOLLOWERS = "_count_followers";
    private static final String KEY_COUNT_PHOTO = "_count_photo";


    DataBase(final Context context,
             final String name,
             final CursorFactory factory,
             final int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MESSAGE
                + "("
                + KEY_ID_USER + " TEXT UNIQUE,"
                + KEY_BODY + " TEXT,"
                + KEY_DATA + " TEXT"
                + ")");

        db.execSQL("CREATE TABLE " + TABLE_USERS
                + "("
                + KEY_ID_USER + " TEXT UNIQUE,"
                + KEY_BODY + " TEXT,"
                + KEY_DATA + " TEXT"
                + ")");
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }

    @Override
    public void addDialog(final Dialog dialog) {
        try (final SQLiteDatabase db = getWritableDatabase()) {

            final ContentValues values = new ContentValues();
            values.put(KEY_ID_USER, dialog.getId());
            values.put(KEY_BODY, dialog.getBody());
            values.put(KEY_DATA, dialog.getDate());

            db.insert(TABLE_MESSAGE, null, values);
        }
    }

    @Override
    public void addDialogs(final Collection<Dialog> dialogs) {
        for (final Dialog dialog : dialogs) {
            addDialog(dialog);
        }
    }

    @Override
    public List<Dialog> getDialogs() {

        if (getDialogCount() == 0) {
            return emptyList();
        }

        final String selectQuery = "SELECT  * FROM " + TABLE_MESSAGE;

        try (final SQLiteDatabase db = getReadableDatabase();
             final Cursor cursor = db.rawQuery(selectQuery, null)) {

            if (cursor.moveToFirst()) {

                final List<Dialog> dialogs = new ArrayList<Dialog>();

                do {
                    final Dialog dialog = new Dialog();
                    dialog.setId(cursor.getString(0));
                    dialog.setBody(cursor.getString(1));
                    dialog.setDate(cursor.getString(2));

                    dialogs.add(dialog);
                } while (cursor.moveToNext());

                return dialogs;
            }
            return emptyList();
        }
    }

    @Override
    public Dialog getLastDialog() {

        if (getDialogCount() == 0) {
            return null;
        }

        final String query = "SELECT * "
                + "FROM " + TABLE_MESSAGE + " "
                + "WHERE " + KEY_DATA + " "
                + "IN "
                + "("
                + "SELECT MAX(" + KEY_DATA + ") "
                + "FROM " + TABLE_MESSAGE + " "
                + "GROUP BY " + KEY_DATA
                + ")";

        try (final SQLiteDatabase db = getReadableDatabase();
             final Cursor cursor = db.rawQuery(query, null)) {

            if (cursor.moveToLast()) {

                final Dialog dialog = new Dialog();
                dialog.setId(cursor.getString(0));
                dialog.setBody(cursor.getString(1));
                dialog.setDate(cursor.getString(2));

                return dialog;
            }

            return null;
        }
    }

    @Override
    public Dialog getDialogById(int id) {

        try (final SQLiteDatabase db = getReadableDatabase();
             final Cursor cursor = db.query(TABLE_MESSAGE,
                     new String[]{KEY_ID_USER, KEY_BODY, KEY_DATA}, KEY_ID_USER + "=?",
                     new String[]{valueOf(id)}, null, null, null, null)) {

            if (cursor.moveToFirst()) {

                final Dialog dialog = new Dialog();
                dialog.setId((cursor.getString(0)));
                dialog.setBody(cursor.getString(1));
                dialog.setDate(cursor.getString(2));

                return dialog;
            }
            return null;
        }
    }

    @Override
    public Long getDialogCount() {

        final String query = "SELECT COUNT(" + KEY_DATA + ")"
                + " FROM " + TABLE_MESSAGE;

        try (final SQLiteDatabase db = getReadableDatabase();
             final Cursor cursor = db.rawQuery(query, null)) {

            if (cursor.moveToLast()) {
                return cursor.getLong(0);
            }
            return 0L;
        }
    }
}
