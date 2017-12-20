package by.laligulbani.vk.model.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.laligulbani.vk.entity.messages.Message;

public class SqLiteDataBase extends SQLiteOpenHelper implements IDataBase {

    private static final String TABLE_MESSAGE = "message";
    private static final String KEY_ID = "_id";
    private static final String KEY_BODY = "_body";
    private static final String KEY_DATA = "_data";

    SqLiteDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MESSAGE + "("
                + KEY_ID + " TEXT,"
                + KEY_BODY + " TEXT," + KEY_DATA + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
        onCreate(db);
    }

    @Override
    public void addMessage(final Message message) {

        final SQLiteDatabase db = getWritableDatabase();

        final ContentValues values = new ContentValues();
        values.put(KEY_ID, message.getId());
        values.put(KEY_BODY, message.getBody());
        values.put(KEY_DATA,message.getDate());

        db.insert(TABLE_MESSAGE, null, values);
        db.close();
    }

    @Override
    public void addMessages(final Collection<Message> messages) {
        for (final Message message : messages) {
            addMessage(message);
        }
    }

    @Override
    public List<Message> getMessages() {
        //TODO получить list сообщений, все сообщения
        final SQLiteDatabase db = getReadableDatabase();

        List<Message> messages = new ArrayList<Message>();

        String selectQuery = "SELECT  * FROM " + TABLE_MESSAGE;
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Message message = new Message();
                message.setId(cursor.getString(0));
                message.setBody(cursor.getString(1));
                message.setDate(cursor.getString(2));

                messages.add(message);
            } while (cursor.moveToNext());
        }

        return messages;
    }

    @Override
    public Message getLastMessage() {
        //TODO достать последее сообщение из бд

        SQLiteDatabase db = getWritableDatabase();

        String selectQuery = "SELECT " + KEY_ID + ", "
                + KEY_BODY + ", " + KEY_DATA + " FROM " + TABLE_MESSAGE;

        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        Message message = new Message();
        message.setId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
        message.setBody(cursor.getString(cursor.getColumnIndex(KEY_BODY)));
        message.setDate(cursor.getString(cursor.getColumnIndex(KEY_DATA)));
        db.close();

        return message;
    }

    @Override
    public Message getMessageForId(int id) {
        //TODO достать сообщение по id из бд
        Message message = new Message();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.query(TABLE_MESSAGE, new String[]{KEY_ID,
                        KEY_BODY, KEY_DATA}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            message.setId((cursor.getString(0)));
            message.setBody(cursor.getString(1));
            message.setDate(cursor.getString(2));
        }

        return message;
    }

}
