import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("输入数的范围");
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // 将 i 的倍数标记为非质数
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 输出
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.printf("%4d", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n\n总共" + count);
    }
}