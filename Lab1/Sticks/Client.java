package Sticks;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    private static final String BINDING_NAME = "RMISTICKS";
    private static final int port = 8080;
    private static Board board;
    private static int id;
    private static Scanner scanner;
    private static int x, y;

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void init() throws RemoteException, NotBoundException, InterruptedException {
        board = new Board();
        scanner = new Scanner(System.in);
        clearScreen();
    }

    private static boolean getInput() {
        System.out.print("Enter row: ");
        if (scanner.hasNextInt()) {

            x = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter column: ");
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
                scanner.nextLine();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {

        init();

        final Registry registry = LocateRegistry.getRegistry(port);
        IBoard gameBoard = (IBoard) registry.lookup(BINDING_NAME);

        System.out.print("Enter your name: ");
        id = gameBoard.register(scanner.nextLine());

        System.out.println("Your id is: " + id);
        while (!gameBoard.isGameStarted()) {
            Thread.sleep(10);
        }
        System.out.println("Game started!");
        System.out.println("You is " + gameBoard.getName(id));
        System.out.println();

        clearScreen();

        board.setNames(gameBoard.getNames()[0], gameBoard.getNames()[1]);
        board.setBoard(gameBoard.getBoard());
        board.PrintBoard();

        System.out.println("You is " + gameBoard.getName(id));
        System.out.println(" Turn: " + gameBoard.getName(gameBoard.getTurn()));

        while (gameBoard.getWinner() < 0) {

            while (!gameBoard.isMyTurn(id)) {
                Thread.sleep(10);
            }
            if (gameBoard.getWinner() >= 0)
                break;

            clearScreen();
            board.setBoard(gameBoard.getBoard());
            board.PrintBoard();

            System.out.println("You is " + gameBoard.getName(id));
            System.out.println(" Turn: " + gameBoard.getName(gameBoard.getTurn()));

            boolean inputIsValid = false;
            while (inputIsValid == false) {

                inputIsValid = getInput();
                if (!inputIsValid) {
                    scanner.nextLine();
                    clearScreen();
                    board.PrintBoard();
                }
            }
            gameBoard.MakeMove(x, y);

            clearScreen();
            board.setBoard(gameBoard.getBoard());
            board.PrintBoard();
            System.out.println("You is " + gameBoard.getName(id));
            System.out.println("Turn: " + gameBoard.getName(gameBoard.getTurn()));
        }

        clearScreen();
        board.setBoard(gameBoard.getBoard());
        board.PrintBoard();

        int winner = gameBoard.getWinner();
        if (winner == 0) {
            System.out.println("DRAW");
            System.out.println("Score: \n" + gameBoard.getNames()[0] + ":" + gameBoard.getScores()[0] + "\n" +
                    gameBoard.getNames()[1] + ":" + gameBoard.getScores()[1]);
        } else {
            System.out.println("The winner is :" + gameBoard.getName(winner));
            System.out.println("Score: \n" + gameBoard.getNames()[0] + ":" + gameBoard.getScores()[0] + "\n" +
                    gameBoard.getNames()[1] + ":" + gameBoard.getScores()[1]);
        }
        scanner.close();
    }
}
