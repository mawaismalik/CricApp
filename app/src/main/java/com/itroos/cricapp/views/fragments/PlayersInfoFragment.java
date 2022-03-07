package com.itroos.cricapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.PlayersModel;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.adapters.PlayersAdapter;

import java.util.ArrayList;
import java.util.List;


public class PlayersInfoFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<PlayersModel> listPlayersModel;
    private PlayersAdapter playersAdapter;
    private PlayersViewModel playersViewModel;
    private EditText et_player_name, et_player_number;
    private Button btn_add_player;

    public static PlayersInfoFragment newInstance() {
        return new PlayersInfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players_info, container, false);
        setupViews(view);
        playersViewModel = new PlayersViewModel(getContext());
        getPlayers();

        btn_add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayer();
            }
        });
        return view;
    }

    private void setupViews(View _view) {
        recyclerView = _view.findViewById(R.id.rv_players);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        et_player_name = _view.findViewById(R.id.et_player_name);
        et_player_number = _view.findViewById(R.id.et_player_numb);
        btn_add_player = _view.findViewById(R.id.btn_add_player);
    }

    private void getPlayers(){

        List<Players> data = new ArrayList<>();
        data = playersViewModel.getAllPlayer();
        if(data != null) {
            listPlayersModel = Tools.convertPlayersToPojo(data);
            if (!listPlayersModel.isEmpty()) {
                playersAdapter = new PlayersAdapter(listPlayersModel, getContext());
                recyclerView.setAdapter(playersAdapter);
            }
        }
    }

    private void addPlayer(){
        if(et_player_number.getText().toString().isEmpty()){
            et_player_number.setError("enter player number");
            return;
        }
        if(et_player_name.getText().toString().isEmpty()){
            et_player_name.setError("enter player name");
            return;
        }
        Players player = new Players();
        player.setPlayerName(et_player_name.getText().toString());
        player.setPlayerNumber(Integer.parseInt(et_player_number.getText().toString()));
        playersViewModel.addPlayer(player);

        et_player_name.setText("");
        et_player_number.setText("");

        getPlayers();
    }

}
