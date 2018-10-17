/*
 * Java
 */
package gymobjdemo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import java.util.*;
import junit.framework.TestCase;

/**
 *
 * @author Julia
 */
public class GymCenterTest {
        String testPath = "test\\gymobjdemo\\test.txt";
        LocalDate d1 = LocalDate.parse("2017-10-15");
        PersonInfo p1 = new PersonInfo("1000000001", "Alhambra Aromes", d1);
        LocalDate d2 = LocalDate.parse("2017-10-16");
        PersonInfo p2 = new PersonInfo("1000000002", "Bear Belle", d2);
        LocalDate d3 = LocalDate.parse("2017-10-17");
        PersonInfo p3 = new PersonInfo("1000000003", "Chamade Coriola", d3);
        LocalDate d4 = LocalDate.parse("2017-10-18");
        PersonInfo p4 = new PersonInfo("1000000004", "Diamanda Djedi", d4);
        LocalDate d5 = LocalDate.parse("2017-10-19");
        PersonInfo p5 = new PersonInfo("1000000005", "Elmer Ekorrsson", d5);
        LocalDate d6 = LocalDate.parse("2017-10-20");
        PersonInfo p6 = new PersonInfo("1000000006", "Fritjoff Flacon", d6);
        LocalDate d7 = LocalDate.parse("2018-03-23");
        PersonInfo p7 = new PersonInfo("1000000007", "Greger Ganache", d7);
        LocalDate d8 = LocalDate.parse("2018-08-18");
        PersonInfo p8 = new PersonInfo("1000000008", "Hilmer Heur", d8);
        List<PersonInfo> allpeople = new ArrayList<>();
        
//    @Test
//    public void testReadFile(){
//        allpeople.add(p1);
//        allpeople.add(p2);
//        allpeople.add(p3);
//        allpeople.add(p4);
//        allpeople.add(p5);
//        allpeople.add(p6);
//        allpeople.add(p7);
//        allpeople.add(p8);
//        List<PersonInfo> peopletest = GymCenter.readFile(testPath);
//        TestCase.assertEquals(allpeople.get(0).getInfo(), peopletest.get(0).getInfo());
//    }
//    
    @Test
    public void testMatchKund(){
        allpeople.add(p1);
        allpeople.add(p2);
        allpeople.add(p3);
        allpeople.add(p4);
        String test1 = "1000000001";
        String test2 = "  Bear Belle  ";
        String testwrong = "xxxxxxx";
        String testnull = "";
        TestCase.assertEquals(p1, GymCenter.matchKund(test1, allpeople));
        TestCase.assertEquals(p2, GymCenter.matchKund(test2, allpeople));
        TestCase.assertNull(GymCenter.matchKund(testwrong, allpeople));
        TestCase.assertNull(GymCenter.matchKund(testnull, allpeople));
    }
    
    @Test
    public void testMatchDate(){
        allpeople.add(p2);
        allpeople.add(p3);
        allpeople.add(p4);
        allpeople.add(p5);
        allpeople.add(p6);
        TestCase.assertNull(GymCenter.matchDate(p2));
        TestCase.assertNull(GymCenter.matchDate(p3));
        TestCase.assertEquals(p4, GymCenter.matchDate(p4));
        TestCase.assertEquals(p5, GymCenter.matchDate(p5));
    }
    
    @Test
    public void testChecked(){
        LocalDate d1 = LocalDate.parse("2018-08-18");
       // LocalDateTime t1 = LocalDateTime.parse("2018-10-10 15:20:25");
        KundInfo kund1 = new KundInfo("10000000028", "Hilmer H Heur", d1);
        PersonInfo p10 = new PersonInfo("10000000028", "Hilmer H Heur", d1);
        //kund1.setDateTime(t1);
        LocalDate d2 = LocalDate.parse("2018-08-20");
        //LocalDateTime t2 = LocalDateTime.parse("2018-10-12 15:20:25");
        KundInfo kund2 = new KundInfo("10000000027", "Greger H Ganache", d2);
        PersonInfo p11 = new PersonInfo("10000000027", "Greger H Ganache", d2);
       // kund1.setDateTime(t2);
        List<KundInfo> kundlist = new ArrayList<>();
        TestCase.assertEquals(kund1.getNum(), GymCenter.checked(kundlist, p10).get(0).getNum());
        TestCase.assertEquals(kund2.getNum(), GymCenter.checked(kundlist, p11).get(1).getNum());
        
        
    }
    
}
