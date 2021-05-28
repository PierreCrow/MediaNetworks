package com.futuremobile.wox.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName="Action")
public class Action implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("idDb")
    private int idDb;
    @SerializedName("id")
    private int id;


    public Action(int id) {
        this.id = id;


    }

    public int getIdDb() {
        return idDb;
    }

    public void setIdDb(int idDb) {
        this.idDb = idDb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
