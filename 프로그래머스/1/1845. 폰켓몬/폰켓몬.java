import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> answerKey = new HashMap<>();
        HashMap<Integer, Integer> pocketmons = new HashMap<>();
        for (int num: nums) {
            if (pocketmons.containsKey(num)) {
                pocketmons.put(num, pocketmons.get(num)+1);
            } else {
                pocketmons.put(num, 1);
            }
        }

        final int[] takingCnt = {nums.length / 2};
        if (takingCnt[0] <= pocketmons.size()) {
            return takingCnt[0];
        }
        while (takingCnt[0] > 0) {
            pocketmons.forEach( (key, value) -> {
                if (value != 0) {
                    takingCnt[0] -= 1;
                    pocketmons.put(key, value-1);
                    if (!answerKey.containsKey(key)) {
                        answerKey.put(key, 1);
                    } else {
                        answerKey.put(key, answerKey.get(key)+1);
                    }
                }
            });
        }
        answer = answerKey.size();
        return answer;
    }
}