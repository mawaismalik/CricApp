package com.itroos.cricapp.dbo.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Teams {
    private String id;
    private String TeamName;
    private String TeamPicture;
    @Generated(hash = 2025016589)
    public Teams(String id, String TeamName, String TeamPicture) {
        this.id = id;
        this.TeamName = TeamName;
        this.TeamPicture = TeamPicture;
    }
    @Generated(hash = 1627982657)
    public Teams() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTeamName() {
        return this.TeamName;
    }
    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }
    public String getTeamPicture() {
        return this.TeamPicture;
    }
    public void setTeamPicture(String TeamPicture) {
        this.TeamPicture = TeamPicture;
    }

}
