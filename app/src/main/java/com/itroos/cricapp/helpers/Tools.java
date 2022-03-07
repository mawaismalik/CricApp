package com.itroos.cricapp.helpers;

import com.itroos.cricapp.data.models.PlayersModel;
import com.itroos.cricapp.dbo.entities.Players;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Tools {

    public static List<PlayersModel> convertPlayersToPojo(List<Players> list) {
        List<PlayersModel> pojoList = new ArrayList<>();

        for (Players table :
                list) {
            PlayersModel playersModel = new PlayersModel();
            playersModel.setPlayerName(table.getPlayerName());
            playersModel.setPlayerNumber(table.getPlayerNumber());
            playersModel.setPlayingEleven(table.getPlayingEleven());
            pojoList.add(playersModel);
        }
        return pojoList;
    }

    public static Players convertPlayerTosave(Players players){
        players.setId(playerIdGenerator());
        return players;
    }


    private static String playerIdGenerator() {
        String auditType = "P-";
        String currentTime =  new SimpleDateFormat(Config.dateFormat.ID_DATE, Locale.getDefault()).format(new Date());
        return auditType+currentTime;
    }

}
