import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        /*
* 1. 내부 배열 오름차순 정렬
* 2. 가로 길이만 뽑아내기
* 3. 세로 길이만 뽑아내기
* 3. 내림차순 정렬해서 각각 최대값 뽑기
*
* */
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}