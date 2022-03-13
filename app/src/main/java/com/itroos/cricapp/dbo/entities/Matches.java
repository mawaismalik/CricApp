package com.itroos.cricapp.dbo.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Matches {
    private String id;
    private String Team_a_name;
    private String Team_b_name;
    private String Team_a_Id;
    private String Team_b_Id;
    private Integer Batter_per_team;
    private Integer Overs_per_innings;
    private Integer Max_over_per_bowler;
    private Boolean Super_over;
    private String Toss_winner;
    private Integer Elected_to;
    @Generated(hash = 1266487186)
    public Matches(String id, String Team_a_name, String Team_b_name,
            String Team_a_Id, String Team_b_Id, Integer Batter_per_team,
            Integer Overs_per_innings, Integer Max_over_per_bowler,
            Boolean Super_over, String Toss_winner, Integer Elected_to) {
        this.id = id;
        this.Team_a_name = Team_a_name;
        this.Team_b_name = Team_b_name;
        this.Team_a_Id = Team_a_Id;
        this.Team_b_Id = Team_b_Id;
        this.Batter_per_team = Batter_per_team;
        this.Overs_per_innings = Overs_per_innings;
        this.Max_over_per_bowler = Max_over_per_bowler;
        this.Super_over = Super_over;
        this.Toss_winner = Toss_winner;
        this.Elected_to = Elected_to;
    }
    @Generated(hash = 1282269782)
    public Matches() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTeam_a_name() {
        return this.Team_a_name;
    }
    public void setTeam_a_name(String Team_a_name) {
        this.Team_a_name = Team_a_name;
    }
    public String getTeam_b_name() {
        return this.Team_b_name;
    }
    public void setTeam_b_name(String Team_b_name) {
        this.Team_b_name = Team_b_name;
    }
    public String getTeam_a_Id() {
        return this.Team_a_Id;
    }
    public void setTeam_a_Id(String Team_a_Id) {
        this.Team_a_Id = Team_a_Id;
    }
    public String getTeam_b_Id() {
        return this.Team_b_Id;
    }
    public void setTeam_b_Id(String Team_b_Id) {
        this.Team_b_Id = Team_b_Id;
    }
    public Integer getBatter_per_team() {
        return this.Batter_per_team;
    }
    public void setBatter_per_team(Integer Batter_per_team) {
        this.Batter_per_team = Batter_per_team;
    }
    public Integer getOvers_per_innings() {
        return this.Overs_per_innings;
    }
    public void setOvers_per_innings(Integer Overs_per_innings) {
        this.Overs_per_innings = Overs_per_innings;
    }
    public Integer getMax_over_per_bowler() {
        return this.Max_over_per_bowler;
    }
    public void setMax_over_per_bowler(Integer Max_over_per_bowler) {
        this.Max_over_per_bowler = Max_over_per_bowler;
    }
    public Boolean getSuper_over() {
        return this.Super_over;
    }
    public void setSuper_over(Boolean Super_over) {
        this.Super_over = Super_over;
    }
    public String getToss_winner() {
        return this.Toss_winner;
    }
    public void setToss_winner(String Toss_winner) {
        this.Toss_winner = Toss_winner;
    }
    public Integer getElected_to() {
        return this.Elected_to;
    }
    public void setElected_to(Integer Elected_to) {
        this.Elected_to = Elected_to;
    }


}
