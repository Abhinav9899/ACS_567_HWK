package com.spm.hw1.player;

/**
 * This Player Class is created with the objective of encapsulating the player data which consists 
 * of the fields id, firstName, lastName, runsScored, and year.
 */
public class Player {

	//Record Identification constant i.e., id
	private long id;
    private String firstName;
    private String lastName;
    private String runsScored;
    private String year;
    
	/**
	 * Non-parameterized constructor of the Player class.
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor of the Player class.
	 */
	public Player(long id, String firstName, String lastName, String runsScored, String year) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.runsScored = runsScored;
		this.year = year;
	}

	//Getters and Setters of the Player class
	
	/**
	 * Get the id of the Player.
	 * @return Long id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the id of the Player.
	 * @param Long id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the First Name of the Player.
	 * @return String First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the First Name of the Player.
	 * @param String First Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the Last Name of the Player.
	 * @return String Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the First Name of the Player.
	 * @param String Last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the runs scored by the Player.
	 * @return String Runs Scored
	 */
	public String getRunsScored() {
		return runsScored;
	}

	/**
	 * Set the runs scored by the Player.
	 * @param String Runs Scored
	 */
	public void setRunsScored(String runsScored) {
		this.runsScored = runsScored;
	}

	/**
	 * Get the Year of the Player's record.
	 * @return String Year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Set the Year of the Player's record.
	 * @param String Year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * This method is used to represent a record details in a string format.
	 * @return String i.e., representation of the record in a string format.
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", runsScored=" + runsScored
				+ ", year=" + year + "]";
	}
	
	/**
	 * This method returns the record details in a csv format.
	 * @return String i.e., the details of a single record in csv format.
	 */
	public String toCsvString() {
        return id + "," + firstName + "," + lastName + "," + runsScored + "," + year;
    }

}
