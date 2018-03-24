import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class p01_sumOfCoins {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(reader.readLine().substring(5));

        try {
            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
            System.out.println(String.format("Number of coins to take: %d", usedCoins.values().stream().mapToInt(Integer::intValue).sum()));
            for (Map.Entry<Integer, Integer> entry : usedCoins.entrySet()) {
                System.out.println(String.format("%d coin(s) with value %d", entry.getValue(), entry.getKey()));
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Error");
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {

        int[] sortedCoins = Arrays
                .stream(coins)
                .boxed()
                .sorted((i1, i2) -> Integer.compare(i2, i1))
                .mapToInt(Integer::intValue)
                .toArray();
        Map<Integer, Integer> result = new LinkedHashMap<>();
        int currentSum = 0;
        int remainSum = targetSum;

        for (int currentCoin : sortedCoins) {
            if (currentSum + currentCoin > targetSum) {
                continue;
            }

            int countOfCurrentCoin = remainSum / currentCoin;

            if (countOfCurrentCoin > 0) {
                result.put(currentCoin, countOfCurrentCoin);
                currentSum += currentCoin * countOfCurrentCoin;
                remainSum -= currentCoin * countOfCurrentCoin;
            }
        }

        if (currentSum < targetSum) {
            throw new IllegalArgumentException("Target sum is not reached!!!");
        }

        return result;
    }
}
