package by.laligulbani.vk.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDataBase extends SQLiteOpenHelper  {

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



    public UsersDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }


}
