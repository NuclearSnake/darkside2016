package com.neomysideprojects.darkside2016;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neo
 */
public interface DBManager {
    public CommentExtended readComment(int id);
    public IdeaExtended readIdea(int id);
    public int writeComment(Comment c);
    public int writeIdea(Idea i);
    public int updateComment(Comment c, int id);
    public int updateIdea(Idea i, int id);   
}
