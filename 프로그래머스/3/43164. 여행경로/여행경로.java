import java.util.*;
class Solution {
    String[] answer = {};
    ArrayList<String> pathList = new ArrayList<>();
    boolean[] isUsed = {};
    String[][] tickets = {{}};

    void DFS(String location, int depth, String path) {
        /**
         * 1. 수행작업
         *   - 출발지와 같으면 빼서 사용
         *   - used true 처리 및 path String에 값 추가  +  DFS 재귀호출
         *   - 다른 경우의 수도 구하기 위해 used false 처리로 백트래킹
         
         * 2. 종료조건
         *   - depth == tickets.length 
         *   pathList에 해당 배열 저장해주기
         */
        if (depth == tickets.length) {
            pathList.add(path);
            return;
        }

        for (int i = 0 ; i< tickets.length ; i++) {
            if (location.equals(tickets[i][0]) && !isUsed[i]) {
                isUsed[i] = true;
                DFS(tickets[i][1], depth+1, path + " " + tickets[i][1]);
                isUsed[i] = false;
            }
        }

    }
    public String[] solution(String[][] tickets) {
        /**
         * 모두 다 방문, 만약 가능한 경로 2개 이상일 경우,
         *  알파벳 순서 앞서는 경로를 우선. 
         >> 여기에서 여러 경우의 수가 나올 수도 있으니 pathList에 결과값을 다 담아야 하는 거였다 (놓친부분)
         *  항상 "ICN" 공항에서 출발
         *  여러 경로가 존재할 경우 알파벳이 빠른 게 우선되어야 하므로 정렬
         */
        answer = new String[tickets.length+1];
        isUsed = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        this.tickets = tickets;
        
        DFS("ICN", 0, "ICN");
        String[] answer = pathList.get(0).split(" ");

        return answer;
    }

}

