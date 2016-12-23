package com.neomysideprojects.darkside2016;

import java.io.IOException;

/**
 *
 * @author Neo
 */
public class DataManager implements DBManager, InternetManager{
    private DBManager database;
    private InternetManager internet;
    
    public DataManager(DBManager dbmanager, InternetManager imanager){
        database = dbmanager;
        internet = imanager;
    }
    
    public void setDBManager(DBManager manager){
        database = manager;
    }

    public void setInternetManager(InternetManager manager){
        internet = manager;
    }

    public CommentExtended readComment(int id) {
        return database.readComment(id);
    }

    public IdeaExtended readIdea(int id) {
        return database.readIdea(id);
    }

    public int writeComment(Comment c) {
        return database.writeComment(c);
    }

    public int writeIdea(Idea i) {
        return database.writeIdea(i);
    }

    public int updateComment(Comment c, int id) {
        return database.updateComment(c, id);
    }

    public int updateIdea(Idea i, int id) {
        return database.updateIdea(i, id);
    }

    public Comment extractComment(String json) throws IOException{
        return internet.extractComment(json);
    }

    public Idea extractIdea(String json) throws IOException{
        return internet.extractIdea(json);
    }

    public CommentExtended extractCommentExtended(String json) throws IOException{
        return internet.extractCommentExtended(json);
    }

    public IdeaExtended extractIdeaExtended(String json) throws IOException{
        return internet.extractIdeaExtended(json);
    }

    public String insertComment(Comment c) throws IOException{
        return internet.insertComment(c);
    }

    public String insertIdea(Idea i) throws IOException{
        return internet.insertIdea(i);
    }

}