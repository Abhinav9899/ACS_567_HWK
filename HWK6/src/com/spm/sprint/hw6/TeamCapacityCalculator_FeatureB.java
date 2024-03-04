package com.spm.sprint.hw6;

import java.util.List;

public class TeamCapacityCalculator_FeatureB {

    public static void calculateTeamCapacity(int sprintDays, List<TeamMember_FeatureB> teamMembers) {
        int totalHours = 0;
        try {
			for (TeamMember_FeatureB member : teamMembers) {
				int workingDays = sprintDays - (member.daysOff + member.daysForCeremonies);
				int memberHours = workingDays * member.hoursPerDay;
				System.out.println(member.memberName + " Available Hours: " + memberHours);
				totalHours += memberHours;
			}
			System.out.println("Total Team Available Hours: " + totalHours);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Error during calculation, please check the input values");
		}
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
