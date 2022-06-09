package com.jap.marksevaluation;

import com.jap.marksevaluation.OakBridgeSchool;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OakBridgeSchoolTest
{
    int [] math;
    int [] science;
    int [] english;
    int noOfSubjects;
    String[] studentNames;
    int [] rollNos;
    OakBridgeSchool oakBridgeSchool;
    @Before
    public void setUp(){
        oakBridgeSchool = new OakBridgeSchool();
        math  = new int[]{88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        science = new int[]{80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        english = new int[]{90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        noOfSubjects = 3;
        studentNames = new String[]{"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        rollNos = new int[]{102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
    }
    @After
    public void tearDown(){
        math  = null;
        science = null;
        english = null;
        noOfSubjects = 0;
        studentNames = null;
        rollNos = null;
        oakBridgeSchool = null;
    }

    @Test
    public  void givenMarksCalculateTotalAndReturnAnArraySuccess(){
        int[] expectedTotal = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertArrayEquals(expectedTotal,oakBridgeSchool.calculateTotalMarks(math,science,english));

    }
    @Test
    public  void givenMarksCalculateTotalAndReturnAnArrayFailure(){
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],science,english));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,science,new int[0]));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,new int[0],english));
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],new int[0],new int[0]));
    }
    @Test
    public  void givenMathMarksArrayOfClassReturnAverageSuccess(){
        double expectedMathAverage = 60.6;
        assertEquals(expectedMathAverage,oakBridgeSchool.calculateAverageMathMarks(math,10),0);
    }

    @Test
    public  void givenScienceMarksArrayOfClassReturnAverageSuccess(){
        double expectedScienceAverage = 61.3;
        assertEquals(expectedScienceAverage,oakBridgeSchool.calculateAverageScienceMarks(science,10),0);
    }

    @Test
    public  void givenEnglishMarksArrayOfClassReturnAverageSuccess(){
        double expectedEnglishAverage = 65.4;
        assertEquals(expectedEnglishAverage,oakBridgeSchool.calculateAverageEnglishMarks(english,10),0);
    }




}
