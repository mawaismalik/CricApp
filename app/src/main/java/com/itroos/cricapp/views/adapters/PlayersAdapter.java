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

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.AuditsViewHolder> {


    private List<PlayersModel> playersModelList;
    private Context context;


    public PlayersAdapter(List<PlayersModel> playersModelList, Context context) {
        this.playersModelList = playersModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public AuditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_items_dropdowns, parent, false);
        return new PlayersAdapter.AuditsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapter.AuditsViewHolder holder, int position) {

        PlayersModel playersModel = playersModelList.get(position);

        if (playersModel.getPlayerName() != null) {
            holder.dataDis.setText(playersModel.getPlayerName());
        }
        position++;
        if(playersModel.getPlayerNumber() != null) {
            holder._serialNo.setText(String.valueOf(playersModel.getPlayerNumber()));
        }
    }

    @Override
    public int getItemCount() {
        return playersModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class AuditsViewHolder extends RecyclerView.ViewHolder {
        private TextView dataDis, _serialNo;

        public AuditsViewHolder(@NonNull View itemView) {
            super(itemView);

            dataDis = itemView.findViewById(R.id.row_items_Name);
            _serialNo = itemView.findViewById(R.id.row_item_srNo);


        }


    }
}
