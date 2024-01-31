package com.example.tiketuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        listener();


    }

    private void listener() {

        bottomNAV();
    }

    private void bottomNAV() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.navArmada:
                        selectedFragment = new ArmadaFragment();
                        break;
                    case R.id.navReport:
                        selectedFragment = new ReportFragment();
                        break;
                    case R.id.navProfile:
                        selectedFragment = new ProfileFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }

    private void initUI() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_view);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ArmadaFragment()).commit();

    }
}