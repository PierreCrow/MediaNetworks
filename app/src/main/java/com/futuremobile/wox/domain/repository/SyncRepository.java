package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.interactor.sync.SyncCallback;

public interface SyncRepository {

    void sync(String token, SyncCallback syncCallback);

}
