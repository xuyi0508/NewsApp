package com.example.liyuchen.information;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbThread extends Thread {
    private String name;
    private Context context;
    public DbThread(String Name, Context context) {
        this.name = Name;
    }

    @Override
    public void run() {
        NewsDatabaseHelper dbHelper = new NewsDatabaseHelper(this.context, this.name, null, 1);
        while(true) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }
        }
    }
}

class NewsDatabaseHelper extends SQLiteOpenHelper {
    public NewsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String regionInfoTable = "create table regionInfo(Country varchar, Province varchar, County varchar, StartDate date)";
        String regionDailyInfoTable = "create table regionDailyInfo(Country varchar, Province varchar, County varchar, Day int(3), Confirmed int(8), Cured int(8), Dead int(8), Risk int(3))";
        String eventTable = "create table event(ID varchar, Type varchar, Title varchar, Category varchar, Time varchar, Lang varchar)";
        String newsTable = "create table news(ID varchar, Type varchar, Title varchar, Content varchar, Date varchar, Time varchar, Source varchar, OriginURL varchar , Lang varchar)";
        String relatedEventsTable = "create table relatedEvents(ID varchar, RelatedID varchar, Score real)";

        sqLiteDatabase.execSQL(regionInfoTable);
        sqLiteDatabase.execSQL(regionDailyInfoTable);
        sqLiteDatabase.execSQL(eventTable);
        sqLiteDatabase.execSQL(newsTable);
        sqLiteDatabase.execSQL(relatedEventsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}


