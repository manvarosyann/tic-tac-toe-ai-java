import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        long bestSeed = A;
        int minMax = Integer.MAX_VALUE;

        for (long seed = A; seed <= B; seed++) {
            Random rand = new Random(seed);
            int currentMax = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int next = rand.nextInt(K);
                currentMax = Math.max(currentMax, next);
            }

            if (currentMax < minMax) {
                minMax = currentMax;
                bestSeed = seed;
            } else if (currentMax == minMax && seed < bestSeed) {
                bestSeed = seed;
            }
        }

        System.out.println(bestSeed);
        System.out.println(minMax);
    }
}
