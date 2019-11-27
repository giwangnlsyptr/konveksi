package com.example.kebun.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kebun.R;
import com.example.kebun.database.AppDatabase;
import com.example.kebun.database.Chart;
import com.example.kebun.model.KaosModel;

import java.util.ArrayList;
import java.util.List;

public class KaosAdapter extends RecyclerView.Adapter<KaosAdapter.ViewHolder> {
    Context context;
    List<KaosModel> kaosModelList= new ArrayList<>();
    AppDatabase appDatabase;
    public KaosAdapter(Context context, List<KaosModel> kaosModelList) {
        this.context = context;
        this.kaosModelList= kaosModelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KaosAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return kaosModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvType, tvHarga;
        ImageView ivImage;
        EditText etSize, etQty;
        RadioButton rS, rM, rL, rXL;
        RadioGroup rgSize;
        Button bAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.type);
            tvHarga = itemView.findViewById(R.id.price);
            ivImage = itemView.findViewById(R.id.photo);
            etQty = itemView.findViewById(R.id.qty);
            etSize = itemView.findViewById(R.id.sizet);
            bAdd = itemView.findViewById(R.id.addto);
            appDatabase = AppDatabase.iniDb(context);
        }

        public void bind(int i) {
            ivImage.setImageResource(kaosModelList.get(i).getImage());
            tvType.setText(kaosModelList.get(i).getType());
            tvHarga.setText(kaosModelList.get(i).getHarga());

            bAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final Chart chart = new Chart();
                    chart.setType(chart.getType());
                    chart.setHarga(chart.getHarga());
                    chart.setQty(chart.getQty());
                    chart.setSize(chart.getSize());
                    new InsertData(appDatabase, chart).execute();
                }
            });
        }
        class InsertData extends AsyncTask<Void, Void, Long> {
            private AppDatabase database;
            private Chart chart;

            public InsertData(AppDatabase database, Chart chart) {
                this.database = database;
                this.chart = chart;
            }

            @Override
            protected Long doInBackground(Void... voids) {
                return database.dao().insertData(chart);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);

            }

        }
    }


}
