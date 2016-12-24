package com.neomysideprojects.darkside2016.data;

import java.sql.Timestamp;

/**
 * Created by Neo on 23.12.2016.
 */
public class Vote {
    protected int user_id;
    protected int idea_id;
    protected boolean like;

    public Vote(int user_id, int idea_id, boolean like, Timestamp timestamp) {
        this.user_id = user_id;
        this.idea_id = idea_id;
        this.like = like;
        this.timestamp = timestamp;
    }

    public Vote(int user_id, int idea_id, boolean like) {
        this(user_id, idea_id, like, null);
    }

    public Vote(int user_id, int idea_id) {
        this(user_id, idea_id, true, null);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIdea_id() {
        return idea_id;
    }

    public void setIdea_id(int idea_id) {
        this.idea_id = idea_id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    protected Timestamp timestamp;

}
