package Sticks;

import java.rmi.RemoteException;
import java.util.Random;

public class Board implements IBoard {

    int[][] sticks = new int[5][3];
    int[][] squares = new int[2][2];

    char[][] boardTileMap = new char[5][5];

    int P1 = -1, P2 = -2;
    int[] players = { -1, -1 };
    String[] playerNames = { "L", "Light" };
    char[] playerShortNames = new char[] { 'L', 'l' };

    int turn = 0;
    boolean gameStarted = false;
    int winner = -1;
    int p1Score = 0, p2Score = 0;

    public Board() throws RemoteException {

        for (int i = 0; i < sticks.length; i++) {
            if (i % 2 == 0)
                sticks[i][sticks[i].length - 1] = -1;
            for (int j = 0; j < sticks[i].length; j++)
                sticks[i][j] = 0;
        }

        for (int i = 0; i < squares.length; i++)
            for (int j = 0; j < squares[i].length; j++)
                squares[i][j] = -1;

        for (int i = 0; i < boardTileMap.length; i++)
            for (int j = 0; j < boardTileMap.length; j++)
                boardTileMap[i][j] = ' ';

        Print();
    }

    @Override
    public int[][] getSticks() throws RemoteException {
        return sticks;
    }

    @Override
    public int[][] getSquares() throws RemoteException {
        return squares;
    }

    @Override
    public void FillInBoard() throws RemoteException {

        // Vericies
        for (int i = 0; i < boardTileMap.length; i += 2)
            for (int j = 0; j < boardTileMap.length; j += 2)
                boardTileMap[i][j] = 'O';

        // Horizontal
        for (int i = 0; i < boardTileMap.length; i += 2) {
            int k = 0;
            for (int j = 1; j < boardTileMap.length; j += 2) {
                boardTileMap[i][j] = sticks[i][k] == 1 ? '-' : ' ';
                k++;
            }
        }

        // Vertical
        for (int i = 1; i < boardTileMap.length; i += 2) {
            int k = 0;
            for (int j = 0; j < boardTileMap.length; j += 2) {
                boardTileMap[i][j] = sticks[i][k] == 1 ? '|' : ' ';
                k++;
            }
        }

        // Squares
        int x = 0, y = 0;
        for (int i = 1; i < boardTileMap.length; i += 2) {
            y = 0;
            for (int j = 1; j < boardTileMap[i].length; j += 2) {
                if (squares[x][y] != -1) {
                    if (squares[x][y] == P1)
                        boardTileMap[i][j] = playerShortNames[0];
                    else
                        boardTileMap[i][j] = playerShortNames[1];
                } else {
                    boardTileMap[i][j] = ' ';
                }
                y++;
            }
            x++;
        }

    }

