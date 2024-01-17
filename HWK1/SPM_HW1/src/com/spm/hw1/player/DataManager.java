package com.spm.hw1.player;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * This DataManager class which is a singleton class that manages the data manipulation (CRUD), data analytics,
 * and filtering operations by maintaining and returning a single instance of the class to avoid multiple simultaneous 
 * conflicting data operations and stores/manipulates the data from a data.txt file in the same root 
 * repository path of the application in a CSV format.
 */
public class DataManager {

	//Instance of the class used to perform all the required operations of the player data.
	private static DataManager instance;
	
	//Filename of the txt file used to save all the data.
    private String filePath = "data.txt"; // File path relative to the project directory

    /**
     * Non-Parameterized constructor for the Datamanager class
     */
    private DataManager() {
    	
    }

	/**
	 * getInstance method used to return only a singular instance of the privatized class to implement the singleton
	 * functionality of the class.
	 *
	 * @return DataManager The DataManager Object instance formed in a synchronized format following a 
	 * singleton pattern used for the creation of the instance. This would ensure that only one 
	 * instance is created, and subsequent calls would reuse the existing instance.
	 * 
	 */
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

	//Read Operation for player
	/**
	 * To read all the existing player data that has been saved in the data.txt file
	 * @return List<Player> All the player Objects present in the data.txt file in a List format.
	 */
    public List<Player> readData() {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                players.add(new Player(Long.parseLong(values[0]), values[1], values[2], values[3], values[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

	//Create Operation for player
	/**
	 * To insert new player data into the data.txt file by converting the record into a CSV format.
	 * @param player object.
	 */
    public void addData(Player data) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data.toCsvString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	//Update Operation for player
	/**
	 * To update the player data in the data.txt file by converting the record into a CSV format.
	 * @param Integer, i.e., the id of the player record.
	 * @param Player, i.e., the target player object record is intended to update.
	 * @return Boolean, i.e., returns true and edit the record if the record with the specified id exists, or else returns false.
	 */
    public boolean editData(long id, Player newData) {
        List<Player> players = readData();
        boolean recordFound = false;

        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (Player player : players) {
                if (player.getId() == id) {
                    out.println(newData.toCsvString());
                    recordFound = true;
                } else {
                    out.println(player.toCsvString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordFound;
    }
    
	//Delete Operation for player
	/**
	 * To delete the player data from the data.txt file.
	 * @param Integer, i.e., the id of the player record.
	 * @return Boolean, if the record is found return delete it and return true, else false.
	 */
    public boolean deleteData(long id) {
        List<Player> players = readData();
        boolean recordFound = false;

        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (Player player : players) {
                if (player.getId() == id) {
                    recordFound = true;
                } else {
                    out.println(player.toCsvString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordFound;
    }

	//DeleteAll Operation for player
	/**
	 * To delete all the player data from the data.txt file.
	 */
    public void deleteAllData() {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            // Writing nothing to the file effectively clears it
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	//Analysis Operation for player
	/**
	 * To analyze the mean and median runs scored by all the players in the data.txt file.
	 */
    public double[] calculateMeanAndMedian() {
        List<Player> players = readData();
        int[] runs = players.stream().mapToInt(p -> Integer.parseInt(p.getRunsScored())).toArray();
        Arrays.sort(runs);

        double mean = Arrays.stream(runs).average().orElse(Double.NaN);
        double median;
        if (runs.length % 2 == 0) {
            median = (runs[runs.length / 2 - 1] + runs[runs.length / 2]) / 2.0;
        } else {
            median = runs[runs.length / 2];
        }

        return new double[]{mean, median};
    }
    
	//Filter Operation for player
	/**
	 * To filter the player data from the data.txt file.
	 * @param Integer, i.e., the year of the player record.
	 * @return List<Player>, list of players who have a record in the data.txt file in the year matching the input provided.
	 */
    public List<Player> filterDataByYear(String year) {
        List<Player> players = readData();
        return players.stream().filter(p -> p.getYear().equals(year)).collect(Collectors.toList());
    }

}
