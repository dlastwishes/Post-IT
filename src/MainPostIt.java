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
public class MainPostIt {
    
    public static void main(String[] args) throws ParseException
    {  
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        PostUser user1 = new PostUser("Dump",12354);
        Post p1 = new Post("p1","this message for test about info",1,format.parse("23/04/2559"));
        Post p2 = new Post("p2","reminder about tomorrow",3,format.parse("13/07/2559"));
        Post p3 = new Post("p3","Java",5,format.parse("23/05/2559"));
        Post p4 = new Post("p4","Test 4",2,format.parse("23/07/2539"));
        Post p5 = new Post("p5","test 5",4,format.parse("17/08/2542"));
        Post p6 = new Post("p6","Test 6",1,format.parse("14/05/2514"));
        
        ListPost[] list1 = {new ListPost(p1),new ListPost(p2),new ListPost(p3)};
        Report rep1 = new Report(list1,user1);
        System.out.println(rep1);
    }
}
