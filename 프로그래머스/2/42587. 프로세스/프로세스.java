
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[] priorities, int location) {
        /**
         * 1. copy 후 내림차순 정렬해서 max값 차례로 꺼내 쓰는 것으로
         * 2. actCnt=0 (실행몇번째인지) cntIdx = 0 (idx 체크용) >> n으로 나눈 나머지값이 인덱스값, cnt 0일 때만 예외처리
         *    actFlag[] (해당 idx 실행시킨 작업인지 체크용) 
         * 3. 
         * 4. prioritiesArr[actCnt] == priority[idx]일 때 actCnt++, actFlag[idx] = true처리
         * 4-1. 같을 때 location == idx 면 break;
         */

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