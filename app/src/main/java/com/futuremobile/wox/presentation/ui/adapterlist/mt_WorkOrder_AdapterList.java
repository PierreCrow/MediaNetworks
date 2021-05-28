package com.futuremobile.wox.presentation.ui.adapterlist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.WorkOrder;
import com.futuremobile.wox.presentation.utiles.Constantes;

import java.util.ArrayList;
import java.util.List;


public class mt_WorkOrder_AdapterList extends RecyclerView.Adapter<mt_WorkOrder_AdapterList.AssetViewHolder> {


    private List<WorkOrder> workOrders =new ArrayList<>();

    public OnItemClickListener mlistener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemWOClicked(View v, WorkOrder workOrder);
    }

    public void add(WorkOrder item){
        workOrders.add(item);
        notifyItemInserted(workOrders.size()-1);
    }




    @Override
    public AssetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mt_work_order_item_list, parent, false);
        AssetViewHolder rvMainAdapterViewHolder = new AssetViewHolder(view);

        return  rvMainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(final AssetViewHolder holder, int position) {
        WorkOrder workOrder = workOrders.get(position);

        holder.tvFechaSoli.setText(workOrder.getIni_plan());
        holder.tvTicket.setText(workOrder.getTicket());

        int estado=workOrder.getEstado();

        switch(estado) {
            case Constantes.ESTADO_WORK_ORDER.PLANEADO:
                holder.tvEstado.setText("Planeado");
                break;
            case Constantes.ESTADO_WORK_ORDER.REGISTRO_PARCIAL:
                holder.tvEstado.setText("Registro Parcial");
                break;
            case Constantes.ESTADO_WORK_ORDER.REGISTRADO:
                holder.tvEstado.setText("Registrado");
                break;
            case Constantes.ESTADO_WORK_ORDER.PENDIENTE_APROBACION_TECNICA:
                holder.tvEstado.setText("Pendiente aprobación técnica");
                break;
            case Constantes.ESTADO_WORK_ORDER.APROBADO_TECNICAMENTE:
                holder.tvEstado.setText("Aprobado técnicamente");
                break;
            case Constantes.ESTADO_WORK_ORDER.ACTIVADO:
                holder.tvEstado.setText("Activado");
                break;
            case Constantes.ESTADO_WORK_ORDER.FINALIZADO:
                holder.tvEstado.setText("Finalizado");
                break;
            case Constantes.ESTADO_WORK_ORDER.OBSERVADO_POR_GESTOR:
                holder.tvEstado.setText("Observado por Gestor");
                break;
            case Constantes.ESTADO_WORK_ORDER.OBSERVADO_TECNICAENTE:
                holder.tvEstado.setText("Observado técnicamente");
                break;
            case Constantes.ESTADO_WORK_ORDER.OBSERVADO_POR_MESA:
                holder.tvEstado.setText("Observado por mesa");
                break;
            default:
                holder.tvEstado.setText("");
                break;
        }



    }

    @Override
    public int getItemCount() {

        return workOrders.size();
    }

      class AssetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvEstado,tvFechaSoli,tvTicket;


        public AssetViewHolder(View v){
            super(v);

            this.tvEstado = (TextView) v.findViewById(R.id.tvEstado);
            this.tvFechaSoli = (TextView) v.findViewById(R.id.tvFechaSoli);
            this.tvTicket = (TextView) v.findViewById(R.id.tvTicket);

            v.setOnClickListener(this);

        }

         @Override
         public void onClick(View v) {

            WorkOrder workOrder=workOrders.get(getPosition());
             mlistener.onItemWOClicked(v,workOrder);
         }
    }

    public mt_WorkOrder_AdapterList(OnItemClickListener listener, Context context, ArrayList<WorkOrder> workOrders){
        this.workOrders = workOrders;
        this.mlistener = listener;
        this.mContext=context;
    }

}


