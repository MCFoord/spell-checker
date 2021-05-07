package main;
import java.util.Scanner;

import main.distance.ClosestWord;

public class SpellCheckLauncher {
    static Boolean validateInput(String input) {
        int commaPos = input.indexOf(',');
        if (commaPos > -1){
            return true;
        }
        System.out.println("No commas detected; sentences need to be split by a comma");
        return false;
    }

    static String[] userInput() {
        Scanner scnr = new Scanner(System.in);
        Boolean isValid = false;
        String input = "";

        while(!isValid) {
            System.out.println("enter 2 sentences separated by a comma:");
            input = scnr.nextLine();
            isValid = validateInput(input);
        }

        scnr.close();
        return input.split(",", 2);
    }

    public static void main (String [] args) {
        String[] userInput = userInput();
        String firstSentence = userInput[0];
        String secondSentence = userInput[1];

        int stepsNeeded = ClosestWord.levEditDistance(firstSentence, secondSentence);
        System.out.println("steps needed: " + stepsNeeded);
    }
}