import java.util.*;
class Solution {
    boolean completed;
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        Map<String, Integer> ticket = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tickets.length; i++) {
            if(ticket.containsKey(tickets[i][0] + tickets[i][1])) {
                ticket.replace(tickets[i][0] + tickets[i][1], ticket.get(tickets[i][0] + tickets[i][1]) + 1);
            }else {
                ticket.put(tickets[i][0] + tickets[i][1], 1);
            }
        }
        for(int i = 0; i < tickets.length; i++) {
            if(map.containsKey(tickets[i][0])) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            }else {
                map.put(tickets[i][0], new ArrayList<>());
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        for(String s : map.keySet()) {
            map.get(s).sort((a,b) -> a.compareTo(b));
        }
        stack.add("ICN");
        dfs(map, ticket, stack, "ICN", answer);
        return answer;
    }
    void dfs(Map<String, List<String>> map, Map<String, Integer> ticket, Stack<String> stack, String from, String[] answer) {
        if(completed) {
            return;
        }
        boolean chk = false;
        for(String key : ticket.keySet()) {
            if(ticket.get(key) != 0) {
                chk = true;
                break;
            }
        }
        if(!chk) {
            stack.toArray(answer);
            completed = true;
            return;
        }
        if(map.containsKey(from)) {
            for(String to : map.get(from)) {
                if(ticket.containsKey(from + to) && ticket.get(from + to) > 0) {
                    ticket.replace(from + to, ticket.get(from + to) - 1);
                    stack.push(to);
                    dfs(map, ticket, stack, to, answer);
                    stack.pop();
                    ticket.replace(from + to, ticket.get(from + to) + 1);
                }
            }
        }
    }

}