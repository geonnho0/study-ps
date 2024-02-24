import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            int next = prices[i];
            while (!stack.isEmpty() && stack.peek().price > next) {
                Stock stock = stack.pop();
                answer[stock.index] = i - stock.index;
            }
            stack.push(new Stock(i, next));
        }
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.index] = prices.length - stock.index - 1;
        }
        return answer;
    }
}

class Stock {
    int index, price;
    
    public Stock(int index, int price) {
        this.index = index;
        this.price = price;
    }
}