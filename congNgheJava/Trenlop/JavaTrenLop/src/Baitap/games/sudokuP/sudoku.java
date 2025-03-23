//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Baitap.games.sudokuP;

import Baitap.games.sudokuP.Sudoku1;

public class sudoku {
    public static void main(String[] args) {
        int[][] board = new int[9][9];

        Sudoku1 game = new Sudoku1(); // Tạo một đối tượng của lớp sudoku

        game.GenerateBoard(board);
        game.RemoveCells(board, 40);
        System.out.println("Sudoku ban dau:");
        game.PrintBoard(board);
        game.Input(board);
        System.out.println("Sudoku sau khi nhap:");
        game.PrintBoard(board);
    }

}
