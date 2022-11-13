package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Player> players = new ArrayList<>();
    private static String name;
    private static int matches;
    private static int innings;
    private static int notOuts;
    private static double runsScored;
    private static int balls;
    private static int fifties;
    private static int hundreds;
    private static int topScore;
    private static double overs;
    private static int ballsBowled;
    private static int runsConceded;
    private static int wickets;
    private static int bestFiguresWickets;
    private static int bestFiguresRuns;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean fileExists = false;

        while (!fileExists) {

            System.out.println("Enter the name of the file you want to work on:");
            String filename = scanner.next();
            scanner.nextLine();
            System.out.println(filename);

            fileExists =  fileExists(filename);
            if (fileExists) {
                FileReader fileReader = new FileReader();
                players = fileReader.readFile("walest20.txt");
                endOfSeason();
                //addMatch();
            } else {
                System.out.println("Please enter a name of a file that exists");
            }
        }
    }

    private static void addMatch() {
        Writer playerWriter = new Writer();

        addInnings(playerWriter, scanner);
        //addInnings(playerWriter, scanner);
    }

    private static void addInnings(Writer playerWriter, Scanner scanner){
        System.out.println("Batting Stats (those that batted)");
        boolean stop = false;
        while (stop == false){
            System.out.println("Name:");
            name = scanner.next();
            if (name.equalsIgnoreCase("stop")){
                stop = true;
            }else{
                name = name + scanner.nextLine();
                matches = 1;

                innings = 1;
                System.out.println("Not Out?");

                String notOut = "";
                notOuts = 0;
                while (!(notOut.equalsIgnoreCase("y") || notOut.equalsIgnoreCase("n"))){
                    notOut = scanner.nextLine();
                }

                if (notOut.equalsIgnoreCase("y")){
                    notOuts = 1;
                }

                System.out.println("Runs:");
                runsScored = scanner.nextDouble();
                System.out.println("Balls Faced:");
                balls = scanner.nextInt();

                fifties = 0;
                hundreds = 0;

                if ((50 <= runsScored) && (runsScored < 100)){
                    fifties = 1;
                } else if (runsScored >= 100){
                    hundreds = 1;
                }

                topScore = (int) runsScored;

                ballsBowled = 0;
                runsConceded = 0;
                wickets = 0;


                int i;
                boolean existing = false;
                for (i = 0; i < players.size(); i++){
                    if (name.equals(players.get(i).getName())){
                        matches = matches + players.get(i).getMatches();
                        innings = innings + players.get(i).getInnings();
                        notOuts = notOuts + players.get(i).getNotOuts();
                        runsScored = runsScored + players.get(i).getRuns();
                        balls = balls + players.get(i).getBalls();
                        fifties = fifties + players.get(i).getFifties();
                        hundreds = hundreds + players.get(i).getHundreds();
                        existing = true;

                        players.get(i).setMatches(matches);
                        players.get(i).setInnings(innings);
                        players.get(i).setNotOuts(notOuts);
                        players.get(i).setRuns(runsScored);
                        players.get(i).setBalls(balls);
                        players.get(i).setHundreds(hundreds);
                        players.get(i).setFifties(fifties);

                        if (topScore > players.get(i).getTopScore()) {
                            players.get(i).setTopScore(topScore);
                        }
                    }
                    players.get(i).setAverage();
                    players.get(i).setStrikeRate();
                }


                if (!existing){
                    Player newPlayer = new Player(name, matches, innings, notOuts, runsScored, balls, fifties, hundreds, topScore,
                            ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresRuns);
                    players.add(newPlayer);
                }

            }
        }

        System.out.println("Enter players that didnt bat");
        stop = false;
        while (stop == false){
            System.out.println("Name:");
            name = scanner.next();
            if (name.equalsIgnoreCase("stop")){
                stop = true;
            }else{
                name = name + scanner.nextLine();
                matches = 1;

                innings = 0;
                notOuts = 0;
                runsScored = 0;
                balls = 0;
                fifties = 0;
                hundreds = 0;
                topScore = 0;
                ballsBowled = 0;
                runsConceded = 0;
                wickets = 0;

                int i;
                boolean existing = false;
                for (i = 0; i < players.size(); i++){
                    if (name.equals(players.get(i).getName())){
                        matches = matches + players.get(i).getMatches();
                        innings = innings + players.get(i).getInnings();
                        notOuts = notOuts + players.get(i).getNotOuts();
                        runsScored = runsScored + players.get(i).getRuns();
                        balls = balls + players.get(i).getBalls();
                        fifties = fifties + players.get(i).getFifties();
                        hundreds = hundreds + players.get(i).getHundreds();
                        existing = true;

                        players.get(i).setMatches(matches);
                        players.get(i).setInnings(innings);
                        players.get(i).setNotOuts(notOuts);
                        players.get(i).setRuns(runsScored);
                        players.get(i).setBalls(balls);
                        players.get(i).setHundreds(hundreds);
                        players.get(i).setFifties(fifties);

                        if (topScore > players.get(i).getTopScore()) {
                            players.get(i).setTopScore(topScore);
                        }
                    }
                    players.get(i).setAverage();
                    players.get(i).setStrikeRate();
                }


                if (!existing){
                    Player newPlayer = new Player(name, matches, innings, notOuts, runsScored, balls, fifties, hundreds, topScore,
                            ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresRuns);
                    players.add(newPlayer);
                }

            }
        }

        System.out.println("Bowling Stats");
        stop = false;
        while (stop == false){
            System.out.println("Name:");
            name = scanner.next();
            if (name.equalsIgnoreCase("stop")){
                stop = true;
            }else{
                name = name + scanner.nextLine();

                matches = 0;
                innings = 0;
                notOuts = 0;
                runsScored = 0;
                balls = 0;
                fifties = 0;
                hundreds = 0;
                topScore = 0;

                System.out.println("Balls:");
                ballsBowled = scanner.nextInt();
                System.out.println("Runs:");
                runsConceded = scanner.nextInt();
                System.out.println("Wickets:");
                wickets = scanner.nextInt();

                int j;
                boolean existing = false;
                for (j = 0; j < players.size(); j++){
                    if (name.equals(players.get(j).getName())){
                        ballsBowled = ballsBowled + players.get(j).getBallsBowled();
                        runsConceded = runsConceded + players.get(j).getRunsConceded();
                        wickets = wickets + players.get(j).getWickets();
                        existing = true;

                        players.get(j).setBallsBowled(ballsBowled);
                        players.get(j).setRunsConceded(runsConceded);
                        players.get(j).setWickets(wickets);
                        players.get(j).setEconomy();

                        double extraBalls = (ballsBowled % 6);
                        overs = ((ballsBowled - extraBalls)/6) + (extraBalls/10);
                        players.get(j).setOvers(overs);
                    }
                }


                if (!existing){
                    Player newPlayer = new Player(name, matches, innings, notOuts, runsScored, balls, fifties, hundreds, topScore,
                            ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresWickets);
                    players.add(newPlayer);
                }
            }



        }

        String correct = "";
        System.out.println("Is this correct");
        while (!correct.equalsIgnoreCase("y") && !correct.equalsIgnoreCase("n")){
            correct = scanner.nextLine();
        }

        if (correct.equalsIgnoreCase("y")) {
            playerWriter.writePlayers(players);
        }
    }

    private static void endOfSeason(){
        Writer playerWriter = new Writer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Batting Stats");
        boolean stop = false;
        while (stop == false){
            System.out.println("Name:");
            name = scanner.next();
            if (name.equalsIgnoreCase("stop")){
                stop = true;
            }else{
                name = name + scanner.nextLine();
                System.out.println("Matches:");
                matches = scanner.nextInt();
                System.out.println("Innings:");
                innings = scanner.nextInt();
                System.out.println("Not Outs:");
                notOuts = scanner.nextInt();
                System.out.println("Runs:");
                runsScored = scanner.nextDouble();
                System.out.println("Balls Faced:");
                balls = scanner.nextInt();
                System.out.println("100s:");
                hundreds = scanner.nextInt();
                System.out.println("50s:");
                fifties = scanner.nextInt();
                System.out.println("Top Score:");
                topScore = scanner.nextInt();

                int i;
                boolean existing = false;
                for (i = 0; i < players.size(); i++){
                    if (name.equals(players.get(i).getName())){
                        matches = matches + players.get(i).getMatches();
                        innings = innings + players.get(i).getInnings();
                        notOuts = notOuts + players.get(i).getNotOuts();
                        runsScored = runsScored + players.get(i).getRuns();
                        balls = balls + players.get(i).getBalls();
                        hundreds = hundreds + players.get(i).getHundreds();
                        fifties = fifties + players.get(i).getFifties();
                        existing = true;

                        players.get(i).setMatches(matches);
                        players.get(i).setInnings(innings);
                        players.get(i).setNotOuts(notOuts);
                        players.get(i).setRuns(runsScored);
                        players.get(i).setBalls(balls);
                        players.get(i).setHundreds(hundreds);
                        players.get(i).setFifties(fifties);

                        if (topScore > players.get(i).getTopScore()) {
                            players.get(i).setTopScore(topScore);
                        }
                    }
                    players.get(i).setAverage();
                    players.get(i).setStrikeRate();
                }


                if (!existing){
                    Player newPlayer = new Player(name, matches, innings, notOuts, runsScored, balls, fifties, hundreds, topScore,
                            ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresRuns);
                    players.add(newPlayer);
                }

            }
        }

        System.out.println("Bowling Stats");
        stop = false;
        while (stop == false){
            System.out.println("Name:");
            name = scanner.next();
            if (name.equalsIgnoreCase("stop")){
                stop = true;
            }else{
                name = name + scanner.nextLine();
                System.out.println("Balls:");
                ballsBowled = scanner.nextInt();
                System.out.println("Runs:");
                runsConceded = scanner.nextInt();
                System.out.println("Wickets:");
                wickets = scanner.nextInt();

                int j;
                boolean existing = false;
                for (j = 0; j < players.size(); j++){
                    if (name.equals(players.get(j).getName())){
                        ballsBowled = ballsBowled + players.get(j).getBallsBowled();
                        runsConceded = runsConceded + players.get(j).getRunsConceded();
                        wickets = wickets + players.get(j).getWickets();
                        existing = true;

                        players.get(j).setBallsBowled(ballsBowled);
                        players.get(j).setRunsConceded(runsConceded);
                        players.get(j).setWickets(wickets);
                        players.get(j).setEconomy();

                        double extraBalls = (ballsBowled % 6);
                        overs = ((ballsBowled - extraBalls)/6) + (extraBalls/10);
                        players.get(j).setOvers(overs);
                    }
                }


                if (!existing){
                    Player newPlayer = new Player(name, matches, innings, notOuts, runsScored, balls, fifties, hundreds, topScore,
                            ballsBowled, runsConceded, wickets, bestFiguresWickets, bestFiguresRuns);
                    players.add(newPlayer);
                }
            }



        }

        playerWriter.writePlayers(players);
    }

    private static Boolean fileExists(String filename) {
        Scanner in = null;
        File inputFile = new File(filename);

        //Try catch block to remove the FileNotFoundException if the user enters a file not recognised by the program.
        try {
            in = new Scanner(inputFile);
            //This sets the scanner to look in the input file rather than null.
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open " + filename);
            System.exit(0);
            /* If the file the user is trying to open isn't found the exception is caught and dealt with so that the
             * program doesn't crash. The user gets an error message on screen alerting them that the file hasn't been
             * opened and therefore the program won't continue.
             */
            return false;
        }
    }
}
