package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey
    private long userId;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String email;

    public User(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
