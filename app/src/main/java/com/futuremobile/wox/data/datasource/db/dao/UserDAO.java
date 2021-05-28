package com.futuremobile.wox.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.futuremobile.wox.domain.model.Asset;

import java.util.ArrayList;

@Dao
public interface UserDAO {

    @Insert
    void InsertOnlyOne(Asset item);
    @Insert
    void InsertMultiple(ArrayList<Asset> items);

    @Update
    void Update(Asset item);

    @Delete
    void Delete(Asset item);

    @Query("DELETE  FROM Asset")
    void DeleteAll();


  //  @Query("UPDATE  Item set Cantidad_Items_Comprobante= :cant, Precio_Unitario= :precio, Valor_Unitario=:valor, Descuento_Item_Comprobante= :descuento WHERE id_item=:id")
  //  void UpdateCantidadPrecioProducto(int id,String cant,String precio,String valor,String descuento);








}
