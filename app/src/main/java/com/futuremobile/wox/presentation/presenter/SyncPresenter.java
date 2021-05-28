package com.futuremobile.wox.presentation.presenter;

import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.datastore.SyncDataStoreFactory;
import com.futuremobile.wox.data.repository.SyncDataRepository;
import com.futuremobile.wox.domain.repository.SyncRepository;
import com.futuremobile.wox.interactor.sync.SyncCallback;
import com.futuremobile.wox.interactor.sync.SyncInteractor;
import com.futuremobile.wox.presentation.view.SyncView;

public class SyncPresenter implements Presenter<SyncView>,
        SyncCallback {


    private SyncView syncView;
    private SyncInteractor syncInteractor;


    public void sync(String token) {
        syncInteractor.sync(token, this);
    }

    public void requestSync(String token) {
        syncInteractor.sync(token, this);
    }

    public void confirmSync(String token) {
        syncInteractor.sync(token, this);
    }


    @Override
    public void addView(SyncView view) {
        this.syncView = view;
        SyncRepository syncRepository = new SyncDataRepository(new SyncDataStoreFactory(this.syncView.getContext()));
        syncInteractor = new SyncInteractor(syncRepository);
    }

    @Override
    public void removeView(SyncView view) {

    }


    @Override
    public void onSyncSuccess(WsSync wsSync) {
        syncView.syncSuccess(wsSync);
    }

    @Override
    public void onSyncError(String message) {
        syncView.showErrorMessage(message);
    }
}
