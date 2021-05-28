package com.futuremobile.wox.presentation.ui.adapterlist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.Action;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.domain.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;


public class mt_WorkOrder_Action_AdapterList extends RecyclerView.Adapter<mt_WorkOrder_Action_AdapterList.AssetViewHolder> {


    private List<LineaTiempo> lineaTiempos = new ArrayList<>();

    public OnItemClickListener mlistener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemWOClicked(View v, LineaTiempo workOrder);
    }

    public void add(LineaTiempo item) {
        lineaTiempos.add(item);
        notifyItemInserted(lineaTiempos.size() - 1);
    }


    @Override
    public AssetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mt_work_order_actions_item_list, parent, false);
        AssetViewHolder rvMainAdapterViewHolder = new AssetViewHolder(view);

        return rvMainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(final AssetViewHolder holder, int position) {
        LineaTiempo lineaTiempo = lineaTiempos.get(position);

        holder.tvAreaResp.setText(lineaTiempo.getDesc_area());
        holder.tvHora.setText(lineaTiempo.getHora());
        holder.tvCodTipo.setText(lineaTiempo.getCod_tipo());
    }

    @Override
    public int getItemCount() {

        return lineaTiempos.size();
    }

    class AssetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvAreaResp, tvHora, tvCodTipo;


        public AssetViewHolder(View v) {
            super(v);

            this.tvAreaResp = (TextView) v.findViewById(R.id.tvAreaResp);
            this.tvHora = (TextView) v.findViewById(R.id.tvHora);
            this.tvCodTipo = (TextView) v.findViewById(R.id.tvCodTipo);
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            LineaTiempo workOrder = lineaTiempos.get(getPosition());
            mlistener.onItemWOClicked(v, workOrder);
        }
    }

    public mt_WorkOrder_Action_AdapterList(OnItemClickListener listener, Context context, ArrayList<LineaTiempo> lineaTiempos) {
        this.lineaTiempos = lineaTiempos;
        this.mlistener = listener;
        this.mContext = context;

    }

}


