package com.itroos.cricapp.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.itroos.cricapp.R;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.helpers.Config;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.adapters.TeamsVpAdapter;
import com.itroos.cricapp.views.callbacks.TeamDetails;
import com.itroos.cricapp.views.fragments.PlayersInfoFragment;
import com.itroos.cricapp.views.fragments.PlayersViewModel;
import com.itroos.cricapp.views.fragments.TeamInfoFragment;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class TeamActivity extends AppCompatActivity {

    private SparseArray<Fragment> fragments;//list off fragments
    private ViewPager pager;
    private String teamId;
    private PlayersInfoFragment playersInfoFragment;
    private TeamInfoFragment teamInfoFragment;
    private PlayersViewModel playersViewModel;

    private String teamName;
    List<Players> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        teamId = getIntent().getExtras().getString(Config.ExtrasHints.TEAM_ID , "");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("New Team");
        setSupportActionBar(toolbar);

        fragments = new SparseArray<Fragment>();
        playersViewModel = new PlayersViewModel(getApplicationContext());


        pager = (ViewPager) findViewById(R.id.vpPagerTeams);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(new TeamsVpAdapter(super.getSupportFragmentManager()  , teamId));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof TeamInfoFragment)
            fragments.put(0, fragment);
        if (fragment instanceof PlayersInfoFragment)
            fragments.put(1, fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (teamInfoFragment == null)
            teamInfoFragment = (TeamInfoFragment) fragments.get(0);

        if (playersInfoFragment == null)
            playersInfoFragment = (PlayersInfoFragment) fragments.get(1);

        teamName = teamInfoFragment.getTeamInfo();
        if(teamName.isEmpty()){
            Toast.makeText(getApplicationContext() , "Please enter team name" , Toast.LENGTH_SHORT).show();
            return false;
        }
        data = playersInfoFragment.getTeamPlayers();

        int id = item.getItemId();
        if (id == R.id.id_done) {
            if(data != null){
                if(data.isEmpty()){
                    Toast.makeText(getApplicationContext() , "Please add players to team" , Toast.LENGTH_SHORT).show();
                    return false;
                }else {

                    playersViewModel.addTeam(Tools.convertTeamToSave(teamId, teamName));
                    Toast.makeText(getApplicationContext() , "Team created successfully" , Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}