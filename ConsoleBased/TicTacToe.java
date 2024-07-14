import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static String player1;
    private static String player2;
    private static Scanner sc = new Scanner(System.in);

    private static void welcomeMessage(){
        System.out.println("Welcome to TIC-TAC-TOE :)\nFill the details below...");
    }
    private static void getPlayerNames() {
        System.out.print("Enter name for player 1: ");
        player1 = sc.nextLine();
        System.out.print("Enter name for player O: ");
        player2 = sc.nextLine();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove() {
        int row, col;
        while (true) {
            System.out.println("Player " + (currentPlayer == 'X' ? player1 : player2) + ", enter your move (row and column): ");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        welcomeMessage();
        getPlayerNames();
        initializeBoard();
        printBoard();

        while (true) {
            playerMove();
            printBoard();

            if (checkWinner()) {
                System.out.println("Player " + (currentPlayer == 'X' ? player1 : player2) + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It is a draw..! \nWell Played :)");
                break;
            }

            switchPlayer();
        }
    }

}
