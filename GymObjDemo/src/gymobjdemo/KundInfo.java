/*
 * Java
 */
package gymobjdemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Julia
 */
public class KundInfo {
    protected String number;
    protected String name;
    String datetime;
    protected LocalDate regDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    protected LocalDateTime checkDateTime;
    
    
    public KundInfo(String number, String name, LocalDate regDate) {
        this.number=number;
        this.name=name;
        this.regDate=regDate;
    }
    public KundInfo(String number, String name, String datetime) {
        this.number=number;
        this.name=name;
        this.datetime=datetime;
    }
    
    public void setDateTime(LocalDateTime checkDateTime){
        this.checkDateTime=checkDateTime;
    }
    public String getNum(){
        return number;
    }
    public String getDatetime(){
        return datetime;
    }
    public LocalDateTime getDateTime(){
        return checkDateTime;
    }
    
    public String getInfo(){
        return name + " , " + number + " , " + formatter.format(checkDateTime);
    }
    public String getMesg(){
        return name + " , " + number + " , Total: " ;
        
    }
}
