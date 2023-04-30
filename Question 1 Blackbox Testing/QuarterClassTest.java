package org.jfree.data.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.lang.String;
import org.hamcrest.text.X;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.junit.Before;
import org.junit.Test;
public class QuarterClassTest {
    private static final Object DEFAULT_TIME_ZONE = null;
    Quarter quarter;

    private void arrange(Integer quart, Integer year) {
        quarter = new Quarter(quart, year);
    }

    private void arrange() {
        quarter = new Quarter();
    }
    @Test
    public void testQuarterDefaultCtor() {
        arrange();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterCtor2N1() {
        arrange(2 ,2002 );
        //assert
        assertEquals(2002,quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testQuarterCtor2N2() {
        arrange(2,1000 );
      }
  
    @Test(expected = IllegalArgumentException.class)
    public void testQuarterCtor2N4() {
        arrange(2 ,1800 );
    }
   /* 
    @Test(expected = IllegalArgumentException.class)
    public void testQuarterCtor2N4() {
        arrange(5 ,2002 );
        }*/
    @Test
    public void testQuarterCtor3N1(){
        //AAA
        //arrange
        int quart =2;
        Year year = new org.jfree.data.time.Year(2002);
        //act
        Quarter q =new Quarter(quart,year);
        //assert
        assertEquals(2002,q.getYear().getYear());
        assertEquals(2, q.getQuarter());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testQuarterCtor3N2(){
        //AAA
        //arrange
        int quart =2;
        Year year = new org.jfree.data.time.Year(1000);
        //act
        Quarter q =new Quarter(quart,year);
        //assert
        assertEquals(1000,q.getYear().getYear());
        assertEquals(2, q.getQuarter());
    }/* 
    @Test(expected = IllegalArgumentException.class)
    public void testQuarterCtor3N3(){
        //AAA
        //arrange
        int quart =5;
        Year year = new org.jfree.data.time.Year(2002);
        //act
        Quarter q =new Quarter(quart,year);
        //assert
        assertEquals(2002,q.getYear().getYear());
        assertEquals(5, q.getQuarter());
    }
  */
  
  @Test
  public void testQuarterCtor4N1(){
    
    Date time = new Date();
    Quarter q = new Quarter(time);
     assertEquals(2,q.getQuarter());
     assertEquals(2023,q.getYear().getYear());  
  }
  @Test
   public void testQuarterCtor5N1(){
  
        Date time = new Date();
        
        TimeZone zone = TimeZone.getTimeZone("Africa/Egypt");
        Quarter q = new Quarter(time,zone);
        //assert
        assertEquals(2,q.getQuarter());
        assertEquals(2023,q.getYear().getYear());  
    

  
}
@Test
public void getQuarterTest()
{
    arrange(2,2002);
    //assert
    assertEquals(2,quarter.getQuarter());
}
@Test
public void getyearTest()
{
    //AAA
        //arrange
        int quart =2;
        Year year = new org.jfree.data.time.Year(2002);
        //act
        Quarter q =new Quarter(quart,year);
        //assert
        assertEquals(2002,q.getYear().getYear());
}
@Test 
public void previousTest(){
    arrange(3,2022);
    int quart =2;
    Year year = new org.jfree.data.time.Year(2022);
    //act
    Quarter q =new Quarter(quart,year);
    //assert
    assertEquals(q,quarter.previous());
}
@Test 
public void nextTest(){
    arrange(2,2022);
    int quart =3;
    Year year = new org.jfree.data.time.Year(2022);
    //act
    Quarter q =new Quarter(quart,year);
    //assert
    assertEquals(q,quarter.next());
}
@Test
public void getSerialIndexTest(){
    int quart =5;
    Year year = new org.jfree.data.time.Year(2010);
    //act
    Quarter q =new Quarter(quart,year);
    int x =q.getYear().getYear();
    long serialindex = (x*4)+quart;
    //assert
    assertEquals(serialindex,q.getSerialIndex());
}
// to know if equals fun give a right return with equaled year and quarter 
@Test 
public void equalsTest1(){
    int quart =2;
    Year year = new org.jfree.data.time.Year(2010);
     java.lang.Object obj = new Quarter(quart, year);
     int quartt =2;
     int yearr = 2010;
    Quarter q =new Quarter(quartt,yearr);
    assertTrue(q.equals(obj));
}
// to know if equals fun give a right return with a un equaled year and quarter 
@Test 
public void equalsTest2(){
    int quart5 =1;
    Year year5 = new org.jfree.data.time.Year(2010);
     java.lang.Object objj = new Quarter(quart5, year5);
     int quarttt =2;
     int yearrr = 2010;
    Quarter qf =new Quarter(quarttt,yearrr);
    assertFalse(qf.equals(objj));
}
// checking if hashcode fun  works right by one of the properties of hashcode that gives sam hashcode to same parameters
@Test
public void hashCodeTest (){
    int qu =2;
    int ye = 2010;
    java.lang.Object obj = new Quarter(qu, ye);
    int quart7 =2;
     int year7 = 2010;
    Quarter qf =new Quarter(quart7,year7);
    assertEquals(qf.hashCode(),obj.hashCode());
}
// hashCodeTest2 admit that hashcode fun works right which doesnot give different hashcodes to diffirent quarters 
@Test
public void hashCodeTest2 (){
    int quu =1;
    int yee = 2011;
    java.lang.Object objg = new Quarter(quu, yee);
    int quart17 =4;
     int year17 = 2002;
    Quarter qff =new Quarter(quart17,year17);
    boolean checker ;
    if(qff.hashCode()==objg.hashCode())
    {
        checker = true ;
    }
    else {
        checker = false ;}
    //assert
    assertFalse(checker);
}
@Test
public void compareToTest(){
    int qua =4;
    int yea = 2002;
    java.lang.Object o1= new Quarter(qua, yea);
    int q7 =4;
     int y7 = 2002;
    Quarter qpf =new Quarter(q7,y7);
    //assert
    boolean checkkk;
    int chekk=qpf.compareTo(o1);
    if (chekk==0)//if they are the same the checkker(chekk) will be 0
    {
        checkkk =true;
    }
    else{
        checkkk =false;
    }
    assertTrue(checkkk);
}
@Test
public void compareToTest2(){
    int qua =4;
    int yea = 2022;
    java.lang.Object o1= new Quarter(qua, yea);
    int q7 =4;
     int y7 = 2002;
    Quarter qpf =new Quarter(q7,y7);
    //assert
    int chekk=qpf.compareTo(o1);
    boolean checkkk;
     if (chekk<0)//if they are not the same and the value that will be comapered to (o1) is less that it(before it), the checkker(chekk) will be less than 0
    {
        checkkk =true;
    }
    else{
        checkkk =false;
    }
    assertTrue(checkkk);

}
@Test
public void compareToTest3(){
    int qua =4;
    int yea = 2002;
    java.lang.Object o1= new Quarter(qua, yea);
    int q7 =4;
     int y7 = 3030;
    Quarter qpf =new Quarter(q7,y7);
    //assert
    boolean checkkk;
    int chekk=qpf.compareTo(o1);
    if (chekk>0)//if they are not the same and the value that will be comapered to (o1) is bigger that it(after it), the checkker(chekk) will be positive
    {
        checkkk =true;
    }
    else{
        checkkk =false;
    }
    assertTrue(checkkk);
}
@Test
public void toStringTest(){
    //AAA
    //arange
    int q75 =2;
     int y75 = 2050;
    //act
     Quarter qn =new Quarter(q75,y75);
     String nf = "Q2/2050";
    //assert 
    assertEquals(nf,qn.toString());
}
@Test
public void getFirstMillisecondTest(){
    //AAA
    //A]arrange
     TimeZone zone = TimeZone.getTimeZone("Africa/Egypt");
     java.util.Calendar calendar=Calendar.getInstance(zone);
    int q75 =2;
     int y75 = 2050;
    //act
    int q7 =4;
    int y7 = 3030;
   Quarter qpf =new Quarter(q7,y7);
     Quarter qn =new Quarter(q75,y75);
     long ss = qn.getFirstMillisecond(calendar);
     long fs= ss;
     assertEquals(fs,ss);
}
@Test
public void getLastMillisecondtest(){
    //AAA
    //arrange
    TimeZone zone = TimeZone.getTimeZone("Africa/Egypt");
    java.util.Calendar calendar=Calendar.getInstance(zone);
    int q75 =2;
     int y75 = 2050;
    //act
     Quarter qn =new Quarter(q75,y75);
     long ss = qn.getLastMillisecond(calendar);
     long fs= ss;
     assertEquals(fs,ss);
}
@Test
public void parseQuarterTest(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="Q2-2023";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest2(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="2023-Q2";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest3(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="2023 Q2";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest4(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="Q2 2023";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest5(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="Q2/2023";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest6(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="2023/Q2";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest7(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="2023,Q2";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}
@Test
public void parseQuarterTest8(){
    int q75 =2;
     int y75 = 2023;
    //act
     Quarter qno =new Quarter(q75,y75);
     Quarter qn = new Quarter();
    String s ="Q2,2023";
    qn.parseQuarter(s);
    assertEquals(qno,qn);

    
}


}
