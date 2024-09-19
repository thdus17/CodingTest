import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answers = new int[arr.length];
        int lastNum = arr[0];
        int i = 1;
        answers[0] = lastNum;
        for (int n : arr) {
            if (lastNum!= n) {
                answers[i] = n;
                lastNum = n;
                i ++;

            }
        }
        int[] answer = Arrays.copyOfRange(answers, 0, i);
        return answer;
    }
}