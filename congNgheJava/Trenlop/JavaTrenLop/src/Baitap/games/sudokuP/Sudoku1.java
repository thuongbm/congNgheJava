package Baitap.games.sudokuP;

import java.util.*;

import Baitap.games.sudokuP.Interact.Pair;
import Baitap.games.sudokuP.Interact.Redo;
import Baitap.games.sudokuP.Interact.Undo;

public class Sudoku1 implements Isudoku {
    private Redo redo = new Redo();
     private Undo undo = new Undo(redo);

    public boolean GenerateBoard(int[][] board) {
        return SolveBoard(board);
    }

    public boolean SolveBoard(int[][] board) {
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

    public void RemoveCells(int[][] board, int count) {
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

    public void Input(int[][] board) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap toa do x (0-8): ");
        int x = sc.nextInt();
        System.out.print("Nhap toa do y (0-8): ");
        int y = sc.nextInt();
        while (x < 0 || x > 8 || y < 0 || y > 8) {
            System.out.print("Nhap lai toa do x (0-8): ");
            x = sc.nextInt();
            System.out.print("Nhap lai toa do y (0-8): ");
            y = sc.nextInt();
        }

        undo.addUndo(x, y, board[x][y]);

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
    }

    public boolean CheckBoard(int[][] board) {
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public Boolean IsNumberInRow(int[][] board, int row, int value) {
        for(int i = 0; i < 9; ++i) {
            if (board[row][i] == value) {
                return true;
            }
        }

        return false;
    }

    public Boolean IsNumberInCol(int[][] board, int col, int value) {
        for(int i = 0; i < 9; ++i) {
            if (board[i][col] == value) {
                return true;
            }
        }

        return false;
    }

    public Boolean IsNumberInSquare(int[][] board, int row, int col, int value) {
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

    public Boolean IsValid(int[][] board, int row, int col, int value) {
        return !IsNumberInRow(board, row, value) && !IsNumberInCol(board, col, value) && !IsNumberInSquare(board, row, col, value);
    }

    public void PrintBoard(int[][] board) {
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

    public void Delete(int[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap toa do x (0-8): ");
        int x = scanner.nextInt();
        System.out.println("Nhap toa do y (0-8): ");
        int y = scanner.nextInt();
        if (board[x][y] != 0) {
            undo.addUndo(x, y, board[x][y]);
            board[x][y] = 0;
        } else {
            System.out.println("O nay da rong.");
        }
    }

    public void UndoGame(int [][] board) {
        Pair<int[][], Integer> undoData = undo.getLastUndo();
        if (undoData != null) {
            int posX = undoData.getKey()[0][0];
            int posY = undoData.getKey()[0][1];
            int value = undoData.getValue();

            board[posX][posY] = value;

            PrintBoard(board);
        } else {
            System.out.println("Khong co thao tac hoan tac nao de thuc hien.");
        }
    }

    public void Redo(int[][] board) {
        Pair <int[][], Integer> redoData = redo.getLastRedo();
        if (redoData != null) {
            int posX = redoData.getKey()[0][0];
            int posY = redoData.getKey()[0][1];
            int value = redoData.getValue();

            board[posX][posY] = value;

            PrintBoard(board);
        } else {
            System.out.println("Khong co thao tac redo nao de thuc hien.");
        }
    }
}