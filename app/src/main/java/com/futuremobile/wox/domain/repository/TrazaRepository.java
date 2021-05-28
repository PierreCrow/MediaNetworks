package com.futuremobile.wox.domain.repository;

import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.interactor.traza.TrazaCreateCallback;
import com.futuremobile.wox.interactor.traza.TrazaListCallback;
import com.futuremobile.wox.interactor.traza.TrazaUpdateCallback;

import java.util.List;

public interface TrazaRepository {

    void getTrazas(TrazaListCallback trazaListCallback);

    void updateTraza(int store, Traza traza, TrazaUpdateCallback trazaUpdateCallback);

    void createTrazas(List<Traza> trazas, TrazaCreateCallback trazaCreateCallback);

}
