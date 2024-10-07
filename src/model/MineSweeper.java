package model;


import java.util.Scanner;
/**
 * 
 */
public class MineSweeper {
  
    static Scanner scn = new Scanner(System.in);

    private static void generateHints(char[][] theMinefield) {
        int rows = theMinefield.length;
        int columns = theMinefield[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (theMinefield[i][j] == '*') {
                    // if there are spaces north
                    if (i > 0) {
                        if (theMinefield[i - 1][j] != '*') {
                            theMinefield[i - 1][j]++;
                        }
                        // if there are spaces north-west
                        if (j > 0) {
                            if (theMinefield[i - 1][j - 1] != '*') {
                                theMinefield[i - 1][j - 1]++;
                            }
                        }
                        // if there are spaces north-east
                        if (j < (columns - 1)) {
                            if (theMinefield[i - 1][j + 1] != '*') {
                                theMinefield[i - 1][j + 1]++;
                            }
                        }
                    }
                    // if there are spaces east
                    if (j < (columns - 1)) {
                        if (theMinefield[i][j + 1] != '*') {
                            theMinefield[i][j + 1]++;
                        }
                    }
                    // if there are spaces west
                    if (j > 0) {
                        if (theMinefield[i][j - 1] != '*') {
                            theMinefield[i][j - 1]++;
                        }
                    }
                    // if there are spaces south
                    if (i < rows - 1) {
                        if (theMinefield[i + 1][j] != '*') {
                            theMinefield[i + 1][j]++;
                        }

                        // if there are spaces south-west
                        if (j > 0) {
                            if (theMinefield[i + 1][j - 1] != '*') {
                                theMinefield[i + 1][j - 1]++;
                            }
                        }
                        // if there are spaces south-east
                        if (j < columns - 1) {
                            if (theMinefield[i + 1][j + 1] != '*') {
                                theMinefield[i + 1][j + 1]++;
                            }
                        }
                    }
                }
            }
        }
    }

    private static char[][] generateMinefield(){
        //n represents rows.
        int n = scn.nextInt();
        //m represents columns.
        int m = scn.nextInt();
        if ((n == 0 && m == 0) || n > 100 || m > 100) {
            return null;
        }
        
        if(scn.hasNextLine()) {
            scn.nextLine();
        }
        char[][] newMinefield = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            char[] row = scn.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if(row[j] == '*') {
                    newMinefield[i][j] = '*';
                } else {
                    newMinefield[i][j] = '0';
                }
                
            }
        }
        return newMinefield;
    }
    
    private static void printMinefield(char[][] theMinefield, int theNumFields) {
        int rows = theMinefield.length;
        int columns = theMinefield[0].length;
        System.out.println("Field #" + theNumFields+":");
        for(int i = 0; i < rows; i++) {
            if (i > 0) {
                System.out.println();
            }
            for(int j = 0; j < columns; j++) {
                System.out.print(theMinefield[i][j]);
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int numFields = 1;
        
        while(true) {
            char[][] theMinefield = generateMinefield();
            if(theMinefield == null) {
                break;
            }else {
                
                generateHints(theMinefield);
                printMinefield(theMinefield, numFields);
                System.out.println();
                numFields++;
            }
            if(!scn.hasNextLine()) {
                break;
            }
            
            
            
        }
        
    }
}
