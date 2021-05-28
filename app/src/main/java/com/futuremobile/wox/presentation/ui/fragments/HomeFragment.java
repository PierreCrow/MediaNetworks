package com.futuremobile.wox.presentation.ui.fragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.AreaGrupo;
import com.futuremobile.wox.domain.model.UserPreference;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.presentation.presenter.AreaGrupoPresenter;
import com.futuremobile.wox.presentation.presenter.WorkOrderPresenter;
import com.futuremobile.wox.presentation.ui.activities.mt_WorkOrder_Activity;
import com.futuremobile.wox.presentation.ui.adapterlist.mt_WorkOrder_AdapterList;
import com.futuremobile.wox.presentation.ui.dialogfragments.mt_Filter_Dialog;
import com.futuremobile.wox.presentation.utiles.Constantes;
import com.futuremobile.wox.presentation.utiles.Helperr;
import com.futuremobile.wox.presentation.utiles.TransparentProgressDialog;
import com.futuremobile.wox.presentation.view.AreaGrupoView;
import com.futuremobile.wox.presentation.view.WorkOrderView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements
        mt_WorkOrder_AdapterList.OnItemClickListener,
        mt_Filter_Dialog.onCloseFilters, WorkOrderView, AreaGrupoView {

    RecyclerView rvWorkOrders;
    ArrayList<WorkOrder> workOrders;
    ArrayList<WorkOrder> workOrdersFilter;
    mt_WorkOrder_AdapterList adapter;
    mt_WorkOrder_AdapterList.OnItemClickListener listener;
    TextView tvBorrarFiltros, tvEstado, tvGrupo, tvTipoTrabajo;
    LinearLayout llFiltros;
    EditText etSearch;
    WorkOrderPresenter workOrderPresenter;
    AreaGrupoPresenter areaGrupoPresenter;
    ArrayList<AreaGrupo> areaGrupos;
    public static int ID_WORK_ORDER;
    TransparentProgressDialog loading;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.home_fragment, null);
        initUIREAL(x);
        clickEvents();

        UserPreference userPreference = Helperr.getUserAppPreference(getContext());
        if (userPreference.isLogged()) {
            if (!loading.isShowing()) {
                loading.show();
            }
            loadPresenter();
        } else {
            netValidation(4);
        }

        return x;
    }

    void correRecien() {
        loadPresenter();
    }

    private void netValidation(int seconds) {
        if (!loading.isShowing()) {
            loading.show();
        }
        int tiempo = seconds * 1000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                correRecien();

                //  handler.postDelayed(this, tiempo);
            }
        };
        handler.postDelayed(runnable, tiempo);
    }


    void loadPresenter() {

        //    if (!loading.isShowing()) {
        //      loading.show();
        //  }

        workOrderPresenter = new WorkOrderPresenter();
        workOrderPresenter.addView(this);
        workOrderPresenter.getWorkOrders();

        areaGrupoPresenter = new AreaGrupoPresenter();
        areaGrupoPresenter.addView(this);
        areaGrupoPresenter.getAreaGrupos();
    }

    void initUIREAL(View x) {

        tvBorrarFiltros = (TextView) x.findViewById(R.id.tvBorrarFiltros);
        tvEstado = (TextView) x.findViewById(R.id.tvEstado);
        tvGrupo = (TextView) x.findViewById(R.id.tvGrupo);
        tvTipoTrabajo = (TextView) x.findViewById(R.id.tvTipoTrabajo);
        llFiltros = (LinearLayout) x.findViewById(R.id.llFiltros);
        rvWorkOrders = (RecyclerView) x.findViewById(R.id.rvWorkOrders);
        etSearch = (EditText) x.findViewById(R.id.etSearch);
        listener = this;
        loading = new TransparentProgressDialog(getContext());

        buscador();
    }


    void clickEvents() {

        tvBorrarFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llFiltros.setVisibility(View.GONE);
                tvEstado.setText("");
                tvGrupo.setText("");
                tvTipoTrabajo.setText("");

                workOrdersFilter = workOrders;
                cargaData(workOrders);
            }
        });

    }

    void buscador() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void afterTextChanged(final Editable s) {

                buscarWorkOrders(s.toString());

                //avoid triggering event when text is too short
                if (s.length() >= 3) {

                }
            }
        });
    }


    void buscarWorkOrders(String name) {

        ArrayList<WorkOrder> workOrdersFiltradas = new ArrayList<>();

        for (WorkOrder workOrder : workOrders) {

            if (workOrder.getDescripcion() != null) {
                if (workOrder.getAsunto() != null) {
                    if (workOrder.getDescripcion().contains(name) ||
                            workOrder.getAsunto().contains(name)) {
                        workOrdersFiltradas.add(workOrder);
                    }
                }
            }
        }

        workOrdersFilter = workOrdersFiltradas;

        cargaData(workOrdersFiltradas);

    }


    @Override
    public void onItemWOClicked(View v, WorkOrder workOrder) {

        if (workOrder.getEstado() == Constantes.ESTADO_WORK_ORDER.PLANEADO) {
            ID_WORK_ORDER = workOrder.getId();
            Intent intent = new Intent(getContext(), mt_WorkOrder_Activity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "Orden de trabajo tiene que estar en estado Planeado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void closeFilters(String estado, String grupo, String tipoTrabajo) {

        if (estado.equals("Todos") && grupo.equals("Todos") && tipoTrabajo.equals("Todos")) {

        } else {

            if (estado.equals("Todos")) {
                tvEstado.setVisibility(View.GONE);
            } else {
                tvEstado.setText(estado);
            }

            if (grupo.equals("Todos")) {
                tvGrupo.setVisibility(View.GONE);
            } else {
                tvGrupo.setText(grupo);
            }

            if (tipoTrabajo.equals("Todos")) {
                tvTipoTrabajo.setVisibility(View.GONE);
            } else {
                tvTipoTrabajo.setText(tipoTrabajo);
            }

            llFiltros.setVisibility(View.VISIBLE);
            workOrdersFilter = buscaPorFiltros(estado, grupo, tipoTrabajo);
            cargaData(workOrdersFilter);
        }
    }

    ArrayList<WorkOrder> buscaPorFiltros(String estado, String grupo, String tipoTrabajo) {

        ArrayList<WorkOrder> workOrdersFiltersss = new ArrayList<>();
        Integer estadoo = null, grupoo = null, tipoTrabajoo = null;

        switch (estado) {
            case "Registrado":
                estadoo = Constantes.ESTADO_WORK_ORDER.REGISTRADO;
                break;
            case "Planeado":
                estadoo = Constantes.ESTADO_WORK_ORDER.PLANEADO;
                break;
            case "Activado":
                estadoo = Constantes.ESTADO_WORK_ORDER.ACTIVADO;
                break;
            case "Finalizado":
                estadoo = Constantes.ESTADO_WORK_ORDER.FINALIZADO;
                break;
        }

        switch (tipoTrabajo) {
            case "Comercial":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.COMERCIAL;
                break;
            case "Correctivo":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.CORRECTIVO;
                break;
            case "Dispositivos":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.DISPOSITIVOS;
                break;
            case "Herramientas":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.HERRAMIENTAS;
                break;
            case "Hosting":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.HOSTING;
                break;
            case "Infraestructura TI":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.INFRAESTRUCTURA_TI;
                break;
            case "Nuevos despliuegues HW":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.NUEVOS_DESPLIEGUES_HW;
                break;
            case "Preventivo":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.PREVENTIVO;
                break;
            case "Programador":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.PROGRAMADOR;
                break;
            case "Provision":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.PROVISION;
                break;
            case "Release SW":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.RELEASE_SW;
                break;
            case "Seguridad":
                tipoTrabajoo = Constantes.TIPO_TRABAJO.SEGURIDAD;
                break;
        }


        for (AreaGrupo areaGrupo : areaGrupos) {
            if (areaGrupo.getNombre().equals(grupo)) {
                grupoo = areaGrupo.getId();
            }
        }


        if (!estado.equals("Todos") && grupo.equals("Todos") && tipoTrabajo.equals("Todos")) {

            //busca solo estado
            for (WorkOrder workOrder : workOrders) {
                if (workOrder.getEstado() == estadoo) {
                    workOrdersFiltersss.add(workOrder);
                }
            }
        } else {
            if (estado.equals("Todos") && !grupo.equals("Todos") && tipoTrabajo.equals("Todos")) {
                //busca solo en grupo
                for (WorkOrder workOrder : workOrders) {
                    if (workOrder.getArea_id() == grupoo) {
                        workOrdersFiltersss.add(workOrder);
                    }
                }

            } else {
                if (estado.equals("Todos") && grupo.equals("Todos") && !tipoTrabajo.equals("Todos")) {
                    //busca solo tipo trabajo
                    for (WorkOrder workOrder : workOrders) {
                        if (workOrder.getTipo_solicitud() == tipoTrabajoo) {
                            workOrdersFiltersss.add(workOrder);
                        }
                    }
                } else {
                    if (!estado.equals("Todos") && !grupo.equals("Todos") && tipoTrabajo.equals("Todos")) {
                        //busca en estado y grupo
                        for (WorkOrder workOrder : workOrders) {
                            if (workOrder.getEstado() == estadoo && workOrder.getArea_id() == grupoo) {
                                workOrdersFiltersss.add(workOrder);
                            }
                        }

                    } else {
                        if (!estado.equals("Todos") && grupo.equals("Todos") && !tipoTrabajo.equals("Todos")) {
                            //busca en estado y tipo de trabajo
                            for (WorkOrder workOrder : workOrders) {
                                if (workOrder.getEstado() == estadoo && workOrder.getTipo_solicitud() == tipoTrabajoo) {
                                    workOrdersFiltersss.add(workOrder);
                                }
                            }
                        } else {
                            if (estado.equals("Todos") && !grupo.equals("Todos") && !tipoTrabajo.equals("Todos")) {
                                //busca en grupo y tipo de trabajo
                                for (WorkOrder workOrder : workOrders) {
                                    if (workOrder.getArea_id() == grupoo && workOrder.getTipo_solicitud() == tipoTrabajoo) {
                                        workOrdersFiltersss.add(workOrder);
                                    }
                                }
                            } else {
                                if (!estado.equals("Todos") && !grupo.equals("Todos") && !tipoTrabajo.equals("Todos")) {
                                    //busca en todooo
                                    for (WorkOrder workOrder : workOrders) {
                                        if (workOrder.getEstado() == estadoo && workOrder.getTipo_solicitud() == tipoTrabajoo && workOrder.getArea_id() == grupoo) {
                                            workOrdersFiltersss.add(workOrder);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return workOrdersFiltersss;

    }


    @Override
    public void workOrderListSuccess(ArrayList<WorkOrder> workOrders) {

        //   this.workOrders = workOrders;

        this.workOrders = new ArrayList<>();

        for (WorkOrder workOrder : workOrders) {
            if (workOrder.getEstado() == Constantes.ESTADO_WORK_ORDER.PLANEADO ||
                    workOrder.getEstado() == Constantes.ESTADO_WORK_ORDER.REGISTRADO ||
                    workOrder.getEstado() == Constantes.ESTADO_WORK_ORDER.ACTIVADO ||
                    workOrder.getEstado() == Constantes.ESTADO_WORK_ORDER.FINALIZADO) {
                this.workOrders.add(workOrder);
            }
        }

        workOrdersFilter = this.workOrders;
        cargaData(this.workOrders);

        if (loading.isShowing()) {
            loading.dismiss();
        }

    }

    void cargaData(ArrayList<WorkOrder> workOrders) {
        adapter = new mt_WorkOrder_AdapterList(listener, getContext(), workOrders);
        rvWorkOrders.setHasFixedSize(true);
        rvWorkOrders.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvWorkOrders.setAdapter(adapter);

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = getContext().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.marginrecyclwe);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);


        Integer cuenta = rvWorkOrders.getItemDecorationCount();
        for (int i = 0; i < cuenta; i++) {
            rvWorkOrders.removeItemDecorationAt(i);
        }

        rvWorkOrders.addItemDecoration(itemDecoration);
    }

    @Override
    public void workOrdersCreateSuccess(boolean success) {

    }

    @Override
    public void workOrderUpdateSuccess(WorkOrder workOrder) {

    }

    @Override
    public void areaGrupoListSuccess(ArrayList<AreaGrupo> areaGrupos) {

        this.areaGrupos = areaGrupos;
    }

    @Override
    public void areaGruposCreateSuccess(boolean success) {

    }

    @Override
    public void showErrorMessage(String message) {
        if (loading.isShowing()) {
            loading.dismiss();
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
