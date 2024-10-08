import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int[] solution(int[] prices) {
        /**
         * 1. 맨 마지막은 무조건 0
         * 2. que 사용 poll 로 맨 앞 당기고 그 값을 que 뒤의 값들과 >= 개수 체크
         *
         */
        int[] answer = new int[prices.length];
        Queue<Integer> stock = new ArrayDeque<>();
        for (int n : prices) {
            stock.add(n);
        }

        int nowIdx = 1;
        int target = stock.poll();
        while (!stock.isEmpty()) {
            int sec = 0;
            for (int i = nowIdx; i < prices.length; i++) {
                sec++;
                if (prices[i]-target < 0) {
                    break;
                }
            }
            answer[nowIdx-1] = sec;
            nowIdx++;
            target = stock.poll();
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}