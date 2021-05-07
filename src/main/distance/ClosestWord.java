package main.distance;

public class ClosestWord {

    public static void printMatrix (int[][] matrix, String string1, String string2) {
        String printString;
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= string1.length(); i++ ) {
            System.out.print(string1.charAt(i - 1));

            if (i != string1.length()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int j = 0; j < string2.length() + 1; j++) {
            printString = (j == 0) ? "  " : string2.charAt(j - 1) + " ";
            System.out.print(printString);
            for (int i = 0; i < matrix.length; i++) {
                printString = String.valueOf(matrix[i][j]);
                printString += (i == matrix.length - 1) ? "" : " ";
                System.out.print(printString);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int minOfThree (int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    public static int levEditDistance (String string1, String string2) {
        int[][] distMatrix = new int[string1.length() + 1][string2.length() + 1];
        int substitutionCost;
        
        for (int i = 0; i < distMatrix.length; i++) {
            distMatrix[i][0] = i;
        }

        for (int j = 1; j < distMatrix[0].length; j++) {
            distMatrix[0][j] = j;
        }

        for (int j = 1; j < distMatrix[0].length; j++) {
            for (int i = 1; i < distMatrix.length; i++) {
                substitutionCost = (string2.charAt(j - 1) == string1.charAt(i - 1)) ? 0 : 1;
                
                distMatrix[i][j] = minOfThree(
                    distMatrix[i - 1][j] + 1,                       //deletion
                    distMatrix[i][j - 1] + 1,                       //insertion
                    distMatrix[i - 1][j - 1] + substitutionCost     //substitution
                );
            }
        }
        printMatrix(distMatrix, string1, string2);
        return distMatrix[string1.length()][string2.length()];
    }
}