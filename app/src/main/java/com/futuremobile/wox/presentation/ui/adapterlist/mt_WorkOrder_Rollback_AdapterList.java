package com.futuremobile.wox.presentation.ui.adapterlist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.Action;

import java.util.ArrayList;
import java.util.List;


public class mt_WorkOrder_Rollback_AdapterList extends RecyclerView.Adapter<mt_WorkOrder_Rollback_AdapterList.AssetViewHolder> {


    private List<Action> workOrders =new ArrayList<>();

    public OnItemClickListener mlistener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemWOClicked(View v, Action workOrder);
    }

    public void add(Action item){
        workOrders.add(item);
        notifyItemInserted(workOrders.size()-1);
    }




    @Override
    public AssetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mt_work_order_rollback_item_list, parent, false);
        AssetViewHolder rvMainAdapterViewHolder = new AssetViewHolder(view);

        return  rvMainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(final AssetViewHolder holder, int position) {
        Action workOrder = workOrders.get(position);


    }

    @Override
    public int getItemCount() {

        return workOrders.size();
    }

      class AssetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvdescripcion_corta,tvdescripcion,tvnamecategoria,tvcodigo,tvcodigo_barra,
          tvuni_medida,tvnameCategory,tvprecio_unitario,tvestado,tvstock,tvinventariado,
                tvcodigo_unico,tvtvcreated_at,tvid,tvtipo,tvtipo_afectigv,tvcategory,tvidalmacen;


        public AssetViewHolder(View v){
            super(v);

            v.setOnClickListener(this);

        }

         @Override
         public void onClick(View v) {

             Action workOrder=null;
             mlistener.onItemWOClicked(v,workOrder);
         }
    }

    public mt_WorkOrder_Rollback_AdapterList(OnItemClickListener listener, Context context, ArrayList<Action> workOrders){
        this.workOrders = workOrders;
        this.mlistener = listener;
        this.mContext=context;

    }

}


