package com.itroos.cricapp.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.PlayersModel;
import com.itroos.cricapp.data.models.TeamsModel;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.AuditsViewHolder> {


    private List<TeamsModel> teamsModelList;
    private Context context;


    public TeamsAdapter(List<TeamsModel> teamsModelList, Context context) {
        this.teamsModelList = teamsModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public AuditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_teams, parent, false);
        return new TeamsAdapter.AuditsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.AuditsViewHolder holder, int position) {

        TeamsModel teamsModel = teamsModelList.get(position);
        position++;
        holder._serialNo.setText(String.valueOf(position));


        if (teamsModel.getTeamName() != null) {
            holder.team_name.setText(teamsModel.getTeamName());
        }

        if(teamsModel.getNoOfPlayers() != null) {
            holder._noOfPlayers.setText(String.valueOf(teamsModel.getNoOfPlayers()));
        }

    }

    @Override
    public int getItemCount() {
        return teamsModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class AuditsViewHolder extends RecyclerView.ViewHolder {
        private TextView team_name, _serialNo, _noOfPlayers;

        public AuditsViewHolder(@NonNull View itemView) {
            super(itemView);

            team_name = itemView.findViewById(R.id.tv_team_name);
            _serialNo = itemView.findViewById(R.id.serial_number);
            _noOfPlayers = itemView.findViewById(R.id.tv_no_of_players);


        }


    }
}
