package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.domain.model.Asset;

import java.util.ArrayList;

public interface SyncView extends BaseView {

    void syncSuccess(WsSync wsSync);
    void requestSyncSuccess(boolean sync);
    void showErrorMessage(String message);
}
