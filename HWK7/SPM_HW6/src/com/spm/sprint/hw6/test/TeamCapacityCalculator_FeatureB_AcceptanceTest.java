package com.spm.sprint.hw6.test;

import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spm.sprint.hw6.TeamCapacityCalculator_FeatureB;
import com.spm.sprint.hw6.TeamMember_FeatureB;

public class TeamCapacityCalculator_FeatureB_AcceptanceTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCalculateTeamCapacity_HappyPath() {
        // Given
        TeamMember_FeatureB memberA = new TeamMember_FeatureB("Tester1", 1, 2, 6);
        TeamMember_FeatureB memberB = new TeamMember_FeatureB("Tester2", 0, 2, 7);
        int sprintDays = 10;

        // When
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, List.of(memberA, memberB));

        // Then
        String expectedOutputA = "Tester1 Available Hours: 42";
        String expectedOutputB = "Tester2 Available Hours: 56";
        String expectedOutputTotal = "Total Team Available Hours: 98";
        assertTrue(outContent.toString().contains(expectedOutputA));
        assertTrue(outContent.toString().contains(expectedOutputB));
        assertTrue(outContent.toString().contains(expectedOutputTotal));
    }
    
    @Test
    public void testCalculateTeamCapacity_HappyPath2() {
        // Given
        TeamMember_FeatureB memberA = new TeamMember_FeatureB("Tester1", 2, 4, 6);
        TeamMember_FeatureB memberB = new TeamMember_FeatureB("Tester2", 3, 4, 5);
        int sprintDays = 10;

        // When
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, List.of(memberA, memberB));

        // Then
        String expectedOutputA = "Tester1 Available Hours: 24";
        String expectedOutputB = "Tester2 Available Hours: 15";
        String expectedOutputTotal = "Total Team Available Hours: 39";
        assertTrue(outContent.toString().contains(expectedOutputA));
        assertTrue(outContent.toString().contains(expectedOutputB));
        assertTrue(outContent.toString().contains(expectedOutputTotal));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
