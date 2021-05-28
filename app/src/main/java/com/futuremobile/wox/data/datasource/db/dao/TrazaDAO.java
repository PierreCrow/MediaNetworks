package com.futuremobile.wox.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.futuremobile.wox.data.datasource.db.model.DbTraza;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TrazaDAO {

    @Insert
    void InsertOnlyOne(DbTraza dbTraza);
    @Insert
    void InsertMultiple(ArrayList<DbTraza> dbTrazas);

    @Update
    void Update(DbTraza dbTraza);

    @Delete
    void Delete(DbTraza dbTraza);

    @Query("DELETE  FROM DbTraza")
    void DeleteAll();

    @Query("SELECT * FROM DbTraza")
    List<DbTraza> GetAll();


  //  @Query("UPDATE  Item set Cantidad_Items_Comprobante= :cant, Precio_Unitario= :precio, Valor_Unitario=:valor, Descuento_Item_Comprobante= :descuento WHERE id_item=:id")
  //  void UpdateCantidadPrecioProducto(int id,String cant,String precio,String valor,String descuento);








}
