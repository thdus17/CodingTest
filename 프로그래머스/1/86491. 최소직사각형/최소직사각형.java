import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        /*
* 1. 내부 배열 오름차순 정렬
* 2. 가로 길이만 뽑아내기
* 3. 세로 길이만 뽑아내기
* 3. 내림차순 정렬해서 각각 최대값 뽑기
*
* */
        List<List<Integer>> listSizes = new ArrayList<>();
        for (int[] size: sizes) {
            List<Integer> listSize = new ArrayList<>();
            listSize.add(Integer.valueOf(size[0]));
            listSize.add(Integer.valueOf(size[1]));
            listSizes.add(listSize);
        }

        Integer width = 0;
        Integer height = 0;
        if (listSizes.get(0).get(0) >listSizes.get(0).get(1)) {
            width = listSizes.get(0).get(0);
            height = listSizes.get(0).get(1);
        } else {
            width = listSizes.get(0).get(1);
            height = listSizes.get(0).get(0);
        }
        for (List<Integer> size: listSizes) {
            Collections.sort(size);
            width = width < size.get(1) ? size.get(1):width;
            height = height < size.get(0) ? size.get(0):height;
        }

        answer = width*height;
        return answer;
    }
}