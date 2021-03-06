package com.itroos.cricapp.dbo.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Players {
    private String id;
    private String PlayerName;
    private Integer PlayerNumber;
    private boolean PlayingEleven;
    private String TeamId;
    @Generated(hash = 170038299)
    public Players(String id, String PlayerName, Integer PlayerNumber,
            boolean PlayingEleven, String TeamId) {
        this.id = id;
        this.PlayerName = PlayerName;
        this.PlayerNumber = PlayerNumber;
        this.PlayingEleven = PlayingEleven;
        this.TeamId = TeamId;
    }
    @Generated(hash = 1221525943)
    public Players() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPlayerName() {
        return this.PlayerName;
    }
    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }
    public Integer getPlayerNumber() {
        return this.PlayerNumber;
    }
    public void setPlayerNumber(Integer PlayerNumber) {
        this.PlayerNumber = PlayerNumber;
    }
    public boolean getPlayingEleven() {
        return this.PlayingEleven;
    }
    public void setPlayingEleven(boolean PlayingEleven) {
        this.PlayingEleven = PlayingEleven;
    }
    public String getTeamId() {
        return this.TeamId;
    }
    public void setTeamId(String TeamId) {
        this.TeamId = TeamId;
    }
  
}
