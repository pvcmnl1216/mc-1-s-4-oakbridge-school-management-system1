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
    int [] social;
    int noOfSubjects;
    String[] studentNames;
    int [] rollNos;
    OakBridgeSchool oakBridgeSchool;
    @Before
    public void setUp(){
        oakBridgeSchool = new OakBridgeSchool();
        math  = new int[]{88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        science = new int[]{80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        social = new int[]{90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        noOfSubjects = 3;
        studentNames = new String[]{"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        rollNos = new int[]{102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
    }
    @After
    public void tearDown(){
        math  = null;
        science = null;
        social = null;
        noOfSubjects = 0;
        studentNames = null;
        rollNos = null;
        oakBridgeSchool = null;
    }
    @Test
    public  void givenMathMarksArrayOfClassReturnAverageSuccess(){
        double expectedMathAverage = 60.6;
        assertEquals(expectedMathAverage,oakBridgeSchool.calculateAverageMathMarks(math,10),0);
    }

    @Test
    public  void givenScienceMarksArrayOfClassReturnAverageSuccess(){
        double expectedScienceAverage = 61.3;
        assertEquals(expectedScienceAverage,oakBridgeSchool.calculateAverageMathMarks(science,10),0);
    }

    @Test
    public  void givenSocialMarksArrayOfClassReturnAverageSuccess(){
        double expectedSocialAverage = 65.4;
        assertEquals(expectedSocialAverage,oakBridgeSchool.calculateAverageMathMarks(social,10),0);
    }

    @Test
    public void givenSubjectMarksInArraysCheckIfPassedSuccess(){
        int[] expectedIsPassed = {1,1,1,1,1,1,1,0,0,1};
        assertArrayEquals(expectedIsPassed,oakBridgeSchool.isPassed(math,science,social));
    }
    @Test
    public void givenSubjectMarksInArraysCheckIfPassedFailure(){
        assertNull(oakBridgeSchool.isPassed(new int[0],science,social));
        assertNull(oakBridgeSchool.isPassed(math,new int[0],social));
        assertNull(oakBridgeSchool.isPassed(math,science,new int[0]));
        assertNull(oakBridgeSchool.isPassed(new int[0],new int[0],new int[0]));
    }

    @Test
    public void givenTotalMarksInArraysSortInAscendingOrder(){
        int[] totalMarks = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedSortedTotalMarksOfClass = {25,102,113,170,188,202,246,258,270,299};
        assertArrayEquals(expectedSortedTotalMarksOfClass,oakBridgeSchool.sortByTotalMarks(totalMarks));

    }
    @Test
    public void givenGradesSortNamesInAscendingOrder(){
        char[] grades = {'B','A','A','D','E','B','F','F','F','D'};
        String[] expectedSortedTotalMarksOfClassNames = {"Kate","Ann","Michelle","Sam","Tina","Leo","Tom","Ria","Pam","Leena"};
        assertArrayEquals(expectedSortedTotalMarksOfClassNames,oakBridgeSchool.sortByGrades(grades,expectedSortedTotalMarksOfClassNames));
    }
}
