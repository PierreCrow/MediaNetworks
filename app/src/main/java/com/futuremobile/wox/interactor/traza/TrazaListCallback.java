package com.futuremobile.wox.interactor.traza;

import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface TrazaListCallback {

    void onTrazaListSuccess(ArrayList<Traza> trazas);
    void onTrazaListError(String message);
}
