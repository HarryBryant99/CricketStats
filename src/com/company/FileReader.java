package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    /**
     * Takes in the filename and creates a scanner if the file exists and is readable. If not an exception is thrown
     *
     * @param filename The file that is to be read.
     * @return a list of names stored in an array list is returned.
     */
    public ArrayList readFile(String filename) {
        Scanner in = null;
        File inputFile = new File(filename);

        //Try catch block to remove the FileNotFoundException if the user enters a file not recognised by the program.
        try {
            in = new Scanner(inputFile);
            //This sets the scanner to look in the input file rather than null.
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open " + filename);
            System.exit(0);
            /* If the file the user is trying to open isn't found the exception is caught and dealt with so that the
             * program doesn't crash. The user gets an error message on screen alerting them that the file hasn't been
             * opened and therefore the program won't continue.
             */
        }

        return readNames(in);
    }

    /**
     * Returns all the current users of the system.
     *
     * @param lineIn The scanner to read the lines in the file.
     * @return The contents of the file is returned.
     */
    private ArrayList<Player> readNames(Scanner lineIn) {
        // Array list to store all the users read from the file.
        ArrayList<Player> listRead = new ArrayList<>();

        lineIn.useDelimiter(",");

        String name;
        int matches;
        int innings;
        int notOuts;
        int runs;
        int ballsFaced;
        double average;
        int hundreds;
        int fifties;
        double strikeRate;
        int topScore;

        int ballsBowled;
        int runsConceded;
        int wickets;
        double bowlingaverage;
        double economy;
        int bestFiguresWickets;
        int bestFiguresRuns;

        // Loop runs until there are no more rows left to read, adding each user to the array list.
        while (lineIn.hasNext()) {
            name = lineIn.next();
            if (name.contains("\r\n")) {
                name = name.substring(2);
            } else if (name.substring(0,1).equalsIgnoreCase("\n")){
                name = name.substring(1);
            }

            matches = lineIn.nextInt();
            innings = lineIn.nextInt();
            notOuts = lineIn.nextInt();
            runs = (int) lineIn.nextDouble();
            ballsFaced = lineIn.nextInt();
            average = lineIn.nextDouble();
            fifties = lineIn.nextInt();
            hundreds = lineIn.nextInt();
            strikeRate = lineIn.nextDouble();
            topScore = lineIn.nextInt();
            ballsBowled = lineIn.nextInt();
            runsConceded = lineIn.nextInt();
            wickets = lineIn.nextInt();
            bowlingaverage = lineIn.nextInt();
            economy = lineIn.nextDouble();
            bestFiguresWickets = lineIn.nextInt();
            bestFiguresRuns = lineIn.nextInt();

            Player newPlayer = new Player(name, matches, innings, notOuts, runs, ballsFaced, fifties, hundreds, topScore,
                    ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresRuns);
            listRead.add(newPlayer);


        }
        return listRead;
    }
}
