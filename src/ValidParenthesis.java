import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        // Initialize empty stack
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Return true if stack is empty, false otherwise
        return stack.isEmpty();


    }
}
