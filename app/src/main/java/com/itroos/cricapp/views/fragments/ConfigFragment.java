package com.itroos.cricapp.views.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.itroos.cricapp.R;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.views.callbacks.MatchDetails;

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


    public static ConfigFragment newInstance() {
        return new ConfigFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuration, container, false);
        /*Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("New Match");*/

        et_batter_per_team.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                batter_per_team = 1;

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_max_over_per_bowler.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                batter_per_team = 1;

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_over_per_innings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                batter_per_team = 1;

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        return view;
    }


    @Override
    public Matches getMatchDetails() {
        return null;
    }
}
