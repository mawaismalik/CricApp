package com.itroos.cricapp.views.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.TeamsModel;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.helpers.Config;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.adapters.TeamsAdapter;
import com.itroos.cricapp.views.adapters.TeamsSelectionAdapter;
import com.itroos.cricapp.views.callbacks.MatchDetails;
import com.itroos.cricapp.views.callbacks.TeamId;

import java.text.ParseException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TeamSelectionFragment extends Fragment  implements View.OnClickListener , TeamId , MatchDetails {

    @InjectView(R.id.cv_team_a)
    CardView cv_team_a;

    @InjectView(R.id.cv_team_b)
    CardView cv_team_b;

    @InjectView(R.id.tv_team_a)
    TextView tv_team_a;

    @InjectView(R.id.tv_team_b)
    TextView tv_team_b;

    @InjectView(R.id.rb_team_a)
    RadioButton rb_team_a;

    @InjectView(R.id.rb_team_b)
    RadioButton rb_team_b;

    @InjectView(R.id.rb_bat)
    RadioButton rb_bat;

    @InjectView(R.id.rb_bowl)
    RadioButton rb_bowl;

    @InjectView(R.id.rg_toss)
    RadioGroup rg_toss;
    @InjectView(R.id.rg_bat_bowl)
    RadioGroup rg_bat_bowl;


    private String team_a_id , team_b_id , team_a_name, team_b_name , toss_winner;
    private Integer elected_to; //1-bat , 2-bowl
    private PlayersViewModel viewModel;
    private List<TeamsModel> teamsModelList;
    public static TeamSelectionFragment newInstance() {
        return new TeamSelectionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_selection, container, false);
        ButterKnife.inject(this , view);
        viewModel = new PlayersViewModel(getContext());
     /*   Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("New Match");*/

        cv_team_a.setOnClickListener(this);
        cv_team_b.setOnClickListener(this);

        rg_toss.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_team_a:
                        toss_winner = team_a_name;
                        break;

                    case R.id.rb_team_b:
                        toss_winner = team_b_name;
                        break;
                }
            }
        });


        rg_bat_bowl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_bat:
                        elected_to = 1;
                        break;

                    case R.id.rb_bowl:
                        elected_to = 2;
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        teamsModelList = Tools.convertTeamsToPojo(viewModel.getAllTeams());
        try {
        switch (view.getId()){

                case R.id.cv_team_a:
                    openTaskView(teamsModelList, this::getTeamId , Config.team.TEAM_A);
                   // Toast.makeText(getContext(), "team a", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.cv_team_b:
                    openTaskView(teamsModelList, this::getTeamId, Config.team.TEAM_B);
                   // Toast.makeText(getContext(), "team b", Toast.LENGTH_SHORT).show();
                    break;
            }
        }catch (Exception e){
            e.getCause();
        }
    }


    @Override
    public void getTeamId(int position , String team) {

        TeamsModel teams = teamsModelList.get(position);
        switch (team){
            case Config.team.TEAM_A:
                tv_team_a.setText(teams.getTeamName());
                rb_team_a.setText(teams.getTeamName());
                team_a_name = teams.getTeamName();
                team_a_id = teams.getTeamId();
                break;
            case Config.team.TEAM_B:
                tv_team_b.setText(teams.getTeamName());
                rb_team_b.setText(teams.getTeamName());
                team_b_name = teams.getTeamName();
                team_b_id = teams.getTeamId();
                break;
        }
    }

    private void openTaskView(List<TeamsModel> teamsModelList , TeamId listner, String team) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
        LayoutInflater inflater = (getActivity()).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.team_popup, null);
        dialogBuilder.setView(dialogView);
        LinearLayoutManager mLayoutManager;
        RecyclerView recyclerView = ((RecyclerView) dialogView.findViewById(R.id.rv_teams));
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        dialogBuilder.setCancelable(true);
        TeamsSelectionAdapter adapter = new TeamsSelectionAdapter(teamsModelList, getContext(),listner,0,team);
        recyclerView.setAdapter(adapter);

        dialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogBuilder.create();
        dialogBuilder.show();
    }

    @Override
    public Matches getMatchDetails() {
        Matches matches = new Matches();
        matches.setTeam_a_Id(team_a_id);
        matches.setTeam_a_name(team_a_name);
        matches.setTeam_b_Id(team_b_id);
        matches.setTeam_b_name(team_b_name);
        matches.setToss_winner(toss_winner);
        matches.setElected_to(elected_to);
        return matches;
    }
}
