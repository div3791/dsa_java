import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst)
            return 0;
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] distances = Arrays.copyOf(prices, prices.length);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (prices[from] == Integer.MAX_VALUE)
                    continue;
                if (prices[from] + cost < distances[to])
                    distances[to] = prices[from] + cost;
            }
            prices = distances;
        }
        int price = prices[dst];
        return price == Integer.MAX_VALUE ? -1 : price;
    }
}
