package com.itroos.cricapp.dbo.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private Boolean LoginStatus;
    private String FullName;
    private String DateOfBirth;
    private String Gender;
    @Generated(hash = 2951736)
    public User(Long id, Boolean LoginStatus, String FullName, String DateOfBirth,
            String Gender) {
        this.id = id;
        this.LoginStatus = LoginStatus;
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getLoginStatus() {
        return this.LoginStatus;
    }
    public void setLoginStatus(Boolean LoginStatus) {
        this.LoginStatus = LoginStatus;
    }
    public String getFullName() {
        return this.FullName;
    }
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    public String getDateOfBirth() {
        return this.DateOfBirth;
    }
    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }
    public String getGender() {
        return this.Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
}
