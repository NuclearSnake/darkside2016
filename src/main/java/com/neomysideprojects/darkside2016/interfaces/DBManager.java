package com.neomysideprojects.darkside2016.interfaces;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.neomysideprojects.darkside2016.data.*;

/**
 *
 * @author Neo
 */
public interface DBManager {
    public static final int DUPLICATE_USER_NAME = -124;

    IdeaExtended readIdea(int id);
    int writeIdea(Idea i);
    int updateIdea(Idea i);
    CommentExtended readComment(int id);
    int writeComment(Comment c);
    int updateComment(Comment c);
    boolean readVote(int user_id, int idea_id);
    int writeVote(Vote v);
    int updateVote(Vote v);

    User readUser(int user_id);
    UserFull readUserFull(int user_id);
    int writeUser(User u);
    int writeUser(UserFull u);
    int registerUser(String name, String password);
    int updateUser(User u);
    int updateUser(UserFull u);

    Tag readTag(int tag_id);
    int writeTag(Tag tag);
    int updateTag(Tag tag);

    boolean checkAdmin(int user_id);
}
