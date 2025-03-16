package Baitap.games.BattleShipP;

import java.util.Random;
import java.util.Scanner;

public class BattleShip {
    public static int SIZE = 10;
    public static int NUM_BATTLE = 10;
    public static int NUM_FIGHT = 1;

    // Function 1
    public static void show(int game[][], boolean isCheat) {
        System.out.println("BATTLE GAME - FIGHTING NOW");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCheat) {
                    System.out.print(game[i][j] + "\t");
                } else {
                    if (game[i][j] == -1 || game[i][j] == -2) {
                        System.out.print("*\t");
                    } else {
                        System.out.print(game[i][j] + "\t");
                    }
                }
            }
            System.out.println();
        }
    }

    // Function 2
    public static int count(int[][] game, int x, int y) {
        int c = 0;
        int xlow = x > 0 ? x - 1 : 0;
        int xup = x < SIZE - 1 ? x + 1 : SIZE - 1;
        int ylow = y > 0 ? y - 1 : 0;
        int yup = y < SIZE - 1 ? y + 1 : SIZE - 1;
        for (int i = xlow; i <= xup; i++) {
            for (int j = ylow; j <= yup; j++) {
                if (game[i][j] == -1) {
                    c++;
                }
            }
        }
        return c;
    }

    // Function 3
    public static void fight(int[][] game, int x, int y){
        if(game[x][y] == -1){
            game[x][y] = 10;
            NUM_BATTLE --;
        }
        else{
            game[x][y] = count(game, x, y);
        }
        NUM_FIGHT --;
    }

    // Function 4
    public static int getStatus(){
        if (NUM_BATTLE == 0){
            return 1;
        }
        if (NUM_FIGHT == 0){
            return -1;
        }
        return 0;
    }

    // Function 5
    public static void play(int game[][]){
        Scanner sc = new Scanner(System.in);
        System.out.println("XIN MOI BAN CHOI GAME");
        init(game);
        while(true){
            // Step 1: show
            show(game, false);
            // Step 2: input
            System.out.print("x = ");
            int x = sc.nextInt() - 1;
            System.out.print("y = ");
            int y = sc.nextInt() - 1;
            // Step 3: fight
            fight(game, x, y);
            // Step 4: check
            int status = getStatus();
            if (status == 1){
                System.out.println("Cong. You win!");
                break;
            }
            if (status == -1){
                System.out.println("Ops. You lose!");
                break;
            }
        }
        sc.close();
    }

    // Function ++
    public static void init(int game[][]){
        int count = 0;
        // Init game
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                game[i][j] = -2;
            }
        }
        // Random game
        Random random = new Random();
        while (count < NUM_BATTLE){
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (game[x][y] != -1){
                game[x][y] = -1;
                count ++;
            }
        }

        show(game, true);
    }

    public static void main(String[] args) {
        int game[][] = { { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 }, { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 },
                { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 }, { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 },
                { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 }, { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 },
                { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 }, { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 },
                { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 }, { -2, -1, -2, -2, -2, -2, -2, -2, -2, -2 } };

        play(game);
    }

}