    public void PrintHint() throws RemoteException {

        System.out.println("\nSchema: ");

        for (int i = 0; i < sticks.length; i++) {
            if (i % 2 == 0) {
                System.out.print("  O");

                for (int j = 0; j < sticks[i].length - 1; j++) {
                    System.out.print("--(" + i + "," + j + ")--");
                    System.out.print("O");
                }
                System.out.println();
            } else {
                for (int k = 0; k < 3; k++) {
                    if (k != 1)
                        System.out.print("  ");

                    for (int j = 0; j < sticks[i].length; j++) {
                        if (k != 1) {
                            System.out.print("|         ");
                        } else {
                            System.out.print("(" + i + "," + j + ")     ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    @Override
    public void PrintBoard() throws RemoteException {
        System.out.println("===============");
        System.out.println("  " + playerNames[0] + " VS " + playerNames[1]);

        for (int i = 0; i < boardTileMap.length; i++) {
            if (i % 2 != 0) {
                System.out.print(
                        String.format(
                                " %c   %c   %c\n", boardTileMap[i][0], boardTileMap[i][2], boardTileMap[i][4])
                                +
                                String.format(" %c %c %c %c %c\n", boardTileMap[i][0], boardTileMap[i][1],
                                        boardTileMap[i][2], boardTileMap[i][3], boardTileMap[i][4])
                                +
                                String.format(" %c   %c   %c", boardTileMap[i][0], boardTileMap[i][2],
                                        boardTileMap[i][4]));
            } else {
                System.out.print(" ");
                for (int j = 0; j < boardTileMap.length; j++) {
                    char elem = boardTileMap[i][j];
                    if (elem == 'O') {
                        System.out.print(boardTileMap[i][j]);
                    } else {
                        System.out.print(String.format("%c%c%c", elem, elem, elem));
                    }
                }
            }
            System.out.println();
        }
        PrintHint();
    }

    @Override
    public void Print() throws RemoteException {
        FillInBoard();
        for (int i = 0; i < boardTileMap.length; i++) {
            for (int j = 0; j < boardTileMap[i].length; j++) {
                System.out.print(boardTileMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void setSticks(int[][] s) throws RemoteException {
        sticks = s;
    }

    @Override
    public void setSquares(int[][] s) throws RemoteException {
        squares = s;
    }

    @Override
    public boolean checkSquareLeft(int x, int y) throws RemoteException {
        int upper = sticks[x - 1][y - 1], left = sticks[x][y - 1], down = sticks[x + 1][y - 1];

        if (upper == 1 && left == 1 && down == 1)
            return true;

        return false;
    }

    @Override
    public boolean checkSquareRight(int x, int y) throws RemoteException {
        int upper = sticks[x - 1][y], right = sticks[x][y + 1], down = sticks[x + 1][y];

        if (upper == 1 && right == 1 && down == 1)
            return true;

        return false;

    }

    @Override
    public boolean checkSquareUpper(int x, int y) throws RemoteException {
        int upper = sticks[x - 2][y], left = sticks[x - 1][y], right = sticks[x - 1][y + 1];

        if (upper == 1 && right == 1 && left == 1)
            return true;

        return false;

    }

    @Override
    public boolean checkSquareDown(int x, int y) throws RemoteException {
        int down = sticks[x + 2][y], left = sticks[x + 1][y], right = sticks[x + 1][y + 1];

        if (down == 1 && right == 1 && left == 1)
            return true;

        return false;

    }

    @Override
    public boolean checkSquare(int x, int y) throws RemoteException {
        boolean isSquareBuilt = false;
        if (x % 2 == 0) {
            if (x == 0) {
                if (checkSquareDown(x, y)) {
                    squares[x][y] = turn;
                    isSquareBuilt = true;
                }

            } else if (x == sticks.length - 1) {
                if (checkSquareUpper(x, y)) {
                    squares[x - 3][y] = turn;
                    isSquareBuilt = true;
                }

            } else {
                if (checkSquareDown(x, y)) {
                    squares[x - 1][y] = turn;
                    isSquareBuilt = true;
                }

                if (checkSquareUpper(x, y)) {
                    squares[x - 2][y] = turn;
                    isSquareBuilt = true;
                }

            }
        } else {
            int xq = (int) (x - 1) / 2;
            if (y == 0) {
                if (checkSquareRight(x, y)) {
                    squares[xq][y] = turn;
                    isSquareBuilt = true;
                }

            } else if (y == sticks[x].length - 1) {
                if (checkSquareLeft(x, y)) {
                    squares[xq][y - 1] = turn;
                    isSquareBuilt = true;
                }

            } else {
                if (checkSquareRight(x, y)) {
                    squares[xq][y] = turn;
                    isSquareBuilt = true;
                }

                if (checkSquareLeft(x, y)) {
                    squares[xq][y - 1] = turn;
                    isSquareBuilt = true;
                }

            }
        }
        FillInBoard();
        Print();
        PrintSquares();
        return isSquareBuilt;
    }

    @Override
    public int getTotalScore() throws RemoteException {
        int score = 0;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] == P1 || squares[i][j] == P2)
                    score++;
            }
        }
        return score;
    }

    @Override
    public boolean MakeMove(int x, int y) throws RemoteException {
        if (x < sticks.length) {
            if (y < sticks[x].length - (x % 2 == 0 ? 1 : 0)) {
                if (sticks[x][y] == 0) {
                    sticks[x][y] = 1;

                    if (checkSquare(x, y) == false) {// если квадрат не построен
                        changeTurn(); // меняем ход
                    } else { // если квадат построен, то проверяем победителся
                        checkWinner();
                    }
                    FillInBoard();

                    return true;
                }
            }
        }
        System.out.println("Incorrect move");
        FillInBoard();
        return false;
    }

    public boolean checkWinner() throws RemoteException {
        p1Score = 0;
        p2Score = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] == P1) {
                    p1Score++;
                } else if (squares[i][j] == P2) {
                    p2Score++;
                } else {
                    return false;
                }
            }
        }

        if (p1Score > p2Score) {
            winner = P1;
        } else if (p1Score < p2Score) {
            winner = P2;
        } else {
            winner = 0;
        }

        return true;
    }

    @Override
    public void PrintSquares() throws RemoteException {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                System.out.print(squares[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    @Override
    public void changeTurn() throws RemoteException {
        if (turn == P1) {
            turn = P2;
        } else {
            turn = P1;
        }
    }

    @Override
    public int register(String name) throws RemoteException {

        Random random = new Random();
        if (P1 < 0) {
            P1 = random.nextInt(10, 101);
            playerNames[0] = name;
            return P1;

        } else if (P2 < 0) {
            P2 = random.nextInt(101, 201);
            playerNames[1] = name;
            gameStarted = true;
            turn = P1;
            setNames(playerNames[0], playerNames[1]);
            return P2;
        }
        return -1;
    }

    public void setNames(String p1, String p2) throws RemoteException {
        playerNames[0] = p1;
        playerNames[1] = p2;

        playerShortNames[0] = playerNames[0].charAt(0);
        playerShortNames[1] = playerNames[1].charAt(0);

        if (playerShortNames[0] == playerShortNames[1]) {
            playerShortNames[0] = String.valueOf(playerShortNames[0]).toUpperCase().charAt(0);
            playerShortNames[1] = String.valueOf(playerShortNames[1]).toLowerCase().charAt(0);
        }
    }

    public String[] getNames() throws RemoteException {
        return new String[] { playerNames[0], playerNames[1] };
    }

    @Override
    public int getTurn() throws RemoteException {
        return turn;
    }

    @Override
    public boolean isGameStarted() throws RemoteException {
        return gameStarted;
    }

    @Override
    public boolean isMyTurn(int id) throws RemoteException {
        return (id == turn ? true : false);
    }

    @Override
    public String getName(int id) throws RemoteException {
        return (id == P1 ? playerNames[0] : playerNames[1]);
    }

    public int getWinner() throws RemoteException {
        return winner;
    }

    public char[][] getBoard() throws RemoteException {
        return boardTileMap;
    }

    public void setBoard(char[][] board) throws RemoteException {
        boardTileMap = board;
    }

    public int[] getScores() throws RemoteException {
        return new int[] { p1Score, p2Score };
    }
}
