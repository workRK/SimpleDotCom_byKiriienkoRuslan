package org.kiriienko.game;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();

    public ArrayList<DotCom> getDotComsList() {
        return dotComsList;
    }

    private int numOfGuesses = 0;
    private char[][] oceanGrid;

    public int getNumOfGuesses() {
        return numOfGuesses;
    }

    public void setUpGame() {
        // first make some dot coms and give
        // them location
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);

            dotComToSet.setLocationCells(newLocation);
        }

        initializeOceanGrid();
    }

    public void startPlaying() {

        while (!dotComsList.isEmpty()) {

            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "miss";
        oceanGrid[Integer.parseInt(userGuess.substring(1))]["abcdwfg".indexOf(userGuess.charAt(0))] = 'M';

        for (int x = 0; x < dotComsList.size(); x++) {
            result = dotComsList.get(x).checkYourself(userGuess);

            if (result.equals("hit")) {
                oceanGrid[Integer.parseInt(userGuess.substring(1))]["abcdwfg".indexOf(userGuess.charAt(0))] = 'H';
                break;
            }

            if (result.equals("kill")) {
                oceanGrid[Integer.parseInt(userGuess.substring(1))]["abcdwfg".indexOf(userGuess.charAt(0))] = 'K';
                dotComsList.remove(x);
                break;
            }
        }

        printOceanGrid();
        System.out.println(result);
    }

    void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless");

        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guessses");
            System.out.println("Fish are dancing with your optons");
        }
    }

    public void printOceanGrid() {
        System.out.println("  0 1 2 3 4 5 6");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 7; j++) {
                System.out.print(oceanGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void initializeOceanGrid() {
        oceanGrid = new char[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                oceanGrid[i][j] = ' ';
            }
        }
    }
}