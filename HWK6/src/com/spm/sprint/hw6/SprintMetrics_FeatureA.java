package com.spm.sprint.hw6;

public class SprintMetrics_FeatureA {

	// Feature A: Calculate team's average velocity
    public static double calculateAverageVelocity(int[] completedPoints) {
        if (completedPoints == null || completedPoints.length == 0) {
            System.out.println("Input array is null or empty");
        }
        int sum = 0;
        for (int points : completedPoints) {
            sum += points;
        }
        return (double) sum / completedPoints.length;
    }

    public static void main(String[] args) {
        int[] previousSprintsPoints = {10, 12, 8, 14}; // Example input
        double averageVelocity = calculateAverageVelocity(previousSprintsPoints);
        System.out.println("Average Team Velocity Per Sprint: " + averageVelocity);
    }

}
