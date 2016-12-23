package com.neomysideprojects.darkside2016;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neo
 */
public class Idea {
    protected final int user_id;
    
    protected String link;
    protected String text;
    protected byte[] file;
    protected Timestamp timestamp;
    protected List<Tag> tags;

    public Idea(int user_id){
        this.user_id = user_id;
    }
    
    public Idea(int user_id, String link, String text, byte[] file){
        this.user_id = user_id;
        this.link = link;
        this.text = text;
        this.file = file;
    }
    
    public void setTags(List<Tag> tags){
        this.tags = new ArrayList<Tag>(tags);
    }


    public String getLink() {
        return link;
    }

    public Idea setLink(String link) {
        this.link = link;
        return this;
    }

    public String getText() {
        return text;
    }

    public Idea setText(String text) {
        this.text = text;
        return this;
    }

    public byte[] getFile() {
        return file;
    }

    public Idea setFile(byte[] file) {
        this.file = file;
        return this;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Idea setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("com.neomysideprojects.darkside2016.com.neomysideprojects.darkside2016.Idea: {user: ");sb.append(user_id);
        sb.append(", timestamp: ");   sb.append(timestamp);
        sb.append(", tags: ");        sb.append(tags.toString());
        sb.append(", text: ");        sb.append(text);
        sb.append(", link: ");        sb.append(link);
        sb.append(", file: ");        sb.append(file);
        sb.append("}");
        return sb.toString();
    }
    
}
