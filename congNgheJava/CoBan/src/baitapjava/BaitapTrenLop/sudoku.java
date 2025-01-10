package baitapjava.BaitapTrenLop;

import java.util.Scanner;

public class sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 2, 0, 8, 0, 1, 0, 5},
                {0, 0, 7, 2, 0, 0, 0, 6, 0},
                {5, 0, 8, 9, 0, 0, 0, 4, 7},
                {0, 8, 0, 4, 0, 0, 3, 0, 2},
                {0, 3, 0, 1, 6, 0, 0, 5, 8},
                {0, 1, 0, 5, 0, 0, 6, 7, 0},
                {0, 2, 0, 3, 4, 5, 0, 0, 1},
                {0, 0, 0, 0, 2, 6, 0, 0, 9},
                {0, 0, 0, 0, 9, 0, 5, 2, 6}
        };
        System.out.println("Sudoku ban dau:");
        PrintBoard(board);

        Input(board);

        System.out.println("Sudoku sau khi nhap:");
        PrintBoard(board);
    }

    public static void Input(int[][] board) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    int value;
                    do {
                        System.out.print("Nhap gia tri hop le (1-9) cho o [" + i + "][" + j + "]: ");
                        value = sc.nextInt();
                    } while (value < 1 || value > 9 || !IsValid(board, i, j, value));
                    board[i][j] = value;
                }
            }
        }
    }

    public static Boolean IsNumberInRow(int[][] board, int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return true;
        }
        return false;
    }

    public static Boolean IsNumberInCol(int[][] board, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) return true;
        }
        return false;
    }

    public static Boolean IsNumberInSquare(int[][] board, int row, int col, int value) {
        int StartRow = row - row % 3;
        int StartCol = col - col % 3;

        for (int i = StartRow; i < StartRow + 3; i++) {
            for (int j = StartCol; j < StartCol + 3; j++) {
                if (board[i][j] == value) return true;
            }
        }
        return false;
    }

    public static Boolean IsValid(int[][] board, int row, int col, int value) {
        return !IsNumberInRow(board, row, value)
                && !IsNumberInCol(board, col, value)
                && !IsNumberInSquare(board, row, col, value);
    }

    public static void PrintBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
