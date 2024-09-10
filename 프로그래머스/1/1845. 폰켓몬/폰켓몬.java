import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> pocketmons = new HashSet<>();
        for (int num : nums) {
            pocketmons.add(num);
        }

        answer = Math.min(nums.length / 2, pocketmons.size());

        return answer;
    }
}