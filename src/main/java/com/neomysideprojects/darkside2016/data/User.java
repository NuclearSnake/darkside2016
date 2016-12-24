package com.neomysideprojects.darkside2016.data;

import java.sql.Timestamp;

/**
 * Created by Neo on 23.12.2016.
 */
public class User {
    protected int user_id = -1;
    protected String name;
    protected Timestamp registrationDate = null;
    protected int rating;

    public User(){
        this("");
    }

    public User(String name) {
        this(-1, name);
    }

    public User(int user_id, String name) {
        this(user_id, name, null);
    }

    public User(int user_id, String name, Timestamp registrationDate) {
        this.user_id = user_id;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public int getUser_id() {return user_id;}

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
