import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> types = new HashMap<>();
        
        // 각 의상의 종류를 카운트
        for (String[] cloth : clothes) {
            String type = cloth[1];
            types.put(type, types.getOrDefault(type, 0) + 1);
        }

        // 조합 수 계산
        for (int count : types.values()) {
            answer *= (count + 1); // 각 종류에서 선택할 수 있는 경우의 수
        }
        
        return answer - 1; // "모든 의상을 안 입는 경우"를 제외
    }
    
}