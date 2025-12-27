class Solution {

    int solve(int[] prices , int k , int idx , boolean canBuy){
        if(k == 0 || idx >= prices.length) return 0;
        
        int buy = 0;
        int notBuy = 0;
        int sell = 0;
        int notSell = 0;
        if(canBuy){
           buy = -prices[idx] + solve(prices , k , idx+1 , false);
           notBuy =  solve(prices , k , idx+1 , canBuy);
        } else {
           sell = prices[idx] + solve(prices , k - 1, idx+1 , true);
           notSell =  solve(prices , k , idx+1 , canBuy);
        }
       
       return Math.max( Math.max(buy , notBuy) , Math.max(sell , notSell) );

    }

    public int maxProfit(int k, int[] prices) {
        return solve(prices , k , 0 , true);
    }
}