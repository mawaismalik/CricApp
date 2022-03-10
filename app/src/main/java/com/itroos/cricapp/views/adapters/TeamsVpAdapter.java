package com.itroos.cricapp.views.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.itroos.cricapp.views.fragments.PlayersInfoFragment;
import com.itroos.cricapp.views.fragments.TeamInfoFragment;


public class TeamsVpAdapter extends FragmentPagerAdapter {

    private Integer viewType;
    private String teamId;
    public TeamsVpAdapter(FragmentManager fm  , String teamId) {
        super(fm);
        this.teamId = teamId;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return TeamInfoFragment.newInstance(teamId);
            case 1:
                return PlayersInfoFragment.newInstance(teamId);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

