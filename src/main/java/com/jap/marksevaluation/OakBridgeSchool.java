package com.jap.marksevaluation;

import java.util.Arrays;

public class OakBridgeSchool {
    public static void main(String[] args) {

        // Initialize the OakBridgeSchool class object
        OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();
        // Call the appropriate methods and display the output
        int[] math = {88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        int[] science = {80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        int[] english = {90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        int len = math.length;
        int[] totalMark = oakBridgeSchool.calculateTotalMarks(math, science, english);
        System.out.println(Arrays.toString(totalMark));
        int topScore = oakBridgeSchool.findTopScore(totalMark, len);
        System.out.println("Top Score = " + topScore);
        System.out.println("Average Math Marks    = " + oakBridgeSchool.calculateAverageMathMarks(math, len));
        System.out.println("Average Science Marks = " + oakBridgeSchool.calculateAverageScienceMarks(science, len));
        System.out.println("Average English Marks = " + oakBridgeSchool.calculateAverageEnglishMarks(english, len));
    }

    public int[] calculateTotalMarks(int[] math, int[] science, int[] english) {
        if (math.length == 0 || science.length == 0 || english.length == 0) {
            return null;
        }

        int[] totalMarks = new int[math.length];
        for (int i = 0; i < math.length; i++) {
            totalMarks[i] = math[i] + science[i] + english[i];
        }
        return totalMarks;
    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageEnglishMarks(int[] english, int length) {
        if (length == 1)
            return english[length - 1];

        double avgTillLast = calculateAverageMathMarks(english, length - 1);
        double total = (avgTillLast * (length - 1)) + english[length - 1];
        return total / length;

    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageMathMarks(int[] math, int length) {
        if (length == 1)
            return math[length - 1];

        double avgTillLast = calculateAverageMathMarks(math, length - 1);
        double total = (avgTillLast * (length - 1)) + math[length - 1];
        return total / length;

    }

    // Write the logic to calculate the average marks using recursion
    public double calculateAverageScienceMarks(int[] science, int length) {

        if (length == 1)
            return science[length - 1];

        double avgTillLast = calculateAverageScienceMarks(science, length - 1);
        double total = (avgTillLast * (length - 1)) + science[length - 1];
        return total / length;
    }

    //Write the logic to find the top score in the class using recursion
    public int findTopScore(int[] totalMark, int length) {
        if (length == 1)
            return totalMark[length - 1];
        if  (findTopScore(totalMark, length - 1) > totalMark[length - 1])
            return findTopScore(totalMark, length - 1);
        else {
            return totalMark[length - 1];
        }

    }
}
