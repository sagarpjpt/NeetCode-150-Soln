class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice,currentProfit=0,maxProfit=0;
        buyPrice = prices[0];
        for(int i =1;i<prices.length;i++){
            //if price on next day smaller than bought price then buy the stock at that smaller price
            if(prices[i]<buyPrice) buyPrice = prices[i];
            //if price on next day greater than bought price then only sell the stock
            else{ 
                currentProfit = prices[i] - buyPrice;
                maxProfit = (maxProfit < currentProfit) ? currentProfit : maxProfit;
            }
        }
        return maxProfit;
    }
}
