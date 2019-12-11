import java.util.InputMismatchException;
import java.util.Scanner;

public class project {
    Scanner scanner;
    char [][] field;
    final char X_SIGN = 'X';
    final char O_SIGN = 'O';
    final char EMPTY_SIGN = '_';

    public static void main(String[] args) {
        new project().play();
    }
    project(){
        scanner = new Scanner(System.in);
        field = new char[3][3];
    }
    void play(){
        initField();
        printField();
        game();
    }
    void initField(){
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = EMPTY_SIGN;
            }
        }
    }
    void printField(){
        System.out.println("---------");
        for (int row = 0; row < field.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    void game(){
        while (true) {
            turnX();
            if(checkWin(X_SIGN)){
                System.out.println("X wins");
                break;
            }
            if(isFieldFull()){
                System.out.println("Draw");
                break;
            }
            turnO();
            if (checkWin(O_SIGN)){
                System.out.println("O wins");
                break;
            }
            if(isFieldFull()){
                System.out.println("Draw");
                break;
            }
        }
    }


    boolean cellOutOfRange(int x, int y){
        return x < 0 || x > 2 || y < 0 || y > 2;
    }

    void turnX(){
        int x, y;
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;

                if (cellOutOfRange(x, y)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (field[field[x].length - y - 1][x] != EMPTY_SIGN) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    field[field[x].length - y - 1][x] = X_SIGN;
                    printField();
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
    }
    void turnO(){
        int x, y;
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;

                if (cellOutOfRange(x, y)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (field[field[x].length - y - 1][x] != EMPTY_SIGN) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    field[field[x].length - y - 1][x] = O_SIGN;
                    printField();
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
    }

    boolean checkWin(char dot){
        for (int i = 0; i < 3; i++) {
            if((field[i][0]) == dot && field[i][1] == dot && field[i][2] == dot ||
                    (field[0][i]) == dot && field[1][i] == dot && field[2][i] == dot){
                return true;
            }
            if((field[0][0]) == dot && field[1][1] == dot && field[2][2] == dot ||
                    (field[0][2]) == dot && field[1][1] == dot && field[2][0] == dot){
                return true;
            }
        }
        return false;
    }
    boolean isFieldFull(){
        for (int row = 0; row < field.length; row++)
            for (int col = 0; col < field[row].length; col++)
                if (field[row][col] == EMPTY_SIGN) return false;
        return true;
    }
}
