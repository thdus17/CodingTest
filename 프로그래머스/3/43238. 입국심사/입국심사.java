import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * Arrays.stream(times).min().getAsInt(); 

        while (left < right) {
            long mid = (left + right) / 2; 
            long count = 0;

            
            for (int time : times) {
                count += mid / time; 
                if (count >= n) break; 
            }

            if (count >= n) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }

        return left; 
    }
    
}