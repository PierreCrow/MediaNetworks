package com.futuremobile.wox.presentation.view;

import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;

public interface LineaTiempoView extends BaseView {

    void lineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos);
    void lineaTiemposCreateSuccess(boolean success);
    void lineaTiemposIniAccionSuccess(boolean success);
    void lineaTiemposFinAccionSuccess(boolean success);
    void lineaTiempoUpdateSuccess(LineaTiempo lineaTiempo);
    void showErrorMessage(String message);
}
