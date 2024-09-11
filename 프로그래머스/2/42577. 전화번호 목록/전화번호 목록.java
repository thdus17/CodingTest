import java.util.*;
/**
1. 해시맵에 key값으로 전화번호 저장
2. 한 전화번호를 기준으로 (0~n) 문자열을 0-1~0-n-1으로 slicing하여 전화번호부 내에 그 값이 존재하는지 확인
3. 존재하면 바로 false 반환
*/
class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>();

        
        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i);
        
        
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 1; j < phone_book[i].length(); j++)
                if (map.containsKey(phone_book[i].substring(0, j)))
                    return false;

        return true;
    }
}