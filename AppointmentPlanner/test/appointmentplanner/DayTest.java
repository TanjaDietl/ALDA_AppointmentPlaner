/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentplanner;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author sriem
 */
public class DayTest {
    
    TimeSpan ts1 = new TimeSpan(1, 0);
    Time time1 = new Time(9, 30);
    Time time2 = new Time(10, 00);
    Time time3 = new Time(14, 30);
    
    Appointment app1 = new Appointment("TestAppointment Nr1", ts1);
    Appointment app2 = new Appointment("TestAppointment Nr2.1", ts1);
    Appointment app3 = new Appointment("TestAppointment Nr3", ts1);
    
    Day testDay = new Day(1);
    
    @Before
    public void initialize() {
        app1.setStart(time1);
        app2.setStart(time2);
        app3.setStart(time3);
        
    }
    
    @Test
    public void testDay() {
        assertEquals(1, testDay.getNrOfAppointments());
    }

    /**
     * Test of getNrOfAppointments method, of class Day.
     */
    
    @Test
    public void testGetNrOfAppointments() {
        assertEquals(1, testDay.getNrOfAppointments());
    }

    /**
     * Test of getNameOfTheDay method, of class Day.
     */
    
    @Test
    public void testGetNameOfTheDay() {
        assertEquals("Monday", testDay.getNameOfTheDay());
        Day testDay2 = new Day(2);
        assertEquals("Tuesday", testDay2.getNameOfTheDay());
        Day testDay3 = new Day(3);
        assertEquals("Wednesday", testDay3.getNameOfTheDay());
        Day testDay4 = new Day(4);
        assertEquals("Thursday", testDay4.getNameOfTheDay());
        Day testDay5 = new Day(5);
        assertEquals("Friday", testDay5.getNameOfTheDay());
        Day testDay6 = new Day(6);
        assertEquals("Saturday", testDay6.getNameOfTheDay());
        Day testDay7 = new Day(7);
        assertEquals("Sunday", testDay7.getNameOfTheDay());
        
    }

    /**
     * Test of canAddAppointmentOfDuration method, of class Day.
     */
    
    @Test
    public void testCanAddAppointmentOfDuration() {
        TimeSpan testDuration = new TimeSpan(4, 01);
        assertFalse(testDay.canAddAppointmentOfDuration(testDuration));
        assertTrue(testDay.canAddAppointmentOfDuration(new TimeSpan(4, 0)));
        testDay.removeAppointment("lunch break");
        assertTrue(testDay.getNrOfAppointments() == 0);
        assertTrue(testDay.canAddAppointmentOfDuration(testDuration));
        assertFalse(testDay.canAddAppointmentOfDuration(new TimeSpan(9,01)));
    }

    /**
     * Test of addAppointmentWithStartTimeSet method, of class Day.
     */
    
    @Test
    public void testAddAppointmentWithStartTimeSet() {
       Day testDay1 = new Day(3);
       Appointment appWST1 = new Appointment("testAddAppointmentWithStartTimeSet 1", new TimeSpan(1,0));
        appWST1.setStart(new Time(13,31));
        testDay1.addAppointmentWithStartTimeSet(appWST1);
        
        Appointment appWST2 = new Appointment("testAddAppointmentWithStartTimeSet 2", new TimeSpan(2,0));
        appWST2.setStart(new Time(14,32));
        testDay1.addAppointmentWithStartTimeSet(appWST2);
        
        Appointment appWST3 = new Appointment("testAddAppointmentWithStartTimeSet 3", new TimeSpan(0,59));
        appWST3.setStart(new Time(10,30));
        testDay1.addAppointmentWithStartTimeSet(appWST3);
        
        Appointment appWST4 = new Appointment("testAddAppointmentWithStartTimeSet 4", new TimeSpan(2,0));
        appWST4.setStart(new Time(8,31));
        testDay1.addAppointmentWithStartTimeSet(appWST4);
              
        Appointment appWST5 = new Appointment("testAddAppointmentWithStartTimeSet 5", new TimeSpan(0,59));
        appWST5.setStart(new Time(8,30));
        testDay1.addAppointmentWithStartTimeSet(appWST5);
        
        assertEquals(5, testDay1.getNrOfAppointments());
        
        assertTrue(testDay1.containsAppointmentWithDescription("testAddAppointmentWithStartTimeSet 4"));
        testDay1.removeAppointment("testAddAppointmentWithStartTimeSet 4");
        assertFalse(testDay1.containsAppointmentWithDescription("testAddAppointmentWithStartTimeSet 4"));
        assertEquals(4, testDay1.getNrOfAppointments());
        
        
      
    }

