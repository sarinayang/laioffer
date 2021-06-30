import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CoinComb {
    public static void main(String[] args) throws Exception {
        // case when
        int[] coins = {25, 10, 5, 1};
        int money = 10;
        // expected
        int[][] expected_result = {{0,1,0,0}, {0,0,2,0}, {0,0,1,5}, {0,0,0,10}};
        
        
        // then 
        int[] solution = {0, 0, 0, 0};
        List<int[]> actual_results = new ArrayList<>();
        CoinComb cc = new CoinComb();
        cc.findCombination(coins, money, 0, solution, actual_results);

        // check
        System.out.println(String.format("Found solutions for total money %d", money));
        for(var item : actual_results) {
            System.out.println(Arrays.toString(item));
        }
        
        if (expected_result.length != actual_results.size()) {
            throw new Exception("results not same as expected");
        }

        for (var a_re: actual_results) {
            Boolean matched = false;
            for(var e_re : expected_result) {
                if(Arrays.equals(a_re, e_re)) {
                    matched = true;
                }
            }

            if(!matched) {
                throw new Exception("actual results not same as expected");
            }
        }
    }

    public void findCombination(int[] coins, int moneyLeft, int index, int[] sol, List<int[]> results) {

        if(index == coins.length) {
            if(moneyLeft == 0) {
                results.add(Arrays.copyOf(sol, sol.length));
            }

            return;
        }
        
        int coin = coins[index];
        for(int i = 0; i <= moneyLeft/coin; ++i) {
            sol[index] = i;
            findCombination(coins, moneyLeft - i*coin, index + 1, sol, results);
        }
    }
}
