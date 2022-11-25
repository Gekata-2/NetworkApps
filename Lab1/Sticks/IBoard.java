package Sticks;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBoard extends Remote {
    int[][] getSticks() throws RemoteException;

    int[][] getSquares() throws RemoteException;

    String[] getNames() throws RemoteException;

    String getName(int id) throws RemoteException;

    int getWinner() throws RemoteException;

    char[][] getBoard() throws RemoteException;

    int[] getScores() throws RemoteException;

    int getTurn() throws RemoteException;

    int getTotalScore() throws RemoteException;

    void setSticks(int[][] s) throws RemoteException;

    void setSquares(int[][] s) throws RemoteException;

    void setNames(String p1, String p2) throws RemoteException;

    void setBoard(char[][] board) throws RemoteException;

    void FillInBoard() throws RemoteException;

    void PrintBoard() throws RemoteException;

    void PrintHint() throws RemoteException;

    void Print() throws RemoteException;

    void PrintSquares() throws RemoteException;

    boolean MakeMove(int x, int y) throws RemoteException;

    boolean checkSquareLeft(int x, int y) throws RemoteException;

    boolean checkSquareRight(int x, int y) throws RemoteException;

    boolean checkSquareUpper(int x, int y) throws RemoteException;

    boolean checkSquareDown(int x, int y) throws RemoteException;

    boolean checkSquare(int x, int y) throws RemoteException;

    boolean checkWinner() throws RemoteException;

    void changeTurn() throws RemoteException;

    int register(String name) throws RemoteException;

    boolean isGameStarted() throws RemoteException;

    boolean isMyTurn(int id) throws RemoteException;

}
