package hocTrenLop.buoi1.buoi2;

import java.util.Random;
import java.util.Scanner;

public class BanTau {
    public static final int SIZE = 10;
    public static int NUMBER_BATTER = 9;
    public static int NUMBER_FIGHT = 9;

    public static void main(String[] args) {
        int[][] game = generateMatrix(SIZE, SIZE, 0.2);
        play(game);
    }

    public static void show(int[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == -2 || game[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(game[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void fight(int[][] game, int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Vị trí không hợp lệ!");
            return;
        }

        if (game[x][y] == -1) {
            game[x][y] = 10;
            NUMBER_BATTER--;
        } else {
            game[x][y] = count(game, x, y);
            NUMBER_FIGHT--;
        }
    }

    public static int count(int[][] game, int x, int y) {
        int cnt = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(SIZE - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(SIZE - 1, y + 1); j++) {
                if (game[i][j] == -1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int getStatus() {
        if (NUMBER_BATTER == 0) return 1;
        if (NUMBER_FIGHT == 0) return -1;
        return 0;
    }

    public static void play(int[][] game) {
        Scanner sc = new Scanner(System.in);
        System.out.println("XIN MỜI CHƠI GAME");
        while (true) {
            show(game);

            System.out.print("x = ");
            int x = sc.nextInt() - 1;
            System.out.print("y = ");
            int y = sc.nextInt() - 1;

            fight(game, x, y);
            int st = getStatus();

            if (st == 1) {
                System.out.println("YOU WIN");
                break;
            }
            if (st == -1) {
                System.out.println("YOU LOSE");
                break;
            }
        }
        sc.close();
    }

    public static int[][] generateMatrix(int rows, int cols, double negativeOneProbability) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (rand.nextDouble() < negativeOneProbability) ? -1 : -2;
            }
        }
        return matrix;
    }
}
