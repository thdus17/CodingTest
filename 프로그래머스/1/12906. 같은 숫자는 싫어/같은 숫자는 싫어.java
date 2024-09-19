import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> tmpList = new ArrayList<>();
        int lastNum = arr[0];
        tmpList.add(lastNum);
        for (int num: arr) {
            if (lastNum != num) {
                tmpList.add(num);
                lastNum = num;
            }
        }

        int[] answer = new int[tmpList.size()];
        for (int i=0;i<tmpList.size();i++) {
            answer[i] = tmpList.get(i).intValue();
        }
        return answer;
    }
}