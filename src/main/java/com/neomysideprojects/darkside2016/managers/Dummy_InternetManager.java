package com.neomysideprojects.darkside2016.managers;

import com.neomysideprojects.darkside2016.data.Comment;
import com.neomysideprojects.darkside2016.data.CommentExtended;
import com.neomysideprojects.darkside2016.data.Idea;
import com.neomysideprojects.darkside2016.data.IdeaExtended;
import com.neomysideprojects.darkside2016.interfaces.InternetManager;

/**
 *
 * @author Neo
 */
public abstract class Dummy_InternetManager implements InternetManager {

    public Comment extractComment(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Idea extractIdea(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CommentExtended extractCommentExtended(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IdeaExtended extractIdeaExtended(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String insertComment(Comment c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String insertIdea(Idea i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
