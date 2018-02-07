/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_POSTIT;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author dlastwishes
 */
public class Process {
    
    // method สำหรับเช็คค่า username หลัก
    public String checkUsername(long userId) throws ClassNotFoundException, SQLException {
        String username = "";
        Connection conn = Connectionbuilder.connect();
        String sql = "select * from APP.postuser";
        Statement std = conn.createStatement();
        std.executeQuery(sql);
        ResultSet rs = std.getResultSet();
        
        while(rs.next()){
            if(userId==rs.getLong("userid")){
                username = rs.getString("username");
            }
        }
        return username;
    }
    
    public boolean chechStatus(long userId) throws ClassNotFoundException, SQLException{
        //method สำหรับเช็ค status ของผู้ใช้ และคืนค่ากลับเป็น boolean
          boolean status;
        Connection conn = Connectionbuilder.connect();
        String sql = "select * from APP.postuser where userid = "+userId+"";
        Statement std = conn.createStatement();
        std.executeQuery(sql);
        ResultSet rs = std.getResultSet();
        
        while(rs.next()){
            if(rs.getString("userstatus").equalsIgnoreCase("Admin")){
               return true;
            }
        }
        return false;
        
    }
    
    public String checkOwnUsername(long postId) throws ClassNotFoundException, SQLException{
        String ownUser = "";
        Connection conn = Connectionbuilder.connect();
        String sql = "select * from APP.postit";
        Statement std = conn.createStatement();
        std.executeQuery(sql);
        ResultSet rs = std.getResultSet();
        
        while(rs.next()){
            if(postId==rs.getLong("postid")){
                ownUser += checkUsername(rs.getLong("userid"));
            }
        }
        
        
        return ownUser;
    }
    
    public int checkImportant(int e){
        //ใช่เช็ค ค่าจาก Radio และแปลงเป็นค่า Important เพื่อป้อนลง Database
        int imp=0;
        switch (e){
            case 49 : imp=1;
            break;
            case 50 : imp=2;
            break;
            case 51 : imp=3;
            break;
            case 52 : imp=4;
            break;
            case 53 : imp=5;
            break;
        }
        
        return imp;
    }
   
    public static ArrayList<PostEvent> execute(String sql) throws ClassNotFoundException, SQLException {
        //ใช้ดึงค่าจาก DB มาเก็บใน ArrayList<PostEvent>
        Connection conn = Connectionbuilder.connect();
        Statement st = conn.createStatement();
        
        boolean isSelectCmd = st.execute(sql);
        ArrayList<PostEvent> al = null;
        if (isSelectCmd) {
            ResultSet rs = st.getResultSet();
            int co = 0;
            al = new ArrayList<PostEvent>();
            while (rs.next()) {
                PostEvent p = new PostEvent();
                orm(rs, p);
//                System.out.println("before now size is : "+al.size());
                al.add(p);
//                System.out.println("After now size is : "+al.size());
            }
        } else {
            int rec = st.getUpdateCount();
            System.out.println(rec + " rec updated");
        }
        conn.close();
        return al;
    }

    public static void orm(ResultSet rs, PostEvent pe) throws SQLException {
        //สร้างตัวเชื่อมโยงในการเก็บค่าจาก DB ไปเก็บยังคลาส PostEvent
        pe.setPostId(rs.getLong("postid"));
        pe.setPostName(rs.getString("postname"));
        pe.setPostInfo(rs.getString("postinfo"));
        pe.setImportant(rs.getInt("important"));
        pe.setDate(rs.getDate("date"));
        
    }
    
    public String checkDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        String day="";
        String month="";
        String year ="";
        if((cal.get(cal.DATE))< 10){
            day = "0"+cal.get(cal.DATE);
        }
        else {
            day = String.valueOf(cal.get(cal.DATE));
        }
        if((cal.get(cal.MONTH)+1)<10){
            month = "0"+(cal.get(cal.MONTH)+1);
        }
        else {
            month = String.valueOf((cal.get(cal.MONTH)+1));
        }
        if((cal.get(cal.YEAR))< 10 ){
            year = "0"+(cal.get(cal.YEAR)+543);
            System.out.println(year);
        }
        else {
            year = String.valueOf(cal.get(cal.YEAR)+543);
        }
        System.out.println(day+"/"+month+"/"+year);
        String date = day+"/"+month+"/"+year;
        
        return date;
    }
}
