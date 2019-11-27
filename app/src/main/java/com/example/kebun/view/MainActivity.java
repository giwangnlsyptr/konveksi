package com.example.kebun.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.kebun.R;
import com.example.kebun.fragment.ChartFragment;
import com.example.kebun.fragment.HomeFragment;
import com.example.kebun.fragment.StatusFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv);
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        toolbar = getSupportActionBar();
    }
    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home :
                fragment = new HomeFragment();
                toolbar.setTitle("Home");
                break;
            case R.id.chart :
                fragment = new ChartFragment();
                toolbar.setTitle("Chart");
                break;
            case R.id.status :
                fragment = new StatusFragment();
                toolbar.setTitle("Status");
                break;
        }
        return loadFragment(fragment);
    }
}
