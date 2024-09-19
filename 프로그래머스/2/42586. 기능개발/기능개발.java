import java.util.*;
class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
      int[] answer = {};
        int[] dayArr = new int[progresses.length];
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            int pgs = 100 - progresses[i];
            int day = pgs/speeds[i] + (pgs%speeds[i] > 0 ? 1: 0);
            dayArr[i] = day;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(dayArr[0]);

        for(int i=1; i<dayArr.length; i++) {
            int target = dayArr[i];
            if(target <= queue.peek()) {
                queue.add(target);
            }else {
                int cnt = 0;
                while(!queue.isEmpty()) {
                    queue.poll();
                    cnt++;
                }
                answerList.add(cnt);

                queue.add(target);
            }
        }

        if(!queue.isEmpty()) {
            int cnt = 0;
            while(!queue.isEmpty()) {
                queue.poll();
                cnt++;
            }
            answerList.add(cnt);
        }

        answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
  }
}