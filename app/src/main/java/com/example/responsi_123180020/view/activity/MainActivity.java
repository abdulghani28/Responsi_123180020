package com.example.responsi_123180020.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.responsi_123180020.view.fragment.DataFragment;
import com.example.responsi_123180020.view.fragment.HospitalFragment;
import com.example.responsi_123180020.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

        private BottomNavigationView bottomNavigationView;
        private Fragment selectedFragment = new DataFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView =findViewById(R.id.batton_activitymain);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_data:
                selectedFragment = new DataFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_hospital :
                selectedFragment =new HospitalFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment !=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain,selectedFragment)
                    .commit();
            return true;
        }
        return  false;
    }
}