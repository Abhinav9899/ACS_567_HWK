package com.spm.hw1.player;

import java.util.*;

/**
 * This CricketApplication class CricketApplication class serves as a driver class
 * and as an entry point of the application and handles user interactions and print/display operations
 * based on the input choosen. In detail, on running the application the user will be 
 * receiving a list of choices including Enter 0 to read player data,
 *  Enter 1 to add player data, Enter 2 to edit player data, 
 *  Enter 3 to delete player data, Enter 4 to delete all player data, 
 *  Enter 5 to calculate mean and median values of all the runs scored by the players, 
 *  Enter 6 to filter player data by year, Enter 9 to exit the application. And based on the user’s input the selected operation would be performed and the respective result would be displayed.
 */
public class CricketApplication {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Getting the instance of the Singleton class to perform all the operations of the application.
        DataManager dataManager = DataManager.getInstance();

        while (true) {
        	System.out.println("Please enter the following options based on your requirements: \n Enter 0 to read player data,\n Enter 1 to add player data,\n Enter 2 to update player data,\n Enter 3 to delete player data,\n Enter 4 to delete all players data,\n Enter 5 to calculate mean and median values of all the runs scored by the players,\n Enter 6 to filter player data by year,\n Enter 9 to exit the application:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    // Read and display data from the data.txt file
                    dataManager.readData().forEach(player -> System.out.println(player.toCsvString()));
                    System.out.println("\n");
                    break;
                case 1:
                	// Add new data into the data.txt file
                    long id = 0;
                    String runsScored = "";
                    String year = "";
                    boolean validInput = false;

                    // Validate the input id provided
                    while (!validInput) {
                        try {
                        	System.out.println("\n");
                            System.out.println("Enter id (integer):");
                            id = scanner.nextLong();
                            scanner.nextLine(); // Consume the newline
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for id. Please enter an integer.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }

                    //Validate the input received from the user for the First Name field.
                    System.out.println("Enter firstName:");
                    String firstName = scanner.nextLine();
                    
                  //Validate the input received from the user for the Last Name field.
                    System.out.println("Enter lastName:");
                    String lastName = scanner.nextLine();

                    // Validate the input of the runs scored by the player
                    validInput = false;
                    while (!validInput) {
                        try {
                        	System.out.println("\n");
                            System.out.println("Enter runsScored (integer):");
                            runsScored = scanner.next();
                            Integer.parseInt(runsScored); // Check if it's a valid integer
                            scanner.nextLine(); // Consume the newline
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input for runsScored. Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }

                    // Validate the year on the record provided by the user.
                    validInput = false;
                    while (!validInput) {
                        try {
                        	System.out.println("\n");
                            System.out.println("Enter year (integer):");
                            year = scanner.next();
                            Integer.parseInt(year); // Check if it's a valid integer
                            scanner.nextLine(); // Consume the newline
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input for year. Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }

                    //Add the record data inputs received to the data.txt file
                    dataManager.addData(new Player(id, firstName, lastName, runsScored, year));
                    System.out.println("\n");
                    System.out.println("Player record added successfully.");
                    break;
                    
                case 2:
                	// Update the player data present in the data.txt file
                    System.out.println("Enter ID of record to update:");
                    long editId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline

                    // Check if record exists in the data.txt file
                    List<Player> players = dataManager.readData();
                    boolean recordExists = players.stream().anyMatch(p -> p.getId() == editId);

                    //In case the record does not exist in the data.txt file
                    if (!recordExists) {
                        System.out.println("Record with ID " + editId + " not found. Please reverify the ID.");
                        System.out.println("\n");
                        break;
                    }

                    // If the record exists in the data.txt file, proceed with updating the record.
                    System.out.println("Enter new firstName:");
                    String newFirstName = scanner.nextLine();
                    System.out.println("Enter new lastName:");
                    String newLastName = scanner.nextLine();
                    System.out.println("Enter new runsScored (integer):");
                    String newRunsScored = scanner.nextLine();
                    System.out.println("Enter new year (integer):");
                    String newYear = scanner.nextLine();

                    dataManager.editData(editId, new Player(editId, newFirstName, newLastName, newRunsScored, newYear));
                    System.out.println("Player record updated successfully");
                    System.out.println("\n");
                    break;
                    
                case 3:
                	
                	// Delete player record from the data.txt file
                    System.out.println("Enter ID of record to delete:");
                    long deleteId = scanner.nextLong();
                    boolean isDeleted = dataManager.deleteData(deleteId);
                    if (isDeleted) {
                        System.out.println("Record with ID " + deleteId + " has been deleted.");
                    } else {
                        System.out.println("Record not found. Please reverify the ID.");
                    }
                    break;
                    
                case 4:
                    // Delete all the data present in the data.txt file
                    dataManager.deleteAllData();
                    System.out.println("All data has been deleted.");
                    System.out.println("\n");
                    break;
                    
                case 5:
                    // Calculate mean and median values of all the runs scored by the players 
                    double[] stats = dataManager.calculateMeanAndMedian();
                    System.out.println("Mean runs scored by all the players is: " + stats[0] + ", Median runs scored by all the players is: " + stats[1]);
                    System.out.println("\n");
                    break;
                    
                case 6:
                	// Filter player data by year present on their record
                    System.out.println("Enter year to filter by:");
                    String filterYear = scanner.next();
                    List<Player> filteredData = dataManager.filterDataByYear(filterYear);
                    if (filteredData.isEmpty()) {
                        System.out.println("No records found for the year " + filterYear + ".");
                        System.out.println("\n");

                    } else {
                        filteredData.forEach(player -> System.out.println(player.toCsvString()));
                        System.out.println("\n");
                    }
                    break;
                    
                case 9:
                    // Exit the application
                    System.out.println("Exiting application.");
                    System.out.println("\n");
                    return;
                    
                default:
                	//In the scenario where an invalid option has been given by the user.
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("\n");
                    break;
            }
        }
    }

}
