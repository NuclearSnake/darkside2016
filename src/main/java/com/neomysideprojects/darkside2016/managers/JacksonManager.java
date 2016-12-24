package com.neomysideprojects.darkside2016.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neomysideprojects.darkside2016.data.*;
import com.neomysideprojects.darkside2016.interfaces.InternetManager;

import java.io.IOException;

/**
 *
 * @author Neo
 */
public class JacksonManager implements InternetManager {
    private ObjectMapper mapper = new ObjectMapper();
    
    public JacksonManager(){}
    
    public Comment extractComment(String json) throws IOException{
        return mapper.readValue(json, Comment.class);
    }

    public Idea extractIdea(String json) throws IOException{
        return mapper.readValue(json, Idea.class);
    }

    public CommentExtended extractCommentExtended(String json) throws IOException{
        return mapper.readValue(json, CommentExtended.class);
    }

    public IdeaExtended extractIdeaExtended(String json) throws IOException{
        return mapper.readValue(json, IdeaExtended.class);
    }

    public String insertComment(Comment c) throws IOException{
        return mapper.writeValueAsString(c);
    }

    public String insertIdea(Idea i) throws IOException{
        return mapper.writeValueAsString(i);
    }

    public Vote extractVote(String json) throws IOException{
        return mapper.readValue(json, Vote.class);
    }

    public String insertVote(Vote v) throws IOException{
        return mapper.writeValueAsString(v);
    }

    public User extractUser(String json) throws IOException{
        return mapper.readValue(json, User.class);
    }

    public UserFull extractUserFull(String json) throws IOException{
        return mapper.readValue(json, UserFull.class);
    }

    public String insertUser(User u) throws IOException{
        return mapper.writeValueAsString(u);
    }

    public String insertUser(UserFull u) throws IOException{
        return mapper.writeValueAsString(u);
    }

    public Tag extractTag(String json) throws IOException{
        return mapper.readValue(json, Tag.class);
    }

    public String insertTag(Tag tag) throws IOException{
        return mapper.writeValueAsString(tag);
    }
}
