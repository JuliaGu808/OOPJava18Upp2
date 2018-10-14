/*
 * Java
 */

package gymdemo;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import javax.swing.*;


public class GymDemo {
    public GymDemo(){
        String readPath = "src\\gymdemo\\customers.txt";            
        String writePath = "src\\gymdemo\\kunders.txt";            
        List<PersonInfo> allpeople = GymCenter.readFile(readPath);
        List<KundInfo> kunder = new ArrayList<>();
        String num;
        while(true){
            num = JOptionPane.showInputDialog("Your number?");
            if(num==null || num.trim().equals(""))
                System.exit(0);
            if(GymCenter.matchKund(num, allpeople) == null){
                JOptionPane.showMessageDialog(null, "Ingen meddlem!!!");
            }
            else{
                PersonInfo person = GymCenter.matchKund(num, allpeople);
                if(GymCenter.matchDate(person) == null){
                    JOptionPane.showMessageDialog(null, "Oj! Out of date!!!\n" + person.getInfo());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hej, dear customer!\n" + person.getInfo());
                    GymCenter.checked(kunder, person);
                    GymCenter.writeFile(writePath, kunder);
                }
            }
        }    
    }
    
    public static void main(String[] args) {
        GymDemo gym = new GymDemo();
       
    }

}
