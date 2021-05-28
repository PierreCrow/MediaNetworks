package com.futuremobile.wox.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.domain.model.Asset;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface WorkOrderDAO {

    @Insert
    void InsertOnlyOne(DbWorkOrder dbWorkOrder);
    @Insert
    void InsertMultiple(ArrayList<DbWorkOrder> workOrders);

    @Update
    void Update(DbWorkOrder workOrder);

    @Delete
    void Delete(DbWorkOrder workOrder);

    @Query("DELETE  FROM DbWorkOrder")
    void DeleteAll();

    @Query("SELECT * FROM DbWorkOrder")
    List<DbWorkOrder> GetAll();


  //  @Query("UPDATE  Item set Cantidad_Items_Comprobante= :cant, Precio_Unitario= :precio, Valor_Unitario=:valor, Descuento_Item_Comprobante= :descuento WHERE id_item=:id")
  //  void UpdateCantidadPrecioProducto(int id,String cant,String precio,String valor,String descuento);








}
