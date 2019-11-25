package com.droidbaza.market.database;

import androidx.room.Room;

import android.content.Context;

/**
 * Created by droidbaza on 25/11/19.
 */


public class DbClient {

    private static DbClient mInstance;
    private MyDatabase myDb;

    private DbClient(Context context) {
        myDb = Room.databaseBuilder(context, MyDatabase.class, "MyTabs").build();
    }

    public static synchronized DbClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DbClient(context);
        }
        return mInstance;
    }

    public MyDatabase getMyDb() {
        return myDb;
    }
}
