/**
     * 1. 종류(1)를 키값으로 의상 이름 배열에 저장하기 hashMap
     * 2. 최소 1개의 의상은 장착. 1개~n개(의상 종류) 장착할 경우로 계산하기
     * 3. 1개 장착할 경우, 모든 제품 개수
     * 4. 종류 n개 장착할 경우... 흠 각 종류의 제품 개수끼리 곱하면 됨
     * @return
     */

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