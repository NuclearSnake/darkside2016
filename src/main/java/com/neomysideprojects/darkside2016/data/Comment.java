package com.neomysideprojects.darkside2016.data;

import java.sql.Timestamp;

/**
 *
 * @author Neo
 */
public class Comment {
    protected final int user_id;
    protected final int idea_id;
    
    protected String text;
    protected Timestamp timestamp;
    
    public Comment(int user_id, int idea_id){
        this.user_id = user_id;
        this.idea_id = idea_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = (Timestamp)timestamp.clone();
    }
    
    public int getUser_id(){
        return user_id;
    }
    
    public int getIdea_id(){
        return idea_id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("com.neomysideprojects.darkside2016.com.neomysideprojects.darkside2016.data.Comment: {user: ");sb.append(user_id);
        sb.append(", idea: ");        sb.append(idea_id);
        sb.append(", timestamp: ");   sb.append(timestamp);
        sb.append(", text: ");        sb.append(text);
        sb.append("}");
        return sb.toString();
    }
}