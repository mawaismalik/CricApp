package com.itroos.cricapp.data.models;


public class PlayersModel {
    private String playersId;

    private String playerName;

    private Integer playerNumber;

    private Boolean playingEleven;

    private String teamId;

    public String getPlayersId() {
        return playersId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setPlayersId(String playersId) {
        this.playersId = playersId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Boolean getPlayingEleven() {
        return playingEleven;
    }

    public void setPlayingEleven(Boolean playingEleven) {
        this.playingEleven = playingEleven;
    }
}
