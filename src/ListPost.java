/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dlastwishes
 */
public class ListPost{
      private Post postList;

    public ListPost(Post postList) {
        this.postList = postList;
    }

    public Post getPostList() {
        return postList;
    }

    public void setPostList(Post postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        String result = "";
        result += postList;
        return result;
    }
   
}
