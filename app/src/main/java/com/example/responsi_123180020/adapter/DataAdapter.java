package com.example.responsi_123180020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180020.R;
import com.example.responsi_123180020.model.datakasus.ContentItem;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private List<ContentItem> contentItems = new ArrayList<>();
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ContentItem> items){
        contentItems.clear();
        contentItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DataAdapter.ViewHolder holder, int position) {
        holder.tvTanggal.setText(contentItems.get(position).getTanggal());
        holder.tvSembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
        holder.tvMeninggal.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));
        holder.tvTerkonvirmasi.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));

    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView  tvTanggal,tvSembuh,tvMeninggal,tvTerkonvirmasi;

        public ViewHolder(@NonNull  View itemView) {

            super(itemView);
            tvTanggal = itemView.findViewById(R.id.itemlist_tv_tanggal);
            tvSembuh = itemView.findViewById(R.id.itemlist_tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.itemlist_tv_meninggal);
            tvTerkonvirmasi = itemView.findViewById(R.id.itemlist_tv_terkonfirmasi);
        }
    }
}
