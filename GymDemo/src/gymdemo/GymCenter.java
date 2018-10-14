/*
 * Java
 */
package gymdemo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Julia
 */
public class GymCenter {
    
    public static List<PersonInfo> readFile(String src){
        Path path = Paths.get(src);
        List<PersonInfo> people = new ArrayList<>();
        String temp = null;
        String num=null;
        String name=null;
        LocalDate regDate=null;
        
        try(BufferedReader br = Files.newBufferedReader(path)){
            while((temp=br.readLine()) != null && !temp.trim().equals("")){
                num=temp.substring(0, temp.indexOf(",")).trim();
                name=temp.substring(temp.indexOf(",")+1).trim();
                if((temp=br.readLine()).trim() != ""){
                    regDate=LocalDate.parse(temp.trim());
                }
                people.add(new PersonInfo(num, name, regDate));
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        return people;
    }
    
    public static PersonInfo matchKund(String num, List<PersonInfo> allpeople){
        for(PersonInfo p: allpeople){
            if(p.getNum().equals(num)){
                return p;
            }
        }
        return null;
    }
    
    public static PersonInfo matchDate(PersonInfo kund){
        int year = LocalDate.now().getYear() -1;
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        LocalDate oneyear = LocalDate.of(year, month, day); 
        if(oneyear.isBefore(kund.getDate())){
            return kund;
        } 
        else{
            return null;
        }
    }
    
    public static List<KundInfo> checked(List<KundInfo> kunder, PersonInfo person){
        KundInfo kund = new KundInfo(person.getNum(), person.getName(), person.getDate());
        LocalDate today = LocalDate.now();
        if(kunder.contains(kund)){
            kunder.get(kunder.indexOf(kund)).addDate(today);
        }
        else{
            kunder.add(kund);
            kund.addDate(today);
        }
        return kunder;
    }
    
    public static void writeFile(String src, List<KundInfo> checkPerson){
        Path writePath = Paths.get(src);
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writePath, StandardCharsets.UTF_8))){
            for(KundInfo k: checkPerson){
                pw.print(k.getInfo()+ "\n");
            }
        }
        catch(Exception exc){
            System.out.println("Error: " + exc);
        }
    }

    
}
