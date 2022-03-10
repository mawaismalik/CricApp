package com.itroos.cricapp.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.itroos.cricapp.R;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.helpers.Config;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.activities.TeamActivity;
import com.itroos.cricapp.views.adapters.TeamsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TeamsFragment extends Fragment {


    @InjectView(R.id.btn_add_team)
    MaterialButton btn_add_team;
    @InjectView(R.id.rv_list)
    RecyclerView recyclerView;
    List<Teams> data;
    PlayersViewModel playersViewModel;
    LinearLayoutManager mLayoutManager;
    public static TeamsFragment newInstance() {
        return new TeamsFragment();
    }

   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }*/


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        ButterKnife.inject(this, view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("All Teams");
        playersViewModel = new PlayersViewModel(getContext());
        setupViews();
        data = new ArrayList<>();
        getTeams();
        btn_add_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , TeamActivity.class);
                intent.putExtra(Config.ExtrasHints.TEAM_ID, Tools.teamIdGenerator());
                startActivity(intent);
            }
        });

        return view;
    }

    private void setupViews() {
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    private void  getTeams(){
        data = playersViewModel.getAllTeams();
        TeamsAdapter adapter = new TeamsAdapter(Tools.convertTeamsToPojo(data), getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        getTeams();
        super.onResume();
    }

    /* @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.add_data, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_opt_add) {
            Intent intent = new Intent(getActivity() , TeamActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }*/

}
