package com.neomysideprojects.darkside2016;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *
 * @author Neo
 */
public class JacksonManager implements InternetManager{
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
    
}
