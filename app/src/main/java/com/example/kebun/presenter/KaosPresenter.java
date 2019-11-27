package com.example.kebun.presenter;

import android.content.Context;

import com.example.kebun.R;
import com.example.kebun.model.KaosModel;
import com.example.kebun.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class KaosPresenter {
    Context context;
    List<KaosModel> kaosModels = new ArrayList<KaosModel>();
    HomeView view;

    public KaosPresenter(Context context, HomeView view) {
        this.context = context;
        this.view = view;
    }

    public void setData() {
        KaosModel playlist;
        playlist = new KaosModel("Kaos Putih", "70000", R.drawable.putih);
        kaosModels.add(playlist);
        playlist = new KaosModel("Kaos Pink", "75000", R.drawable.pink);
        kaosModels.add(playlist);
        playlist = new KaosModel("Kaos Pink", "65000", R.drawable.pink);
        kaosModels.add(playlist);
        playlist = new KaosModel("Kaos Stripe", "70000", R.drawable.putih);
        kaosModels.add(playlist);
        playlist = new KaosModel("Kaos Polos", "75000", R.drawable.images);
        kaosModels.add(playlist);
        playlist = new KaosModel("Kaos Pink", "65000", R.drawable.pink);

        view.onSuccess(kaosModels);
    }

}
