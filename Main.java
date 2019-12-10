
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner scanner;
    String[][] table;
    String str;
    int x = 0;
    int o = 0;
    public static void main(String[] args) {
        new Main().play();
    }
    Main(){
        scanner = new Scanner(System.in);
        table = new String[3][3];
    }
    void initTable(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                    table[row][col] = "_";
            }
        }
    }

    void printTable(){
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(table[row][col]+ " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
//    String checkWin(int x, int o) {
//        boolean xWins = false;
//        boolean oWins = false;
//        int freeSpace = 0;
//        for (int col = 0, row = 0; col < 3; col++, row++) {
//            if(table[row][col].equals("_")) freeSpace++;
//            if (table[row][0].equals(table[row][1]) && table[row][1].equals(table[row][2])) {
//                if (table[row][0].equals("X")) {
//                    xWins = true;
//                }
//                if (table[row][0].equals("O")) {
//                    oWins = true;
//                }
//            }
//            if (table[0][col].equals(table[1][col]) && table[1][col].equals(table[2][col])) {
//                if (table[0][col].equals("X")) {
//                    xWins = true;
//                }
//                if (table[0][col].equals("O")) {
//                    oWins = true;
//                }
//            }
//            if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2]) || table[2][0].equals(table[1][1]) && table[1][1].equals(table[0][2])) {
//                if (table[1][1].equals("X")) {
//                    xWins = true;
//                }
//                if (table[1][1].equals("O")) {
//                    oWins = true;
//                }
//            }
//
//        }
//        if(freeSpace == 0){
//            if (xWins || oWins){}
//            else{
//                return "Draw";
//            }
//        }
//        if (xWins) {
//            if (oWins) {
//                return "Impossible";
//            }
//            return "X wins";
//        }
//        if (oWins) {
//            return "O wins";
//        }
//        if(Math.abs(x-o)>1){
//            return "Impossible";
//        }
//        return "Game not finished";
//    }
    void play(){
        initTable();
        //checkWin(x,o);
        printTable();

        while(true) {
            turnX();
            break;
            //turnO();
            /* System.out.print("Enter the coordinates: ");

            int row, col;
            try {
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                switch (row){
                    case 0 : if(col == 1){
                                    row = 2;
                                    col = 1;
                                    break;
                            }
                            if(col == 2){
                                    row = 1;
                                    col = 1;
                                    break;
                            }
                            if(col == 3){
                                row = 0;
                                col = 1;
                                break;
                            }
                    case 1: if(col == 1){
                                row = 2;
                                col = 2;
                                 break;
                            }
                            if(col == 2){
                                row = 1;
                                col = 2;
                                break;
                            }
                            if(col == 3){
                                row = 0;
                                col = 2;
                                break;
                            }
                    case 2: if(col == 1){
                                row = 2;
                                col = 3;
                                break;
                            }
                            if(col == 2){
                                row = 1;
                                col = 3;
                                break;
                            }
                            if(col == 3){
                                row = 0;
                                col = 3;
                                break;
                            }
                }


                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else if (!table[row][col].equals("_")) {
                    //System.out.println("Row " + row + " Col " + col);
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    table[row][col] = "X";
                    break;
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }*/
        }
    }
    void turnX(){
        System.out.print("Enter the coordinates: ");
        int row, col;
        try {
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            System.out.println("Row " + row + " col " + col);
            switch (row){
                case 0 : if(col == 0){
                    row = 2;
                    col = 0;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 0;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 0;
                        break;
                    }
                case 1: if(col == 0){
                    row = 2;
                    col = 1;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 1;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 1;
                        break;
                    }
                case 2: if(col == 0){
                    row = 2;
                    col = 2;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 2;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 2;
                        break;
                    }
            }
            System.out.println("Row " + row + " col " + col);
            if(isCellValid(row,col))
            {
                table[row][col] = "X";
                printTable();
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("You should enter numbers!");
        }
    }

    void turnO(){
        System.out.print("Enter the coordinates: ");
        int row, col;
        try {
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            switch (row){
                case 0 : if(col == 0){
                    row = 2;
                    col = 0;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 0;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 0;
                        break;
                    }
                case 1: if(col == 0){
                    row = 2;
                    col = 1;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 1;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 1;
                        break;
                    }
                case 2: if(col == 0){
                    row = 2;
                    col = 2;
                    break;
                }
                    if(col == 1){
                        row = 1;
                        col = 2;
                        break;
                    }
                    if(col == 2){
                        row = 0;
                        col = 2;
                        break;
                    }
            }

            if(isCellValid(row,col))
            {
                table[row][col] = "O";
                printTable();
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("You should enter numbers!");
        }
    }

    boolean isCellValid(int x, int y){
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (!table[x][y].equals("_")){
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

//    String[][] rotate(String [][]array){
//        String[][] resultArray = new String[array[0].length][array.length];
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                resultArray[array[i].length - j - 1][i] = array[i][j];
//            }
//        }
//        return resultArray;
//    }
//    String[][]getArray(String[][] array){
//        String[][] mass = new String[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 1; j < 4; j++) {
//                mass[i][j-1] = array[i][j];
//            }
//        }
//        return mass;
//    }
}
