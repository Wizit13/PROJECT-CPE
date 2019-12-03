package com.example.projectcpe.ViewModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "admin")
public class Admin {

    @PrimaryKey
    @ColumnInfo(name = "password")
    private int password;

    public Admin(int password) {
        this.password = password;
    }

    public Admin() {
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

}
