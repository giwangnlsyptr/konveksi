package com.example.kebun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kebun.R;
import com.example.kebun.database.AppDatabase;
import com.example.kebun.database.Chart;

import java.util.ArrayList;
import java.util.List;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {
    Context context;
    List<Chart> chartList = new ArrayList<>();
    public ChartAdapter(Context context, List<Chart> chartList){
        this.context = context;
        this.chartList = chartList;
    }

    @NonNull
    @Override
    public ChartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.chart, viewGroup, false);
        ChartAdapter.ViewHolder holder = new ChartAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return chartList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvType, tvPrice, tvSize, tvQty, tvTotal;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvType = itemView.findViewById(R.id.type);
            tvPrice = itemView.findViewById(R.id.price);
            tvQty = itemView.findViewById(R.id.qty);
            tvSize = itemView.findViewById(R.id.size);
            tvTotal = itemView.findViewById(R.id.total);
        }
        public void bind(final int i){
            final Chart chart = chartList.get(i);
            tvType.setText(chartList.get(i).getType());
            tvPrice.setText(chartList.get(i).getHarga());
            tvQty.setText(chartList.get(i).getQty());
            tvSize.setText(chartList.get(i).getSize());
            tvTotal.setText(chartList.get(i).getTotal());
        }
    }
}
