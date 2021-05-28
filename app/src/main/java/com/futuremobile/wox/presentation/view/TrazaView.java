package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.domain.model.Traza;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface TrazaView extends BaseView {

    void trazaListSuccess(ArrayList<Traza> trazas);
    void trazasCreateSuccess(boolean success);
    void trazaUpdateSuccess(Traza traza);
    void showErrorMessage(String message);
}
