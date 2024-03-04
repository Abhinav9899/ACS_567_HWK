package com.spm.sprint.hw6;

import java.util.List;

public class TeamCapacityCalculator_FeatureB {

	
    public static void calculateTeamCapacity(int sprintDays, List<TeamMember_FeatureB> teamMembers) {
        
        System.out.println("Total Team Available Hours: ");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TeamMember_FeatureB> teamMembers = List.of(
                new TeamMember_FeatureB("Tester1", 1, 2, 6),
                new TeamMember_FeatureB("Tester2", 0, 2, 7) // input per team member
        );
        calculateTeamCapacity(10, teamMembers);

	}

}
