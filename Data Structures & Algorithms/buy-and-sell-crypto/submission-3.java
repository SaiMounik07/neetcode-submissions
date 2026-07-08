class Solution {
    public int maxProfit(int[] prices) {
        int ma = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] >= 0) {
                ma = Math.max(prices[i + 1] - prices[i], ma);
                prices[i + 1] = prices[i];
            }
        }
        return ma;
    }
}
