import java.util.Arrays;


public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        /**
         * 바위 사이 거리들 중 최소값이지만 그 중에서 제일 최대값
         * 조건
         * distance는 1 이상 1,000,000,000 이하
         * 바위는 1개 이상 50,000개 이하
         * n 은 1 이상 바위의 개수 이하
         *
         * 돌 사이 간격 배열에 미리 저장!
         * 초기 left = 1 right = 길이
         * mid를 설명할 때 임의로 돌을 제거한 돌들 간격의 최소거리라고 가정
         * mid값 보다 돌 사이 간격이 작으면 돌 빼기 >> 이걸 cnt 그리고 mid 값 이상이라면 둘 사이 간격 +추가값 변수 0으로 리셋
         * 제거한 개수가 n보다 크면 right 값을 mid-1로 변경
         * 제거한 개수가 n과 같은 때, 제거한 개수가 더 작을 때를 같이 묶어서 고려 (중요)
         * 제거한 개수 < n의 경우, mid값을 증가시켜야 함 left = mid + 1
         * 제거한 개수 == n의 경우에도 마찬가지로 처리, 대신 answer에 저장해두기
         * 즉, 현재 mid값에서 제거한 갯수 == n이 더라도
         * 이 mid값이 n개만큼 돌을 제거하였을 때 가질 수 있는 돌 사이 최소 간격의 최대값임을 보장할 수는 없다는 것이다.
         * 따라서 이 경우에도 mid값을 더 크게하여 이진탐색을 진행하여야 한다.
         *
         */

        int answer = 0;

        Arrays.sort(rocks);
        int left = 1;
        int right = distance;

        int[] difByrock = new int[rocks.length+1];
        difByrock[0] = rocks[0];
        difByrock[rocks.length] = distance - rocks[rocks.length-1];
        for (int i = 1; i< rocks.length ; i++) {
            difByrock[i] = rocks[i] - rocks[i-1];
        }

        

        while (left <= right) {
            int removed = 0;
            int tmpDif = 0;
            int mid = (left + right) / 2;
            for (int i = 0; i < difByrock.length; i++) {
                tmpDif += difByrock[i];
                if (tmpDif < mid) {
                    removed++;
                    continue;
                }
                tmpDif = 0;
            }
            if (removed > n) {
                right = mid-1;
            } else {
                left = mid+1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }
}
