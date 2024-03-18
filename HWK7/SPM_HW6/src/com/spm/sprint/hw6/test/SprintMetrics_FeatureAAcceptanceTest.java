package com.spm.sprint.hw6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spm.sprint.hw6.SprintMetrics_FeatureA;

public class SprintMetrics_FeatureAAcceptanceTest {

	@Test
    public void happyPathTestCalculateAverageVelocity() {
        // Given (happy path)
        int[] completedPoints = {10, 20, 30, 40};
        
        // When
        double averageVelocity = SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
        
        // Then
        assertEquals("The average velocity should be correctly calculated for the happy path", 25.0, averageVelocity, 0.001);
    }
	
	@Test
    public void happyPathTestCalculateAverageVelocity2() {
        // Given (happy path)
        int[] completedPoints = {10, 12, 8, 14};
        
        // When
        double averageVelocity = SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
        
        // Then
        assertEquals("The average velocity should be correctly calculated for the happy path", 11.0, averageVelocity, 0.001);
    }

}
