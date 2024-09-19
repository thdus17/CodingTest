import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /**
         * 1. progresses + speeds >> 앞에 있는 애가 100보다 크거나 같으면 해당 개수들 cnt해서 answer에 넣어주기
         * 2. progresses에 있는 값들이 다 사라지면 그 때 끝!
         */
        int[] answers = new int[progresses.length];

        int nowIdx = 0;
        int n = 0;
        while (nowIdx < progresses.length) {
            int cnt = 0;
            for (int i = nowIdx ; i < progresses.length ; i++) {
                if (progresses[i]<100) {
                    progresses[i] += speeds[i];
                }
            }
            for (int i = nowIdx ; i < progresses.length;i++) {
                if (progresses[i] >= 100) {
                    cnt ++;
                    nowIdx = i+1;
                } else {
                    break;
                }
            }

            if (cnt > 0) {
                answers[n] = cnt;
                n++;
            }
        }

        int[] answer = Arrays.copyOfRange(answers, 0, n);

        return answer;
    }
}