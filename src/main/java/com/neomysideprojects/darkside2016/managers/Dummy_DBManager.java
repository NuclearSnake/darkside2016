package com.neomysideprojects.darkside2016.managers;

import com.neomysideprojects.darkside2016.data.Comment;
import com.neomysideprojects.darkside2016.data.CommentExtended;
import com.neomysideprojects.darkside2016.data.Idea;
import com.neomysideprojects.darkside2016.data.IdeaExtended;
import com.neomysideprojects.darkside2016.interfaces.DBManager;

/**
 *
 * @author Neo
 */
public abstract class Dummy_DBManager implements DBManager {

    public CommentExtended readComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IdeaExtended readIdea(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int writeComment(Comment c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int writeIdea(Idea i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateComment(Comment c, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateIdea(Idea i, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
