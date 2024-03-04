package com.spm.sprint.hw6;

public class TeamMember_FeatureB {

	String memberName;
	int daysOff;
    int daysForCeremonies;
    int hoursPerDay;

    public TeamMember_FeatureB(String memberName, int daysOff, int daysForCeremonies, int hoursPerDay) {
    	this.memberName = memberName;
        this.daysOff = daysOff;
        this.daysForCeremonies = daysForCeremonies;
        this.hoursPerDay = hoursPerDay;
    }

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}

	public int getDaysForCeremonies() {
		return daysForCeremonies;
	}

	public void setDaysForCeremonies(int daysForCeremonies) {
		this.daysForCeremonies = daysForCeremonies;
	}

	public int getHoursPerDay() {
		return hoursPerDay;
	}

	public void setHoursPerDay(int hoursPerDay) {
		this.hoursPerDay = hoursPerDay;
	}

	@Override
	public String toString() {
		return "TeamMember_FeatureB [memberName=" + memberName + ", daysOff=" + daysOff + ", daysForCeremonies="
				+ daysForCeremonies + ", hoursPerDay=" + hoursPerDay + "]";
	}

}
