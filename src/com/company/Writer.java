package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Writer {
    public Writer(){

    }

    public void writePlayers(ArrayList<Player> playerList)  {
        Scanner userFileScanner = null;

        try {
            userFileScanner = new Scanner(new File("newFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("newFile.txt");

            int i = 0;
            for (i = 0; i < playerList.size(); i++){
                double average;
                if (playerList.get(i).getNotOuts() != playerList.get(i).getInnings()){
                    average = playerList.get(i).getAverage();
                }else {
                    average = playerList.get(i).getRuns();
                }

                if (i == playerList.size() -1){
                    fileWriter.write(playerList.get(i).getName() + "," +
                            playerList.get(i).getMatches() + "," +
                            playerList.get(i).getInnings() + "," +
                            playerList.get(i).getNotOuts() + "," +
                            playerList.get(i).getRuns() + "," +
                            playerList.get(i).getBalls() + "," +
                            average + "," +
                            playerList.get(i).getFifties() + "," +
                            playerList.get(i).getHundreds() + "," +
                            playerList.get(i).getStrikeRate() + "," +
                            playerList.get(i).getTopScore() + "," +

                            playerList.get(i).getBallsBowled() + "," +
                            playerList.get(i).getRunsConceded() + "," +
                            playerList.get(i).getWickets() + "," +
                            playerList.get(i).getBowlingAverage() + "," +
                            playerList.get(i).getEconomy() + "," +
                            playerList.get(i).getBestFigures());
                } else {
                    fileWriter.write(playerList.get(i).getName() + "," +
                            playerList.get(i).getMatches() + "," +
                            playerList.get(i).getInnings() + "," +
                            playerList.get(i).getNotOuts() + "," +
                            playerList.get(i).getRuns() + "," +
                            playerList.get(i).getBalls() + "," +
                            average + "," +
                            playerList.get(i).getFifties() + "," +
                            playerList.get(i).getHundreds() + "," +
                            playerList.get(i).getStrikeRate() + "," +
                            playerList.get(i).getTopScore() + "," +

                            playerList.get(i).getBallsBowled() + "," +
                            playerList.get(i).getRunsConceded() + "," +
                            playerList.get(i).getWickets() + "," +
                            playerList.get(i).getBowlingAverage() + "," +
                            playerList.get(i).getEconomy() + "," +
                            playerList.get(i).getBestFigures() + ",\n");
                }
            }

            fileWriter.close(); //Closes the fileWriter

        } catch (FileNotFoundException e) { // If the file does not exist, handles problem.
            System.err.println("File newFile.txt does not exist.");
            System.exit(-1);
        } catch (IOException e){ // If there was a problem writing, gives feedback to the user.
            System.err.println("Caught IO error, writing to the file");
            System.exit(-1);
        }
    }
}
