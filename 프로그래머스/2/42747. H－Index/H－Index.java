import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        //논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
        Arrays.sort(citations); // 인용 수를 오름차순으로 정렬
        int n = citations.length;

        for (int h = 0; h <= n; h++) {
            // h편의 논문이 h번 이상 인용되었는지 확인
            if (h == n || citations[n - h-1] >= h) {
                return h; // H-Index 반환
            }
        }
        return 0; // 기본값 (모든 논문의 인용수가 0인 경우)
    }
}