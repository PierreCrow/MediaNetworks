package com.futuremobile.wox.data.datasource.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName="Client")
public class DbExecutionData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("idDb")
    private int idDb;
    @SerializedName("id")
    private int id;

    @SerializedName("sync")
    private boolean sync;



    public DbExecutionData(int id) {
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
