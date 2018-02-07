/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI_POSTIT.Connectionbuilder;
import java.sql.Connection;
/**
 *
 * @author dlastwishes
 */
public class Report{
    private ListPost listPost[];
    private PostUser user;
    private Post post;

    public Report(ListPost[] listPost, PostUser user) {
        this.listPost = listPost;
        this.user = user;
    }

    public PostUser getUser() {
        return user;
    }

    public void setUser(PostUser user) {
        this.user = user;
    }


    @Override
    public String toString() {
        String result = "";
        int top = 5;
        result += "Username " + user + "\n";
        result += "this is List of your PostIt\n";
        for(int i=5;i<=top;i--){   
            for(int j=0;j<listPost.length;j++){
                if(listPost[j].getPostList().important==i){
                    result += listPost[j]+"\n";
                }
            }  
            }
            
            

        return result;
    }
    
    
    
}
