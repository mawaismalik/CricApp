package com.itroos.cricapp.views.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.itroos.cricapp.R;
import com.itroos.cricapp.data.models.MatchesModel;
import com.itroos.cricapp.data.models.TeamsModel;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.helpers.Config;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.AuditsViewHolder> {


    private List<MatchesModel> matchesModelList;
    private Context context;


    public MatchesAdapter(List<MatchesModel> matchesModelList, Context context) {
        this.matchesModelList = matchesModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public AuditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_matches, parent, false);
        return new MatchesAdapter.AuditsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesAdapter.AuditsViewHolder holder, int position) {

        MatchesModel matchesModel = matchesModelList.get(position);
        position++;
        holder._serialNo.setText(String.valueOf(position));


        if (matchesModel.getTeam_a_name() != null) {
            holder.tv_team_a.setText(matchesModel.getTeam_a_name());
        }

        if(matchesModel.getTeam_b_name() != null) {
            holder.tv_team_b.setText(matchesModel.getTeam_b_name());
        }

        if (matchesModel.getStatus()!= null) {
            switch (matchesModel.getStatus()){
                case 1:
                    holder.status.setText("On Going");
                    holder.status.setBackgroundResource(R.drawable.view_default_green);
                    break;
            }
        }

        if(matchesModel.getDate() != null) {
            holder.date.setText(matchesModel.getDate());
        }

        if(matchesModel.getTotal_score() != null) {
            holder.score.setText(String.valueOf(matchesModel.getTotal_score()));
        }

    }

    @Override
    public int getItemCount() {
        return matchesModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class AuditsViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_team_a, tv_team_b, _serialNo, score , status , date ;

        public AuditsViewHolder(@NonNull View itemView) {
            super(itemView);

            _serialNo = itemView.findViewById(R.id.serial_number);
            tv_team_a = itemView.findViewById(R.id.tv_team_a);
            tv_team_b = itemView.findViewById(R.id.tv_team_b);
            score = itemView.findViewById(R.id.tv_scored);
            status = itemView.findViewById(R.id.status);
            date = itemView.findViewById(R.id.wo_date);



        }


    }
}
