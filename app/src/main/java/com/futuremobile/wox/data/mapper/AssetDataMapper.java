package com.futuremobile.wox.data.mapper;

import com.futuremobile.wox.data.datasource.cloud.model.asset.WsAsset;
import com.futuremobile.wox.data.datasource.cloud.model.asset.WsAssetList;
import com.futuremobile.wox.data.datasource.cloud.model.asset.WsInsertAsset;
import com.futuremobile.wox.domain.model.Asset;

import java.util.ArrayList;

public class AssetDataMapper {

    public AssetDataMapper() {
    }


    public ArrayList<Asset> transformToExpenseTypeEntity(WsAssetList wsAssetList) {
        ArrayList<Asset> assets = new ArrayList<>();
        for (WsAsset wsAsset : wsAssetList.getItems()) {

            int id = wsAsset.getId();
            int id_categoria = wsAsset.getId_categoria();
            String codigo = wsAsset.getCodigo();
            String codigo_barra = wsAsset.getCodigo_barra();
            String descripcion = wsAsset.getDescripcion();
            String uni_medida = wsAsset.getUni_medida();
            String cod_prod_sunat = wsAsset.getCod_prod_sunat();
            String valor_unitario = wsAsset.getValor_unitario();
            String precio_unitario = wsAsset.getPrecio_unitario();
            int estado = wsAsset.getEstado();
            String created_at = wsAsset.getCreated_at();
            int Category = wsAsset.getWsAssetCategory().getId();
            String nameCategory = wsAsset.getWsAssetCategory().getNombre();
            int inventariado=wsAsset.getInventariado();
            int codigo_unico=wsAsset.getCodigo_unico();
            String tipo=wsAsset.getTipo();
            String tipo_afec_igv=wsAsset.getTipo_afec_igv();
            String desc_corta=wsAsset.getDesc_corta();

            Asset asset = new Asset(id, id_categoria, codigo, codigo_barra, descripcion,
                    uni_medida, cod_prod_sunat, valor_unitario, precio_unitario, estado, created_at,
                    Category, nameCategory, tipo, desc_corta, tipo_afec_igv,
                    inventariado, 0, "", codigo_unico);
            assets.add(asset);

        }
        return assets;
    }


    public WsInsertAsset transformToInsertEntity(Asset asset) {

        WsInsertAsset wsInsertAsset = null;

        if (asset != null) {
            int id_categoria = asset.getId_categoria();
            int id_almacen = asset.getId_almacen();
            String tipo = asset.getTipo();
            String descripcion = asset.getDescripcion();
            String desc_corta = asset.getDescripcion_corta();
            String codigo = asset.getCodigo();
            String codigo_barra = asset.getCodigo_barra();
            String uni_medida = asset.getUni_medida();
            String tipo_afec_igv = asset.getTipo_afec_igv();
            String cod_prod_sunat = asset.getCod_prod_sunat();
            String stock = asset.getStock();
            String valor_unitario = asset.getValor_unitario();
            String precio_unitario = asset.getPrecio_unitario();
            int inventariado = asset.getInventariado();
            int codigo_unico = asset.getCodigo_unico();
            int estado = asset.getEstado();

            wsInsertAsset = new WsInsertAsset(estado, descripcion, id_categoria, id_almacen, tipo, desc_corta,
                    codigo, codigo_barra, uni_medida, cod_prod_sunat, stock, valor_unitario, precio_unitario,
                    tipo_afec_igv, inventariado, codigo_unico);
        }

        return wsInsertAsset;
    }

}
