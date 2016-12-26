package com.neomysideprojects.darkside2016;

import com.neomysideprojects.darkside2016.data.*;
import com.neomysideprojects.darkside2016.interfaces.DBManager;
import com.neomysideprojects.darkside2016.interfaces.InternetManager;

import java.io.IOException;

/**
 *
 * @author Neo
 */
public class DataManager implements DBManager, InternetManager {
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

    public int updateComment(Comment c) {
        return 0;
    }

    public int writeIdea(Idea i) {
        return database.writeIdea(i);
    }

    public int updateIdea(Idea i) {
        return database.updateIdea(i);
    }

    public boolean readVote(int user_id, int idea_id) {
        return database.readVote(user_id, idea_id);
    }

    public int writeVote(Vote v) {
        return database.writeVote(v);
    }

    public int updateVote(Vote v) {
        return database.updateVote(v);
    }

    public User readUser(int user_id) {
        return database.readUser(user_id);
    }

    public UserFull readUserFull(int user_id) {
        return database.readUserFull(user_id);
    }

    public int writeUser(User u) {
        return database.writeUser(u);
    }

    public int writeUser(UserFull u) {
        return database.writeUser(u);
    }

    public int registerUser(String name, String password) {
        return database.registerUser(name, password);
    }

    public int isExistingUser(String name, String password) {
        return database.isExistingUser(name, password);
    }

    public byte[] loginUser(String name, String password) {
        return database.loginUser(name, password);
    }

    public int updateUser(User u) {
        return database.updateUser(u);
    }

    public int updateUser(UserFull u) {
        return database.updateUser(u);
    }

    public Tag readTag(int tag_id) {
        return database.readTag(tag_id);
    }

    public int writeTag(Tag tag) {
        return database.writeTag(tag);
    }

    public int updateTag(Tag tag) {
        return database.updateTag(tag);
    }

    public boolean checkAdmin(int user_id) {
        return database.checkAdmin(user_id);
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

    public Vote extractVote(String json) throws IOException {
        return internet.extractVote(json);
    }

    public String insertVote(Vote v) throws IOException {
        return internet.insertVote(v);
    }

    public User extractUser(String json) throws IOException {
        return internet.extractUser(json);
    }

    public UserFull extractUserFull(String json) throws IOException {
        return internet.extractUserFull(json);
    }

    public String insertUser(User u) throws IOException {
        return internet.insertUser(u);
    }

    public String insertUser(UserFull u) throws IOException {
        return internet.insertUser(u);
    }

    public Tag extractTag(String json) throws IOException {
        return internet.extractTag(json);
    }

    public String insertTag(Tag tag) throws IOException {
        return internet.insertTag(tag);
    }

}