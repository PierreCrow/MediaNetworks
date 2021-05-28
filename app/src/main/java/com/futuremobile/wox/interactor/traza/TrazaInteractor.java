package com.futuremobile.wox.interactor.traza;

import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.domain.repository.TrazaRepository;
import com.futuremobile.wox.domain.repository.WorkOrderRepository;
import com.futuremobile.wox.interactor.workorder.WorkOrderCreateCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderListCallback;
import com.futuremobile.wox.interactor.workorder.WorkOrderUpdateCallback;

import java.util.List;

public class TrazaInteractor {

    private final TrazaRepository trazaRepository;

    public TrazaInteractor(TrazaRepository trazaRepository) {
        this.trazaRepository = trazaRepository;
    }

    public void getTrazas(TrazaListCallback trazaListCallback) {
        trazaRepository.getTrazas(trazaListCallback);
    }

    public void updateTraza(int store,Traza traza, TrazaUpdateCallback trazaUpdateCallback) {
        trazaRepository.updateTraza(store,traza, trazaUpdateCallback);
    }

    public void createTrazas(List<Traza> trazas, TrazaCreateCallback trazaCreateCallback) {
        trazaRepository.createTrazas(trazas, trazaCreateCallback);
    }

}
