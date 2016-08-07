package recfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// https://rosettacode.org/wiki/Count_the_coins#Java
// https://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_Temp_52
class CountTheCoins {
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;


    private static Integer[] filterPossibles(int amount, Integer[] coins) {
        ArrayList<Integer> conisOk = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                conisOk.add(coins[i]);
        }
        return conisOk.toArray(new Integer[]{});
    }

    private static Integer countChanges(int amount, Integer[] coins) {
        coins = filterPossibles(amount, coins);

        final int n = coins.length;
        int cycleSum = 0;
        for (int c : coins)
            if (c <= amount && c >= cycleSum)
                cycleSum = c + 1;
        final int cycle = cycleSum * n;
        Integer[] table = new Integer[cycle];
        Arrays.fill(table, 0, n, ONE);
        Arrays.fill(table, n, cycle, ZERO);

        int pos = n;
        for (int s = 1; s <= amount; s++) {
            for (int i = 0; i < n; i++) {
                if (i == 0 && pos >= cycle)
                    pos = 0;
                if (coins[i] <= s) {
                    final int q = pos - (coins[i] * n);
                    table[pos] = (q >= 0) ? table[q] : table[q + cycle];
                }
                if (i != 0)
                    table[pos] = table[pos] + table[pos - 1];
                pos++;
            }
        }

        return table[pos - 1];
    }

    public static void printCount(int amount, Integer[] coins, Integer expected) {
        Integer result = countChanges(amount, coins);
        System.out.println(new StringBuilder()
                .append("amount = ")
                .append(amount)
                .append(", coins = ")
                .append(Arrays.toString(coins))
                .append(", result = ")
                .append(result)
                .append(" -> ")
                .append(Objects.equals(result, expected))
                .toString()
        );
    }

    public static void main(String[] args) {
//        printCount(4, new Integer[]{1, 2}, 3);
        printCount(4, new Integer[]{1, 2, 4}, 4);
//        printCount(4, new Integer[]{4, 2, 1}, 4);
//        printCount(4, new Integer[]{2, 4, 1}, 4);
//        printCount(4, new Integer[]{1, 2, 4}, 4);
//        printCount(4, new Integer[]{1, 2, 5}, 3);
//        printCount(300, new Integer[]{5, 10, 20, 50, 100, 200, 500}, 1022);
    }
}