package com.example.myapplication;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.db.AppDatabase;

public class App extends Application {

    AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(this, AppDatabase.class,"db_names.db")
                .allowMainThreadQueries()
                .build();
    }
}
