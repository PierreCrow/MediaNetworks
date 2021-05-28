package com.futuremobile.wox.interactor.sync;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;

import java.util.ArrayList;

public interface SyncCallback {

    void onSyncSuccess(WsSync wsSync);
    void onSyncError(String message);
}
