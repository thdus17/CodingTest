
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; 
        int currentWeight = 0; 
        Queue<Integer> bridge = new LinkedList<>(); 

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0); 
        }

        for (int truckWeight : truck_weights) {
            while (true) {
                currentWeight -= bridge.poll(); 

                if (currentWeight + truckWeight <= weight) {
                    bridge.add(truckWeight); 
                    currentWeight += truckWeight; 
                    time++; 
                    break;
                } else {
                    bridge.add(0);
                    time++; 
                }
            }
        }
        time += bridge_length;
        
        return time;
    }
}