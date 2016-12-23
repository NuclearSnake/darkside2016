package com.neomysideprojects.darkside2016;

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
}
