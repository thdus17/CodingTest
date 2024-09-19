import java.util.Stack;
class Solution {
    boolean solution(String s) {
        /**
         * 1. stack에 하나씩 잘라서 넣기
         * 2. 만약 넣는 게 ) 닫힌 괄호면 pop 두 번하기
         * 3. 만약 pop 두 번이 불가하면 answer = false; break;
         * 4.
         */
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); 
            } else {
                if (stack.isEmpty()) {
                    return false; 
                }
                stack.pop(); 
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 모든 괄호가 짝이 맞음
    }
}