package com.example.myapplication.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.myapplication.db.beans.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);
}