    /**
     * Test of addAppointment method, of class Day.
     */

    @Test
    public void testAddAppointment() {
        Day testDay2 = new Day(4);
        Appointment appWST1 = new Appointment("testAddAppointment 1", new TimeSpan(1,0));
        testDay2.addAppointment(appWST1);
        
        Appointment appWST2 = new Appointment("testAddAppointment 2", new TimeSpan(2,0));
        testDay2.addAppointment(appWST2);
        
        Appointment appWST3 = new Appointment("testAddAppointment 3", new TimeSpan(0,59));
        testDay2.addAppointment(appWST3);
        
        Appointment appWST4 = new Appointment("testAddAppointment 4", new TimeSpan(2,0));
        testDay2.addAppointment(appWST4);
              
        Appointment appWST5 = new Appointment("testAddAppointment 5", new TimeSpan(1,59));
        testDay2.addAppointment(appWST5);
        
        //testDay2.getAppointments().show();
        assertEquals(6, testDay2.getNrOfAppointments());
        
    }

    /**
     * Test of removeAppointment method, of class Day.
     */
    
    @Test
    public void testRemoveAppointment() {
        Appointment appointmentToDelte = new Appointment("deleteMe", new TimeSpan(1, 0));
        appointmentToDelte.setStart(new Time(8, 30));
        testDay.addAppointmentWithStartTimeSet(appointmentToDelte);
        
        assertTrue(testDay.containsAppointmentWithDescription("deleteMe"));
        testDay.removeAppointment("deleteMe");
        assertFalse(testDay.containsAppointmentWithDescription("deleteMe"));
        
        
    }

    /**
     * Test of containsAppointmentWithDescription method, of class Day.
     */
    
    @Test
    public void testContainsAppointmentWithDescription() {        
        Appointment appointmentToDelte = new Appointment("HelloWorld", new TimeSpan(1, 0));
        appointmentToDelte.setStart(new Time(8, 30));
        testDay.addAppointmentWithStartTimeSet(appointmentToDelte);
        
        assertTrue(testDay.containsAppointmentWithDescription("HelloWorld"));
        
    }

    /**
     * Test of getAvailableStartTimesForAppointmentsOfDuration method, of class
     * Day.
     */
    
    @Test
    public void testGetAvailableStartTimesForAppointmentsOfDuration() {
        Day myDay = new Day(1);        
        Time[] timeSpanArray = myDay.getAvailableStartTimesForAppointmentsOfDuration(new TimeSpan(1, 0));
        
        assertEquals(timeSpanArray[0], new Time(8, 30));
        assertEquals(timeSpanArray[1], new Time(13, 30));
        
    }

    /**
     * Test of getAvailableTimeGaps method, of class Day.
     */
    
    @Test
    public void testGetAvailableTimeGaps() {
        TimeSpan ts = new TimeSpan(1, 0);
        Day myDay = new Day(1);
        
        TimeGap[] timeSpanArray = myDay.getAvailableTimeGaps();
        
        assertEquals(new Time(8, 30), timeSpanArray[0].getStart());
        assertEquals(new Time(12, 30), timeSpanArray[0].getEnd());
        assertEquals(new Time(13, 30), timeSpanArray[1].getStart());
        assertEquals(new Time(17, 30), timeSpanArray[1].getEnd());
    }

    /**
     * Test of testCheckOverlap method, of class Day.
     */
    
