package com.itroos.cricapp.data.models;

public class MatchesModel {
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
    private String Date;
    private Integer Total_score;
    private Integer Status;

    public Integer getTotal_score() {
        return Total_score;
    }

    public void setTotal_score(Integer total_score) {
        Total_score = total_score;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam_a_name() {
        return Team_a_name;
    }

    public void setTeam_a_name(String team_a_name) {
        Team_a_name = team_a_name;
    }

    public String getTeam_b_name() {
        return Team_b_name;
    }

    public void setTeam_b_name(String team_b_name) {
        Team_b_name = team_b_name;
    }

    public String getTeam_a_Id() {
        return Team_a_Id;
    }

    public void setTeam_a_Id(String team_a_Id) {
        Team_a_Id = team_a_Id;
    }

    public String getTeam_b_Id() {
        return Team_b_Id;
    }

    public void setTeam_b_Id(String team_b_Id) {
        Team_b_Id = team_b_Id;
    }

    public Integer getBatter_per_team() {
        return Batter_per_team;
    }

    public void setBatter_per_team(Integer batter_per_team) {
        Batter_per_team = batter_per_team;
    }

    public Integer getOvers_per_innings() {
        return Overs_per_innings;
    }

    public void setOvers_per_innings(Integer overs_per_innings) {
        Overs_per_innings = overs_per_innings;
    }

    public Integer getMax_over_per_bowler() {
        return Max_over_per_bowler;
    }

    public void setMax_over_per_bowler(Integer max_over_per_bowler) {
        Max_over_per_bowler = max_over_per_bowler;
    }

    public Boolean getSuper_over() {
        return Super_over;
    }

    public void setSuper_over(Boolean super_over) {
        Super_over = super_over;
    }

    public String getToss_winner() {
        return Toss_winner;
    }

    public void setToss_winner(String toss_winner) {
        Toss_winner = toss_winner;
    }

    public Integer getElected_to() {
        return Elected_to;
    }

    public void setElected_to(Integer elected_to) {
        Elected_to = elected_to;
    }
}
