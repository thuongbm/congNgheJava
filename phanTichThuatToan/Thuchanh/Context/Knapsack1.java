import java.util.Random;

public class Knapsack1 {
    
    private static int[] profit;
    private static int[] weight;
    private static int[][] opt;
    private static boolean[][] sol;

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);   // số lượng đồ vật
        int W = Integer.parseInt(args[1]);   // trọng lượng tối đa của balo

        // Khởi tạo mảng lợi nhuận và trọng lượng
        profit = new int[N + 1];
        weight = new int[N + 1];
        opt = new int[N + 1][W + 1];
        sol = new boolean[N + 1][W + 1];

        generateItems(N, W);
        solveKnapsack(N, W);
        boolean[] take = getSelectedItems(N, W);
        printResults(N, take);
    }
    
    // Tạo dữ liệu đầu vào ngẫu nhiên
    private static void generateItems(int N, int W) {
        Random rand = new Random();
        for (int n = 1; n <= N; n++) {
            profit[n] = rand.nextInt(1000);
            weight[n] = 1 + rand.nextInt(W);
        }
    }
    
    // Giải bài toán knapsack bằng lập trình động
    private static void solveKnapsack(int N, int W) {
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                int option1 = opt[n - 1][w]; // Không chọn vật phẩm n
                int option2 = (weight[n] <= w) ? profit[n] + opt[n - 1][w - weight[n]] : Integer.MIN_VALUE;
                
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }
    }
    
    // Xác định các vật phẩm được chọn
    private static boolean[] getSelectedItems(int N, int W) {
        boolean[] take = new boolean[N + 1];
        int w = W;
        for (int n = N; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w -= weight[n];
            }
        }
        return take;
    }
    
    // In kết quả ra màn hình
    private static void printResults(int N, boolean[] take) {
        System.out.println("item\tprofit\tweight\ttake");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
        }
    }
}
