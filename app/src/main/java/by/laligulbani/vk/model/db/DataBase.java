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
import by.laligulbani.vk.entity.users.User;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Function;

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
                + KEY_ID_USER + " TEXT,"
                + KEY_BODY + " TEXT,"
                + KEY_DATA + " TEXT"
                + ")");

        db.execSQL("CREATE TABLE " + TABLE_USERS
                + "("
                + KEY_ID_USER + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_LASTNAME + " TEXT,"
                + KEY_CITY + " TEXT,"
                + KEY_BIRTHDAY  + " TEXT,"
                + KEY_COUNT_FRIENDS + " TEXT,"
                + KEY_COUNT_COMMON + " TEXT,"
                + KEY_COUNT_VIDEOS  + " TEXT,"
                + KEY_COUNT_FOLLOWERS + " TEXT,"
                + KEY_COUNT_PHOTO + " TEXT"
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
        executeWritable((db) -> {

            final ContentValues values = new ContentValues();
            values.put(KEY_ID_USER, dialog.getId());
            values.put(KEY_BODY, dialog.getBody());
            values.put(KEY_DATA, dialog.getDate());

            db.insert(TABLE_MESSAGE, null, values);
        });
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

        final String query = "SELECT  * FROM " + TABLE_MESSAGE;

        return executeReadable(query, (cursor) -> {
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
        });
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

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToLast()) {

                final Dialog dialog = new Dialog();
                dialog.setId(cursor.getString(0));
                dialog.setBody(cursor.getString(1));
                dialog.setDate(cursor.getString(2));

                return dialog;
            }

            return null;
        });
    }

    @Override
    public Dialog getDialogById(int id) {

        final String query = "SELECT  * FROM " + TABLE_MESSAGE
                + " WHERE " + KEY_ID_USER + "=" + id;

        return executeReadable(query, (cursor) -> {

            if (cursor.moveToFirst()) {

                final Dialog dialog = new Dialog();
                dialog.setId((cursor.getString(0)));
                dialog.setBody(cursor.getString(1));
                dialog.setDate(cursor.getString(2));

                return dialog;
            }
            return null;
        });
    }

    @Override
    public Long getDialogCount() {

        final String query = "SELECT COUNT(" + KEY_DATA + ")" + " FROM " + TABLE_MESSAGE;

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToLast()) {
                return cursor.getLong(0);
            }
            return 0L;
        });
    }


    @Override
    public Long getFriendsAmount() {
        return 0L;
    }

    @Override
    public User getUser(final String id) {
        return null;
    }

    @Override
    public void addUser(final UserFull user) {
        executeWritable((db) -> {

            final ContentValues values = new ContentValues();
            values.put(KEY_USER_ID, user.getId());
            values.put(KEY_NAME, user.getFirstName());
            values.put(KEY_LASTNAME, user.getLastName());
            values.put(KEY_CITY, String.valueOf(user.getCity()));
            values.put(KEY_BIRTHDAY, user.getBdate());
            //values.put(KEY_COUNT_FRIENDS, user.);
            //values.put(KEY_COUNT_COMMON, user.);
            //values.put(KEY_COUNT_VIDEOS, user.);
            //values.put(KEY_COUNT_FOLLOWERS, user.);
            //values.put(KEY_COUNT_PHOTO, user.;

            db.insert(TABLE_USERS, null, values);
        });


    }

    @Override
    public List<UserFull> getUsers() {
        return emptyList();
    }

    private <T> T executeReadable(final String query, final Function<T, Cursor> function) {
        try (final SQLiteDatabase db = getReadableDatabase();
             final Cursor cursor = db.rawQuery(query, null)) {
            return function.apply(cursor);
        }
    }

    private void executeWritable(final Consumer<SQLiteDatabase> consumer) {
        try (final SQLiteDatabase db = getWritableDatabase()) {
            consumer.accept(db);
        }
    }
}
