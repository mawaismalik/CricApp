package com.itroos.cricapp.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.TeamsModel;
import com.itroos.cricapp.views.callbacks.TeamId;

import java.util.List;

public class TeamsSelectionAdapter extends RecyclerView.Adapter<TeamsSelectionAdapter.AuditsViewHolder> {


    private List<TeamsModel> teamsModelList;
    private Context context;
    private static TeamId listner;
    private static int count;
    private static String team;

    public TeamsSelectionAdapter(List<TeamsModel> teamsModelList, Context context , TeamId listner , int count , String team) {
        this.teamsModelList = teamsModelList;
        this.listner = listner;
        this.context = context;
        this.count = count;
        this.team = team;

    }

    @NonNull
    @Override
    public AuditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_teams_selection, parent, false);
        return new AuditsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsSelectionAdapter.AuditsViewHolder holder, int position) {

        TeamsModel teamsModel = teamsModelList.get(position);
        position++;
        holder._serialNo.setText(String.valueOf(position));


        if (teamsModel.getTeamName() != null) {
            holder.team_name.setText(teamsModel.getTeamName());
        }


        holder._teamid.setText(teamsModel.getTeamId());

    }

    @Override
    public int getItemCount() {
        return teamsModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class AuditsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView team_name, _serialNo, _teamid;
        private final RadioButton rb_team;


        public AuditsViewHolder(@NonNull View itemView) {
            super(itemView);

            team_name = itemView.findViewById(R.id.tv_team_name);
            _serialNo = itemView.findViewById(R.id.serial_number);
            _teamid = itemView.findViewById(R.id.team_id);
            rb_team = itemView.findViewById(R.id.rb_team);
            LinearLayout llroot = itemView.findViewById(R.id.llRoot);
            llroot.setOnClickListener(this);

        }



        @Override
        public void onClick(View view) {
            if(rb_team.isChecked()){
                count--;
                rb_team.setChecked(false);
            }else if(!rb_team.isChecked() && count == 0){
                rb_team.setChecked(true);
                count++;
                listner.getTeamId(getAdapterPosition(), team);
            }

        }
    }
}
