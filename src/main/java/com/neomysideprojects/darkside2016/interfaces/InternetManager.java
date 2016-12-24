package com.neomysideprojects.darkside2016.interfaces;

import com.neomysideprojects.darkside2016.data.*;

import java.io.IOException;

/**
 *
 * @author Neo
 */
public interface InternetManager {
    public Comment extractComment(String json) throws IOException;
    public Idea extractIdea(String json) throws IOException;
    public CommentExtended extractCommentExtended(String json) throws IOException;
    public IdeaExtended extractIdeaExtended(String json) throws IOException;
    public String insertComment(Comment c) throws IOException;
    public String insertIdea(Idea i) throws IOException;
    public Vote extractVote(String json) throws IOException;
    public String insertVote(Vote v) throws IOException;
    public User extractUser(String json) throws IOException;
    public UserFull extractUserFull(String json) throws IOException;
    public String insertUser(User u) throws IOException;
    public String insertUser(UserFull u) throws IOException;
    public Tag extractTag(String json) throws IOException;
    public String insertTag(Tag tag) throws IOException;
}
