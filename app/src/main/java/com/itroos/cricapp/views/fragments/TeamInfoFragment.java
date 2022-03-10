package com.itroos.cricapp.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.itroos.cricapp.R;
import com.itroos.cricapp.views.callbacks.TeamDetails;


public class TeamInfoFragment extends Fragment implements TeamDetails {


    private static String teamId;
    private EditText et_team_name;
    public TeamInfoFragment() {
        // Required empty public constructor
    }

    public static TeamInfoFragment newInstance( String id) {
        teamId = id;
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

        View view = inflater.inflate(R.layout.fragment_team_info, container, false);
        et_team_name = view.findViewById(R.id.et_team_name);
        return view;
    }

    @Override
    public String getTeamInfo() {
        return et_team_name.getText().toString();
    }
}