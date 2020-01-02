package com.ibs.kpitrackerservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    @Id
    private ObjectId id;

    @DBRef
    private Team team;

    private String employeeName;

    private String userName;

    private String password;

    private String privilege;

    public User() {

    }

    public User(String employeeName, String userName, String password, String privilege, Team team) {
        this.employeeName = employeeName;
        this.userName = userName;
        this.password = password;
        this.privilege = privilege;
        this.team = team;
    }

    //Converting ObjectId to HexString inorder to keep the primary identifier more readable while converting it as json
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

}
