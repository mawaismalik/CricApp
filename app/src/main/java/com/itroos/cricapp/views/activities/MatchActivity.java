package com.itroos.cricapp.views.activities;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.itroos.cricapp.R;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.helpers.Config;
import com.itroos.cricapp.helpers.Tools;
import com.itroos.cricapp.views.adapters.MatchVpAdapter;
import com.itroos.cricapp.views.adapters.TeamsVpAdapter;
import com.itroos.cricapp.views.fragments.ConfigFragment;
import com.itroos.cricapp.views.fragments.PlayersInfoFragment;
import com.itroos.cricapp.views.fragments.PlayersViewModel;
import com.itroos.cricapp.views.fragments.TeamInfoFragment;
import com.itroos.cricapp.views.fragments.TeamSelectionFragment;
import com.itroos.cricapp.views.fragments.TossFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.relex.circleindicator.CircleIndicator;

public class MatchActivity extends AppCompatActivity {

    private SparseArray<Fragment> fragments;//list off fragments
    private ViewPager pager;
    private String teamId="";
    private ConfigFragment configFragment;
    private TeamSelectionFragment teamSelectionFragment;
    private PlayersViewModel playersViewModel;

    private Matches matchA , matchB;
    List<Players> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
//        teamId = getIntent().getExtras().getString(Config.ExtrasHints.TEAM_ID , "");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("New Match");
        setSupportActionBar(toolbar);

        fragments = new SparseArray<Fragment>();
        playersViewModel = new PlayersViewModel(getApplicationContext());



        pager = (ViewPager) findViewById(R.id.vpPagerTeams);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(new MatchVpAdapter(super.getSupportFragmentManager()  , teamId));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof ConfigFragment)
            fragments.put(0, fragment);
        if (fragment instanceof TeamSelectionFragment)
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
        matchA = new Matches();
        matchB = new Matches();

        if (configFragment == null)
            configFragment = (ConfigFragment) fragments.get(0);

        if (teamSelectionFragment == null)
            teamSelectionFragment = (TeamSelectionFragment) fragments.get(1);

        matchA = configFragment.getMatchDetails();
        matchB = teamSelectionFragment.getMatchDetails();
        if(matchB != null) {

            if ( matchB.getTeam_a_Id() == null || matchB.getTeam_a_Id().isEmpty() ) {
                Toast.makeText(getApplicationContext(), "Please select Team A", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (matchB.getTeam_b_Id() == null || matchB.getTeam_b_Id().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please select Team B", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (matchB.getToss_winner() == null || matchB.getToss_winner().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please select Toss winner", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (matchB.getElected_to() == null) {
                Toast.makeText(getApplicationContext(), "Please select what toss winner elected to", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
        else {
            return false;
        }
        if(matchA != null) {

            //teamName = teamInfoFragment.getTeamInfo();

            matchA.setId(Tools.matchIdGenerator());
            matchA.setTeam_a_name(matchB.getTeam_a_name());
            matchA.setTeam_b_name(matchB.getTeam_b_name());
            matchA.setTeam_a_Id(matchB.getTeam_a_Id());
            matchA.setTeam_b_Id(matchB.getTeam_b_Id());
            matchA.setToss_winner(matchB.getToss_winner());
            matchA.setElected_to(matchB.getElected_to());
            matchA.setStatus(1);
            matchA.setTotal_score(0);
            matchA.setDate(new SimpleDateFormat(Config.dateFormat.Short_Date_Format, Locale.getDefault()).format(new Date()));
            // data = playersInfoFragment.getTeamPlayers();

            playersViewModel.addMatch(matchA);
            Toast.makeText(getApplicationContext(), "Match started successfully", Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);

    }

}