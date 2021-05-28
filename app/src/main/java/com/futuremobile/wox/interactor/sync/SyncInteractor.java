package com.futuremobile.wox.interactor.sync;

import com.futuremobile.wox.domain.repository.SyncRepository;

public class SyncInteractor {

    private final SyncRepository syncRepository;

    public SyncInteractor(SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    public void sync(String token, SyncCallback syncCallback) {
        syncRepository.sync(token, syncCallback);
    }

}
