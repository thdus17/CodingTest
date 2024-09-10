import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> pocketmons = new HashMap<>();
        for (int num : nums) {
            if (pocketmons.containsKey(num)) {
                pocketmons.put(num, pocketmons.get(num) + 1);
            } else {
                pocketmons.put(num, 1);
            }
        }

        answer = Math.min(nums.length / 2, pocketmons.size());

        return answer;
    }
}