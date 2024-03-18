package com.spm.sprint.hw6;

import java.util.List;

/**
* This java class TeamCapacityCalculator_FeatureB is designed to provide the name, daysOff,
* daysForCeremonies and hoursPerDay of the particular employees and number of sprint days utilized by the team member as an individual to 
* calculate team effort-hour capacity of each of the individual and the team effort-hour in total as well.
*/ 
public class TeamCapacityCalculator_FeatureB {

	/**
	* This method takes in the input as the name, daysOff, daysForCeremonies and hoursPerDay of the particular employee
	* as part of the class TeamMember_FeatureB and the number of sprint days utilized by the team member as an individual parameter to 
	* calculate team effort-hour capacity of each of the individual and the team effort-hour in total as well. 
	* @param int i.e., the number of sprint days utilized by the team member.
	* @param TeamMember_FeatureB i.e., the name, daysOff, daysForCeremonies and hoursPerDay of the particular employees.
	*/ 
    public static void calculateTeamCapacity(int sprintDays, List<TeamMember_FeatureB> teamMembers) {
        int totalHours = 0;
        
        // Check if sprintDays is less than 0 and throw IllegalArgumentException if true
        if (sprintDays < 0) {
            throw new IllegalArgumentException("Number of sprint days cannot be less than 0");
        }
        
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
        calculateTeamCapacity(10, teamMembers); // the first input would be the number of sprint days utilized by the employye and the second parameter is the list of TeamMember_FeatureB objects created above.

	}

}
