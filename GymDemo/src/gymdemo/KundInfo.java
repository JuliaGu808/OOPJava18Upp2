/*
 * Java
 */
package gymdemo;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Julia
 */
public class KundInfo extends PersonInfo{
    
    List<LocalDate> checkDate = new ArrayList<>();
    
    public KundInfo(String number, String name, LocalDate regDate) {
        super(number, name, regDate);
    }
    
    public void addDate(LocalDate date){
        checkDate.add(date);
    }
    @Override
    public String getInfo(){
        return "Name: " + super.name + "\tTotal: " + checkDate.size() + " times.";
    }
    
}
