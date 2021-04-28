import java.util.Scanner;
import distance.ClosestWord;

public class SpellCheckLauncher {
    static String[] UserInput () {
        System.out.println("enter 2 sentences separated by a comma:");
        String input = scnr.nextLine();
        int commaPos = scnr.nextLine().indexOf(',');
        if (commaPos > -1){
            return input.split(',', 1);
        }
    }

    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        String[] userInput = userInput();
        String firstSentence = userInput[0];
        String secondSentence = userInput[1];

        


        scnr.close();
        int stepsNeeded = ClosestWord.levEditDistance(firstSentence, secondSentence);

        System.out.println("steps needed: " + stepsNeeded);
    }
}