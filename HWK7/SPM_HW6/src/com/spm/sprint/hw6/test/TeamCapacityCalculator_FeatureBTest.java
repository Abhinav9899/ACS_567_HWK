package com.spm.sprint.hw6.test;

import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;
import org.junit.*;

import com.spm.sprint.hw6.TeamCapacityCalculator_FeatureB;
import com.spm.sprint.hw6.TeamMember_FeatureB;

public class TeamCapacityCalculator_FeatureBTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCalculateTeamCapacity_NormalInput() {
     
        TeamMember_FeatureB member1 = new TeamMember_FeatureB("Tester1", 1, 2, 6);
        TeamMember_FeatureB member2 = new TeamMember_FeatureB("Tester2", 0, 2, 7);
        int sprintDays = 10;

        
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, Arrays.asList(member1, member2));

        
        String expectedOutput1 = "Tester1 Available Hours: 42";
        String expectedOutput2 = "Tester2 Available Hours: 56";
        String expectedOutputTotal = "Total Team Available Hours: 98";
        System.out.println(outContent.toString());
        assertTrue(outContent.toString().contains(expectedOutput1));
        assertTrue(outContent.toString().contains(expectedOutput2));
        assertTrue(outContent.toString().contains(expectedOutputTotal));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTeamCapacity_NegativeSprintDays() {
        
        TeamMember_FeatureB member = new TeamMember_FeatureB("Tester", 0, 2, 6);
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(-1, Collections.singletonList(member));
    }

    @Test
    public void testCalculateTeamCapacity_AllDaysOff() {
        
        TeamMember_FeatureB member = new TeamMember_FeatureB("Tester", 10, 0, 6);
        int sprintDays = 10;

        
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, Collections.singletonList(member));

        
        String expectedOutput = "Tester Available Hours: 0";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testCalculateTeamCapacity_ZeroHoursPerDay() {
        
        TeamMember_FeatureB member = new TeamMember_FeatureB("Tester", 0, 2, 0);
        int sprintDays = 10;

        
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, Collections.singletonList(member));

        
        String expectedOutput = "Tester Available Hours: 0";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testCalculateTeamCapacity_EmptyTeamList() {
        
        int sprintDays = 10;

        
        TeamCapacityCalculator_FeatureB.calculateTeamCapacity(sprintDays, Collections.emptyList());

        
        String expectedOutput = "Total Team Available Hours: 0";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
