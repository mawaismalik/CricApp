package com.itroos.cricapp.views.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.itroos.cricapp.views.fragments.ConfigFragment;
import com.itroos.cricapp.views.fragments.PlayersInfoFragment;
import com.itroos.cricapp.views.fragments.TeamInfoFragment;
import com.itroos.cricapp.views.fragments.TeamSelectionFragment;
import com.itroos.cricapp.views.fragments.TossFragment;


public class MatchVpAdapter extends FragmentPagerAdapter {

    private Integer viewType;
    private String teamId;
    public MatchVpAdapter(FragmentManager fm  , String teamId) {
        super(fm);
        this.teamId = teamId;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return ConfigFragment.newInstance();
            case 1:
                return TeamSelectionFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

