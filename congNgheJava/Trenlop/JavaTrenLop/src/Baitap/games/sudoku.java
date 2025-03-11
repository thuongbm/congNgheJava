//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Baitap.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class sudoku {
    public sudoku() {
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9];
        GenerateBoard(board);
        RemoveCells(board, 40);
        System.out.println("Sudoku ban dau:");
        PrintBoard(board);
        Input(board);
        System.out.println("Sudoku sau khi nhap:");
        PrintBoard(board);
    }

    public static boolean GenerateBoard(int[][] board) {
        return SolveBoard(board);
    }

    public static boolean SolveBoard(int[][] board) {
        for(int row = 0; row < 9; ++row) {
            for(int col = 0; col < 9; ++col) {
                if (board[row][col] == 0) {
                    List<Integer> numbers = new ArrayList();

                    for(int i = 1; i <= 9; ++i) {
                        numbers.add(i);
                    }

                    Collections.shuffle(numbers);

                    for(int num : numbers) {
                        if (IsValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (SolveBoard(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static void RemoveCells(int[][] board, int count) {
        Random rand = new Random();

        for(int i = 0; i < count; ++i) {
            int row;
            int col;
            do {
                row = rand.nextInt(9);
                col = rand.nextInt(9);
            } while(board[row][col] == 0);

            board[row][col] = 0;
        }

    }

    public static void Input(int[][] board) {
        Scanner sc = new Scanner(System.in);

        while(!CheckBoard(board)) {
            System.out.print("Nhap toa do x (0-8): ");
            int x = sc.nextInt();
            System.out.print("Nhap toa do y (0-8): ");
            int y = sc.nextInt();
            if (x >= 0 && x < 9 && y >= 0 && y < 9) {
                if (board[x][y] == 0) {
                    int value;
                    do {
                        System.out.print("Nhap gia tri hop le (1-9) cho o [" + x + "][" + y + "]: ");
                        value = sc.nextInt();
                    } while(value < 1 || value > 9 || !IsValid(board, x, y, value));

                    board[x][y] = value;
                } else {
                    System.out.println("O nay da co gia tri khac 0. Vui long chon o khac.");
                }
            } else {
                System.out.println("Toa do khong hop le. Vui long nhap lai.");
            }
        }

    }

    public static boolean CheckBoard(int[][] board) {
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Boolean IsNumberInRow(int[][] board, int row, int value) {
        for(int i = 0; i < 9; ++i) {
            if (board[row][i] == value) {
                return true;
            }
        }

        return false;
    }

    public static Boolean IsNumberInCol(int[][] board, int col, int value) {
        for(int i = 0; i < 9; ++i) {
            if (board[i][col] == value) {
                return true;
            }
        }

        return false;
    }

    public static Boolean IsNumberInSquare(int[][] board, int row, int col, int value) {
        int StartRow = row - row % 3;
        int StartCol = col - col % 3;

        for(int i = StartRow; i < StartRow + 3; ++i) {
            for(int j = StartCol; j < StartCol + 3; ++j) {
                if (board[i][j] == value) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Boolean IsValid(int[][] board, int row, int col, int value) {
        return !IsNumberInRow(board, row, value) && !IsNumberInCol(board, col, value) && !IsNumberInSquare(board, row, col, value);
    }

    public static void PrintBoard(int[][] board) {
        for(int i = 0; i < 9; ++i) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }

            for(int j = 0; j < 9; ++j) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }

                if (board[i][j] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }

            System.out.println();
        }

    }
}
