package com.itroos.cricapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.MatchesModel;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.adapters.MatchesAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MatchesFragment extends Fragment {


    @InjectView(R.id.rv_list)
    RecyclerView recyclerView;

    private LinearLayoutManager mLayoutManager;
    private List<MatchesModel> matchesModelList;
    private List<Matches> matchesList;
    private TeamsViewModel teamsViewModel;
    private MatchesAdapter matchesAdapter;

    public static MatchesFragment newInstance() {
        return new MatchesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        ButterKnife.inject(this , view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("All Matches");
        teamsViewModel = new TeamsViewModel(getContext());
        setupViews();
        getData();
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

    void getData(){
        matchesList = teamsViewModel.getAllMatches();
        if(matchesList != null){
            matchesAdapter = new MatchesAdapter(Tools.convertMatchesToPojo(matchesList),getContext());
            recyclerView.setAdapter(matchesAdapter);
        }

    }

    @Override
    public void onResume() {
        getData();
        super.onResume();
    }

}
