//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Baitap.games.sudokuP;

public class sudoku extends Sudoku1 {
    public static void main(String[] args) {
        int[][] board = new int[9][9];

        sudoku game = new sudoku(); // Tạo một đối tượng của lớp sudoku

        game.GenerateBoard(board);
        game.RemoveCells(board, 40);
        System.out.println("Sudoku ban dau:");
        game.PrintBoard(board);
        game.Input(board);
        System.out.println("Sudoku sau khi nhap:");
        game.PrintBoard(board);
    }

}
