import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int h = n; h >= 0; h--) { // H-Index를 n부터 0까지 체크
            int finalH = h;
            int count = (int) Arrays.stream(citations).filter(x -> x >= finalH).count();

            // H-Index 조건 체크
            if (count >= h) {
                return h;
            }
        }
        return 0; // 모든 논문의 인용수가 0인 경우
    }
}