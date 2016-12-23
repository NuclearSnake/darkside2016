package com.neomysideprojects.darkside2016;

/**
 *
 * @author Neo
 */
class IdeaExtended extends Idea{
    private final int id;
    private String author_name;
    private int rating = -1;

    public IdeaExtended(int id, int user_id, String author) {
        super(user_id);
        this.id = id;
        this.author_name = author;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("com.neomysideprojects.darkside2016.com.neomysideprojects.darkside2016.Idea ");           sb.append(id);
        sb.append(": {user: ");       sb.append(user_id);
        sb.append(", username: ");    sb.append(author_name);       
        sb.append(", timestamp: ");   sb.append(timestamp);
        sb.append(", rating: ");      sb.append(rating);        
        sb.append(", tags: ");        sb.append(tags.toString());
        sb.append(", text: ");        sb.append(text);
        sb.append(", link: ");        sb.append(link);
        sb.append(", file: ");        sb.append(file);
        sb.append("}");
        return sb.toString();
    }
    
}
