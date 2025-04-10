package Baitap.games.sudokuP;

public interface Isudoku {
    boolean GenerateBoard(int[][] board);
    boolean SolveBoard(int[][] board);
    void RemoveCells(int[][] board, int count);
    void Input(int[][] board);
    void PrintBoard(int[][] board);
    Boolean IsValid(int[][] board, int row, int col, int num);
    boolean CheckBoard(int[][] board);
    void UndoGame(int[][] board);
}
