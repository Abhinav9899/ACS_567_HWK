package com.spm.sprint.hw6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spm.sprint.hw6.SprintMetrics_FeatureA;

public class SprintMetrics_FeatureATest {

	@Test
    public void testCalculateAverageVelocity_NormalInput() {
        int[] completedPoints = {10, 12, 8, 14};
        double expected = 11.0;
        double actual = SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
        System.out.println("Normal Input Expected: " + expected + " actual: " +actual);
        assertEquals("The average velocity should be calculated correctly for normal input", expected, actual, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateAverageVelocity_NullInput() {
        SprintMetrics_FeatureA.calculateAverageVelocity(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateAverageVelocity_EmptyArray() {
        int[] completedPoints = {};
        SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
    }

    @Test
    public void testCalculateAverageVelocity_SingleElement() {
        int[] completedPoints = {10};
        double expected = 10.0;
        double actual = SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
        System.out.println("Single Element Expected: " + expected + " actual: " +actual);
        assertEquals("The average velocity should be the same as the single input value", expected, actual, 0.01);
    }

    @Test
    public void testCalculateAverageVelocity_AllZeros() {
        int[] completedPoints = {0, 0, 0, 0};
        double expected = 0.0;
        double actual = SprintMetrics_FeatureA.calculateAverageVelocity(completedPoints);
        System.out.println("All Zeros Expected: " + expected + " actual: " +actual);
        assertEquals("The average velocity should be zero if all elements are zero", expected, actual, 0.01);
    }

}
