package com.spm.sprint.hw6;

/**
* This java class SprintMetrics_FeatureA is created take the input of previous completion points and calculate
* the avergage team velocity achieved till date in the occured sprints.
*/ 
public class SprintMetrics_FeatureA {

	/**
	* This method taked the input of the previous sprint points acheived and calulates the latest sprint
	* velocity of the team per date.
	* @param int[] i.e., the list of the current and the previous sprint points.
	* @return double i.e., the average velocity of the team achived till date.
	*/ 
    public static double calculateAverageVelocity(int[] completedPoints) {
        if (completedPoints == null || completedPoints.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }
        try {
			int sum = 0;
			for (int points : completedPoints) {
				sum += points;
			}
			return (double) sum / completedPoints.length;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error during calculation, please check th einput values");
		}
    }

    public static void main(String[] args) {
        int[] previousSprintsPoints = {10, 12, 8, 14}; // inputs provided as per the requirements.
        double averageVelocity = calculateAverageVelocity(previousSprintsPoints);
        System.out.println("Average Team Velocity Per Sprint: " + averageVelocity); //Displaying the output.
    }

}