    @Test
    public void testCheckOverlap() {
        TimeSpan timeSpan1 = new TimeSpan(1, 0);

        //TEST APPBEFOREDAY
        Time beforeDayStart1 = new Time(7, 0);
        Appointment testAppointmentBeforeDay = new Appointment("BeforeDayTestAppointment", ts1);
        testAppointmentBeforeDay.setStart(beforeDayStart1);
        testDay.addAppointment(testAppointmentBeforeDay);
        assertTrue(testDay.checkOverlap(testAppointmentBeforeDay));

        //TEST APPAFTERDAY
        Time afterDayStart1 = new Time(18, 0);
        Appointment testAppointmentAfterDay = new Appointment("AfterDayTestAppointment", ts1);
        testAppointmentAfterDay.setStart(afterDayStart1);
        testDay.addAppointment(testAppointmentAfterDay);
        assertTrue(testDay.checkOverlap(testAppointmentAfterDay));

        //TEST1 NO-COLIDE WITH LUNCH
        Time timeStart3 = new Time(15, 00);
        Appointment testAppointment3 = new Appointment("TestAppointment Nr3", timeSpan1);
        testAppointment3.setStart(timeStart3);
        testDay.addAppointmentWithStartTimeSet(testAppointment3);
        assertTrue(testDay.containsAppointmentWithDescription("TestAppointment Nr3"));

        //TEST 2 SAME TIME
        Time timeStart1 = new Time(12, 30);
        Appointment testAppointment1 = new Appointment("TestAppointment Nr1", timeSpan1);
        testAppointment1.setStart(timeStart1);
        testDay.addAppointmentWithStartTimeSet(testAppointment1);
        assertFalse(testDay.containsAppointmentWithDescription("TestAppointment Nr1"));

        //TEST3 COLIDE WITH LUNCH
        Time timeStart2 = new Time(12, 10);
        Appointment testAppointment2 = new Appointment("TestAppointment Nr2", timeSpan1);
        testAppointment2.setStart(timeStart2);
        assertTrue(testDay.checkOverlap(testAppointment2));
        testDay.addAppointmentWithStartTimeSet(testAppointment2);
        assertFalse(testDay.containsAppointmentWithDescription("TestAppointment Nr2"));

        //TEST4 COLIDE WITH TEST1
        Time timeStart4 = new Time(14, 30);
        Appointment testAppointment4 = new Appointment("TestAppointment Nr5", timeSpan1);
        testAppointment4.setStart(timeStart4);
        testDay.addAppointmentWithStartTimeSet(testAppointment4);
        assertTrue(testDay.checkOverlap(testAppointment4));
        assertFalse(testDay.containsAppointmentWithDescription("TestAppointment Nr5"));
        
    }
    
    /**
     * Test of getAvailableTimeGaps method, of class Day.
     */
    
    @Test
    public void testGetAppointments() {
        Day myQueDay = new Day(1);
        
        
        Appointment appT5 = new Appointment("Appointment 5", new TimeSpan(0,59));
        appT5.setStart(new Time(13,31));
        myQueDay.addAppointmentWithStartTimeSet(appT5);
        
        Appointment appT4 = new Appointment("Appointment 4", new TimeSpan(0,59));
        appT4.setStart(new Time(11,30));
        myQueDay.addAppointmentWithStartTimeSet(appT4);
        
        Appointment appT3 = new Appointment("Appointment 3", new TimeSpan(0,59));
        appT3.setStart(new Time(10,30));
        myQueDay.addAppointmentWithStartTimeSet(appT3);
        
        Appointment appT2 = new Appointment("Appointment 2", new TimeSpan(0,59));
        appT2.setStart(new Time(9,30));
        myQueDay.addAppointmentWithStartTimeSet(appT2);
              
        Appointment appT1 = new Appointment("Appointment 1", new TimeSpan(0,59));
        appT1.setStart(new Time(8,30));
        myQueDay.addAppointmentWithStartTimeSet(appT1);
        

        Queue myTestQueue = new Queue();
        myTestQueue = myQueDay.getAppointments();
        
        myTestQueue.show();
        assertEquals(5, myTestQueue.getSize());
        
        
        
        
        
    }
    

 
}
