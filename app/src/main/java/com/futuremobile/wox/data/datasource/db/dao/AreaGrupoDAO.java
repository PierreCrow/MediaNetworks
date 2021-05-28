package com.futuremobile.wox.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.futuremobile.wox.data.datasource.db.model.DbAreaGrupo;
import com.futuremobile.wox.data.datasource.db.model.DbTraza;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface AreaGrupoDAO {

    @Insert
    void InsertOnlyOne(DbAreaGrupo dbAreaGrupo);
    @Insert
    void InsertMultiple(ArrayList<DbAreaGrupo> dbAreaGrupos);

    @Update
    void Update(DbAreaGrupo dbAreaGrupo);

    @Delete
    void Delete(DbAreaGrupo dbAreaGrupo);

    @Query("DELETE  FROM DbAreaGrupo")
    void DeleteAll();

    @Query("SELECT * FROM DbAreaGrupo")
    List<DbAreaGrupo> GetAll();


  //  @Query("UPDATE  Item set Cantidad_Items_Comprobante= :cant, Precio_Unitario= :precio, Valor_Unitario=:valor, Descuento_Item_Comprobante= :descuento WHERE id_item=:id")
  //  void UpdateCantidadPrecioProducto(int id,String cant,String precio,String valor,String descuento);








}
