/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dlastwishes
 */
public class Post {
    private long postId;
    private String postName;
    private String postInfo;
    protected int important;
    private Date date;
    private static long runId = 10000;
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
    private ListPost list;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date datetoday = new Date();

    public Post(String postName, String postInfo, int important,Date date) {
        this.postName = postName;
        this.postInfo = postInfo;
        this.important = important;
        this.date = date;
        genId();
    }
    public long genId()
    {
        this.postId = runId;
        runId++;
        return postId;
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
        String result = "";
        result += "today is "+dateFormat.format(datetoday)+"\n";
        result += "POST IT name "+ postName + " date is " + date + "\ninfo of this post is \n"+postInfo;
        result += " and Level of important is "+important+"\n";
        return result;
    }
    
    
}
