package com.itroos.cricapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.SparseArray;

import com.itroos.cricapp.R;
import com.itroos.cricapp.views.adapters.TeamsVpAdapter;
import com.itroos.cricapp.views.fragments.PlayersInfoFragment;
import com.itroos.cricapp.views.fragments.TeamInfoFragment;

import me.relex.circleindicator.CircleIndicator;

public class TeamActivity extends AppCompatActivity {

    private SparseArray<Fragment> fragments;//list off fragments
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("New Team");

        fragments = new SparseArray<Fragment>();


        pager = (ViewPager) findViewById(R.id.vpPagerTeams);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(new TeamsVpAdapter(super.getSupportFragmentManager()  , 1l));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof TeamInfoFragment)
            fragments.put(0, fragment);
        if (fragment instanceof PlayersInfoFragment)
            fragments.put(1, fragment);
    }

}