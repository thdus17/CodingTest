
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[] priorities, int location) {
        Integer[] priorityArr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(priorityArr, Comparator.reverseOrder());

        boolean[] actFlag = new boolean[priorities.length];
        int cntIdx = 0;
        int actCnt = 0;

        while (true) {
            int idx = cntIdx!=0 ? cntIdx%priorities.length:0;
            if (priorityArr[actCnt] == priorities[idx] && !actFlag[idx]) {
                actCnt ++;
                actFlag[idx] = true;
                if (idx == location) {
                    break;
                }
            }
            cntIdx ++;
        }
        return actCnt;
    }
}