package com.itroos.cricapp.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.itroos.cricapp.R;
import com.itroos.cricapp.views.fragments.AccountFragment;
import com.itroos.cricapp.views.fragments.HomeFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeActivity extends AppCompatActivity  {
    @InjectView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, HomeFragment.newInstance()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.id_home:
                        fragment  = HomeFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_account:
                        fragment  = AccountFragment.newInstance();
                        Toast.makeText(getApplicationContext(), "account", Toast.LENGTH_SHORT).show();
                        break;
                }
                if(fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                }
                return true;
            }
        });

    }

}