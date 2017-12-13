package by.laligulbani.vk.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.entity.messages.Message;

public class SqLiteDataBase extends SQLiteOpenHelper implements IDataBase {

    private static final String TABLE_MESSAGE = "message";

    SqLiteDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MESSAGE + "("
                + "id" + " TEXT,"
                + "body" + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
        onCreate(db);
    }

    @Override
    public void saveMessage(Message message) {

        final ContentValues values = new ContentValues();
        values.put("id", message.getId());
        values.put("body", message.getBody());

        getWritableDatabase().insert(TABLE_MESSAGE, null, values);
    }

    @Override
    public List<Message> getMessages() {
        final SQLiteDatabase db = getReadableDatabase();

        List<Message> messages = new ArrayList<Message>();

        String selectQuery = "SELECT  * FROM " + TABLE_MESSAGE;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Message message = new Message();
                message.setId(cursor.getString(0));
                message.setBody(cursor.getString(1));

                messages.add(message);
            } while (cursor.moveToNext());
        }

        return messages;
    }

    @Override
    public Message getLastMessage(){
        //TODO достать последее сообщение из бд

        return null;
    }

    @Override
    public List<Message> getMessageForId(String id){
        //TODO достать сообщение по id из бд
        return null;
    }
}
