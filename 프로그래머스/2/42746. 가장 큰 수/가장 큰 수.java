import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> strArr = new ArrayList<>();
        for (Integer num: numbers) {
            String tmp = Integer.toString(num);
            strArr.add(tmp);
        }
        Collections.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        
        if (strArr.get(0).equals("0")) {
            return "0";
        }
        
        for (String num: strArr) {
            answer += num;
        }
        return answer;
    }
}
