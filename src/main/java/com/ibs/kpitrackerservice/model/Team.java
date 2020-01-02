package com.ibs.kpitrackerservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team")
public class Team {

    @Id
    private ObjectId id;
    private String name;

    public Team() {

    }

    public Team(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    //Converting ObjectId to HexString inorder to keep the primary identifier more readable while converting it as json
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
