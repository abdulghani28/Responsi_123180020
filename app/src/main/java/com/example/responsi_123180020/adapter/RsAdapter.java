package com.example.responsi_123180020.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180020.R;
import com.example.responsi_123180020.model.rsrujukan.DataItem;

import java.util.ArrayList;
import java.util.List;

public class RsAdapter  extends RecyclerView.Adapter<RsAdapter.ViewHolder> {
    private List<DataItem> dataItems = new ArrayList<>();
    private Context context;
    public RsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<DataItem> items){
        dataItems.clear();
       dataItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rsrujukan,parent,false);
        return new RsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RsAdapter.ViewHolder holder, int position) {
        holder.tvRs.setText(dataItems.get(position).getNama());
        holder.tvAlamat.setText(dataItems.get(position).getAlamat());
        holder.btMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String location = "geo:" + dataItems.get(position).getLatitude()+ "," + dataItems.get(position).getLongitude() + "?q=";

                Uri gmmIntentUri =
                        Uri.parse(location + Uri.encode(dataItems.get(position).getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);

            }
        });


    }

    @Override
    public int getItemCount() {return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRs,tvAlamat;
        Button btMaps;
        public ViewHolder(@NonNull  View itemView) {

            super(itemView);
            tvRs = itemView.findViewById(R.id.itemlist_namarsrujukan);
            tvAlamat = itemView.findViewById(R.id.itemlist_alamatrsrujukan);
            btMaps=itemView.findViewById(R.id.itemlist_buttonrsrujukan);
        }
    }
}
