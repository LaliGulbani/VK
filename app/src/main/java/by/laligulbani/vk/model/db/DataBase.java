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
import java.util.UUID;

import by.laligulbani.vk.entity.dialog.Dialog;
import by.laligulbani.vk.entity.users.UserFull;
import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Function;

import static by.laligulbani.vk.Api.EMPTY;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_ID_USER;
import static java.util.Collections.emptyList;

public class DataBase extends SQLiteOpenHelper implements IDataBase {

    private static final String TABLE_MESSAGE = "message";
    private static final String KEY_ID_USER = "_id_user";
    private static final String KEY_BODY = "_body";
    private static final String KEY_DATA = "_data";

    private static final String TABLE_USERS = "users";
    private static final String KEY_NAME = "_name";
    private static final String KEY_LASTNAME = "_lastname";
    private static final String KEY_CITY = "_city";
    private static final String KEY_BIRTHDAY = "_birthday";
    private static final String KEY_COUNT_FRIENDS = "_count_friends";
    private static final String KEY_COUNT_COMMON = "_count_common";
    private static final String KEY_COUNT_VIDEOS = "_count_videos";
    private static final String KEY_COUNT_FOLLOWERS = "_count_followers";
    private static final String KEY_COUNT_PHOTO = "_count_photo";

    private final Context context;

    DataBase(final Context context,
             final String name,
             final CursorFactory factory,
             final int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MESSAGE + " "
                + "("
                + KEY_ID_USER + " TEXT,"
                + KEY_BODY + " TEXT,"
                + KEY_DATA + " TEXT"
                + ")");

        db.execSQL("CREATE TABLE " + TABLE_USERS + " "
                + "("
                + KEY_ID_USER + " TEXT, "
                + KEY_NAME + " TEXT, "
                + KEY_LASTNAME + " TEXT, "
                + KEY_CITY + " TEXT, "
                + KEY_BIRTHDAY + " TEXT, "
                + KEY_COUNT_FRIENDS + " TEXT, "
                + KEY_COUNT_COMMON + " TEXT, "
                + KEY_COUNT_VIDEOS + " TEXT, "
                + KEY_COUNT_FOLLOWERS + " TEXT, "
                + KEY_COUNT_PHOTO + " TEXT "
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
            values.put(KEY_ID_USER, dialog.getUid());
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
                    dialog.setUid(cursor.getString(0));
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
                dialog.setUid(cursor.getString(0));
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
                dialog.setUid((cursor.getString(0)));
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

        final String query = "SELECT COUNT(" + KEY_ID_USER + ")" + " FROM " + TABLE_MESSAGE + " WHERE " + KEY_ID_USER + "!=" + getUserId();

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToLast()) {
                return cursor.getLong(0);
            }
            return 0L;
        });
    }

    @Override
    public UserFull getUser(final String id) {

        final String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + KEY_ID_USER + "=" + id;

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToLast()) {

                final UserFull user = new UserFull();
                user.setId(cursor.getString(0));
                user.setFirstName(cursor.getString(1));
                user.setLastName(cursor.getString(2));

                return user;
            }

            return null;
        });
    }

    @Override
    public void addUser(final UserFull user) {
        executeWritable((db) -> {

            final String id = user.getId();

            final ContentValues values = new ContentValues();
            values.put(KEY_ID_USER, id == null || id.isEmpty() ? UUID.randomUUID().toString() : id);
            values.put(KEY_NAME, user.getFirstName());
            values.put(KEY_LASTNAME, user.getLastName());
            //values.put(KEY_CITY, String.valueOf(user.getCity()));
            //values.put(KEY_BIRTHDAY, user.getBdate());
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
        return getUserFulls("");
    }

    private List<UserFull> getUserFulls(final String filter) {
        if (getUsersCount() == 0) {
            return emptyList();
        }

        final String query = "SELECT  * FROM " + TABLE_USERS + " " + filter;

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToFirst()) {

                final List<UserFull> users = new ArrayList<UserFull>();

                do {
                    final UserFull user = new UserFull();
                    user.setId(cursor.getString(0));
                    user.setFirstName(cursor.getString(1));
                    user.setLastName(cursor.getString(2));

                    users.add(user);
                } while (cursor.moveToNext());

                return users;
            }
            return emptyList();
        });
    }

    @Override
    public List<UserFull> getFriends() {
        return getUserFulls("WHERE " + KEY_ID_USER + "!=" + getUserId());
    }

    private Long getUsersCount() {

        final String query = "SELECT COUNT(" + KEY_ID_USER + ")" + " FROM " + TABLE_USERS;

        return executeReadable(query, (cursor) -> {
            if (cursor.moveToLast()) {
                return cursor.getLong(0);
            }
            return 0L;
        });
    }

    private String getUserId() {
        return context
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_ID_USER, EMPTY);
    }

    private <T> T executeReadable(final String query, final Function<T, Cursor> function) {
        final SQLiteDatabase db = getReadableDatabase();
        final Cursor cursor = db.rawQuery(query, null);
        return function.apply(cursor);
    }

    private void executeWritable(final Consumer<SQLiteDatabase> consumer) {
        final SQLiteDatabase db = getWritableDatabase();
        consumer.accept(db);
    }
}
