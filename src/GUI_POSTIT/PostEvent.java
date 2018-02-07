/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.util.Date;

/**
 *
 * @author dlastwishes
 */
public class PostEvent {
    private long postId;
    private String postName;
    private String postInfo;
    private int important;
    private Date date;

    public PostEvent(long postId, String postName, String postInfo, int important, Date date) {
        this.postId = postId;
        this.postName = postName;
        this.postInfo = postInfo;
        this.important = important;
        this.date = date;
    }

    public PostEvent(String postName, String postInfo, int important, Date date) {
        this.postName = postName;
        this.postInfo = postInfo;
        this.important = important;
        this.date = date;
    }

    public PostEvent() {
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        String result= "";
         result += "POST IT name is " + postName;
                    result += "\ninfo : ";
                    result += postInfo;
                    result += "\nDate: ";
                    result += date + "\n";
                    result += "important : ";
                    result += important;
                    result += "\n-------------------------------------------------\n";
        return result;
    }
    
    
}
