package com.company;

public class Player {
    private String name;
    private int matches;
    private int innings;
    private int notOuts;
    private double runs;
    private int balls;
    private int fifties;
    private int hundreds;
    private int topScore;
    private double average;
    private double strikeRate;
    private double overs;
    private int ballsBowled;
    private int runsConceded;
    private int wickets;
    private int bestFiguresWickets;
    private int bestFiguresRuns;
    private double bowlingAverage;
    private double economy;

    public Player(String name, int matches, int innings, int notOuts, double runs, int balls, int fifties, int hundreds, int topScore,
                  int ballsBowled, int runsConceded, int wickets, int bestFiguresWickets, int bestFiguresRuns){
        this.name = name;
        this.matches = matches;
        this.innings = innings;
        this.notOuts = notOuts;
        this.runs = runs;
        this.balls = balls;
        this.fifties = fifties;
        this.hundreds = hundreds;
        this.topScore = topScore;
        this.average = runs/(innings-notOuts);

        setStrikeRate();
        this.strikeRate = getStrikeRate();
        this.overs = overs;
        this.runsConceded = runsConceded;
        this.wickets = wickets;
        this.bestFiguresWickets = bestFiguresWickets;
        this.bestFiguresRuns = bestFiguresRuns;
        this.ballsBowled = ballsBowled;

        setEconomy();
        this.economy = getEconomy();
    }

    public double getAverage() {
        return average;
    }

    public int getInnings() {
        return innings;
    }

    public int getMatches() {
        return matches;
    }

    public int getNotOuts() {
        return notOuts;
    }

    public double getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public String getName() {
        return name;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void setNotOuts(int notOuts) {
        this.notOuts = notOuts;
    }

    public void setRuns(double runs) {
        this.runs = runs;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setAverage() {
        this.average = getRuns()/(getInnings()-getNotOuts());
    }

    public void setStrikeRate() {
        if (getRuns() == 0){
            this.strikeRate = 0;
        }else {
            this.strikeRate = (getRuns() / getBalls()) * 100;
        }
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getFifties() {
        return fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public int getTopScore() {
        return topScore;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public void setTopScore(int topScore) {
        this.topScore = topScore;
    }

    public double getOvers() {
        return overs;
    }

    public double getEconomy() {
        return economy;
    }

    public int getBestFiguresRuns() {
        return bestFiguresRuns;
    }

    public int getBestFiguresWickets() {
        return bestFiguresWickets;
    }

    public int getRunsConceded() {
        return runsConceded;
    }

    public void setBestFiguresRuns(int bestFiguresRuns) {
        this.bestFiguresRuns = bestFiguresRuns;
    }

    public void setBestFiguresWickets(int bestFiguresWickets) {
        this.bestFiguresWickets = bestFiguresWickets;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public void setRunsConceded(int runsConceded) {
        this.runsConceded = runsConceded;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled(int ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public void setEconomy() {
        if (getBallsBowled() != 0) {
            double runsConcededDouble = getRunsConceded();
            double ballsBowledDouble = getBallsBowled();
            this.economy = (runsConcededDouble / ballsBowledDouble)*6;
        }else{
            this.economy = 0;
        }
    }

    public double getBowlingAverage() {
        return getRunsConceded()/getWickets();
    }

    public String getBestFigures(){
        return getBestFiguresWickets() + "-" + getBestFiguresRuns();
    }
}
