/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dlastwishes
 */
public class PostUser {
    private long userId;
    private String userName;
    private long password;
    private static long runId = 100;

    public PostUser(String userName,long password) {
        this.password = password;
        this.userName = userName;
        genId();
    }

    public PostUser() {
        this.userName = "Unknown";
        genId();
    }
    
    public long genId(){
        this.userId = runId;
        runId++;
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;
    }
    
    
}
