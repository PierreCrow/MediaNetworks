package com.futuremobile.wox.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.futuremobile.wox.data.datasource.db.model.DbLineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface LineaTiempoDAO {

    @Insert
    void InsertOnlyOne(DbLineaTiempo dbLineaTiempo);
    @Insert
    void InsertMultiple(ArrayList<DbLineaTiempo> dbLineaTiempos);

    @Update
    void Update(DbLineaTiempo dbLineaTiempo);

    @Delete
    void Delete(DbLineaTiempo dbLineaTiempo);

    @Query("DELETE  FROM DbLineaTiempo")
    void DeleteAll();

    @Query("SELECT * FROM DbLineaTiempo")
    List<DbLineaTiempo> GetAll();


    @Query("UPDATE  DbLineaTiempo set inicio= :ini, sync= :sync WHERE id=:id")
    void UpdateIni(int id,String ini,Boolean sync);


    @Query("UPDATE  DbLineaTiempo set fin= :fin,observacion= :obs, sync= :sync WHERE id=:id")
    void UpdateFin(int id,String fin,String obs,boolean sync);









}
