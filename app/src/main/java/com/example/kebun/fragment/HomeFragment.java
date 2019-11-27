package com.example.kebun.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.kebun.R;
import com.example.kebun.adapter.KaosAdapter;
import com.example.kebun.model.KaosModel;
import com.example.kebun.presenter.KaosPresenter;
import com.example.kebun.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView {
    private RecyclerView recyclerView;
    KaosAdapter kaosAdapter;
    KaosPresenter kaosPresenter;
    List<KaosModel> kaosModels = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        kaosPresenter = new KaosPresenter(getContext(), this);
        kaosPresenter.setData();
    }

    @Override
    public void onSuccess(List<KaosModel> kaosModels) {
        kaosAdapter = new KaosAdapter(getContext(),kaosModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(kaosAdapter);
        kaosAdapter.notifyDataSetChanged();

    }
}
