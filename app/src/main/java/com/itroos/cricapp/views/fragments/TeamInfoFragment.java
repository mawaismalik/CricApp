package com.itroos.cricapp.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itroos.cricapp.R;


public class TeamInfoFragment extends Fragment {



    public TeamInfoFragment() {
        // Required empty public constructor
    }

    public static TeamInfoFragment newInstance() {
        TeamInfoFragment fragment = new TeamInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_info, container, false);
    }
}