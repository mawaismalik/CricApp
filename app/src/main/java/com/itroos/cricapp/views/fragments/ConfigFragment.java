package com.itroos.cricapp.views.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.itroos.cricapp.R;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.views.callbacks.MatchDetails;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ConfigFragment extends Fragment implements MatchDetails {

    @InjectView(R.id.batter_per_team)
    EditText et_batter_per_team;

    @InjectView(R.id.et_max_over_per_bowler)
    EditText et_max_over_per_bowler;

    @InjectView(R.id.et_over_per_innings)
    EditText et_over_per_innings;

    @InjectView(R.id.switch_superover)
    SwitchMaterial sw_superover;

    private Integer batter_per_team , max_over_per_bowler , over_per_innings;
    private Boolean superover;
    private Matches match;


    public static ConfigFragment newInstance() {
        return new ConfigFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuration, container, false);
        ButterKnife.inject(this, view);
        /*Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("New Match");*/
        match = new Matches();


        return view;
    }


    @Override
    public Matches getMatchDetails() {

        if(et_batter_per_team.getText().toString().trim().isEmpty() || et_batter_per_team.getText().toString().trim().equals("0") ){
            Toast.makeText(getContext(), "Please enter valid batters number" , Toast.LENGTH_SHORT).show();
            return null ;
        }else{
            match.setBatter_per_team(Integer.valueOf(et_batter_per_team.getText().toString().trim() ));
        }
        if(et_max_over_per_bowler.getText().toString().trim().isEmpty() || et_max_over_per_bowler.getText().toString().trim().equals("0")){
            Toast.makeText(getContext(), "Please enter valid max overs" , Toast.LENGTH_SHORT).show();
            return null ;
        }else{
            match.setMax_over_per_bowler(Integer.valueOf(et_max_over_per_bowler.getText().toString().trim() ));
        }
        if(et_over_per_innings.getText().toString().trim().isEmpty() || et_over_per_innings.getText().toString().trim().equals("0")){
            Toast.makeText(getContext(), "Please enter valid overs per inning" , Toast.LENGTH_SHORT).show();
            return null ;
        }else{
            match.setOvers_per_innings(Integer.valueOf(et_over_per_innings.getText().toString().trim() ));
        }

        if(sw_superover.isActivated()){
            match.setSuper_over(true);
        }else{
            match.setSuper_over(false);
        }
        return match;
    }
}
