import java.util.Scanner;

public class Triagle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap 3 canh cua: ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int sum = a + b +c;
        System.out.println(sum);
        
        scanner.close();
    }
}
