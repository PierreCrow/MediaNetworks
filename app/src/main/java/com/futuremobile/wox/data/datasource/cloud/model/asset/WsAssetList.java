package com.futuremobile.wox.data.datasource.cloud.model.asset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WsAssetList {

    @SerializedName("data")
    @Expose
    private List<WsAsset> items = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public WsAssetList() {
    }

    /**
     *
     * @param empresas
     */
    public WsAssetList(List<WsAsset> empresas) {
      //  super();
        this.items = items;
    }


    public List<WsAsset> getItems() {
        return items;
    }

    public void setItems(List<WsAsset> items) {
        this.items = items;
    }
}
