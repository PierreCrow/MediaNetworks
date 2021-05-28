package com.futuremobile.wox.data.repository;


import com.futuremobile.wox.data.datasource.cloud.model.sync.WsSync;
import com.futuremobile.wox.data.datasource.datastore.SyncDataStore;
import com.futuremobile.wox.data.datasource.datastore.SyncDataStoreFactory;
import com.futuremobile.wox.domain.repository.RepositoryCallback;
import com.futuremobile.wox.domain.repository.SyncRepository;
import com.futuremobile.wox.interactor.sync.SyncCallback;
import com.futuremobile.wox.presentation.utiles.Constantes;

public class SyncDataRepository implements SyncRepository {

    private final SyncDataStoreFactory syncDataStoreFactory;

    public SyncDataRepository(SyncDataStoreFactory syncDataStoreFactory) {
        this.syncDataStoreFactory = syncDataStoreFactory;
    }


    @Override
    public void sync(String token, SyncCallback syncCallback) {
        final SyncDataStore syncDataStore = syncDataStoreFactory.create(Constantes.STORE.CLOUD);
        syncDataStore.sync(token, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                syncCallback.onSyncError(message);
            }

            @Override
            public void onSuccess(Object object) {
                WsSync wsSync= (WsSync) object;
                syncCallback.onSyncSuccess(wsSync);
            }
        });
    }
}
