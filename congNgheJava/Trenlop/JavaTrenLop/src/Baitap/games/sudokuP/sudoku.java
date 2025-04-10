//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Baitap.games.sudokuP;

import Baitap.games.sudokuP.Sudoku1;

import java.util.Scanner;


public class sudoku {
    public static void main(String[] args) {
        int[][] board = new int[9][9];

        Sudoku1 game = new Sudoku1(); // Tạo một đối tượng của lớp sudoku

        game.GenerateBoard(board);
        game.RemoveCells(board, 40);
        System.out.println("Sudoku ban dau:");
        game.PrintBoard(board);
        System.out.println("Menu:\n1. Nhap so\n2. Xoa so\n3. Hoan tac\n4. Hien bang\n5. Kho phuc\n6. Thoat");
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Lua chon: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    game.Input(board);
                    break;
                case 2:
                    game.Delete(board);
                    break;
                case 3:
                    game.UndoGame(board);
                    break;
                case 4:
                    game.PrintBoard(board);
                    break;
                case 5:
                    game.Redo(board);
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (true);
    }
}
