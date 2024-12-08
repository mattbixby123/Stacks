import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s) {
        // create an empty stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the input string
        for (char c: s.toCharArray()) {

            // If the char is an open bracket ('(' or '{' or '[')
            if (c == '(' || c == '{' || c == '[' ) {
                // Push the character
                stack.push(c);
                // If a closing bracket is iterated upon,
            } else {
                // empty stack would mean there is no opening bracket for the closing bracket
                if (stack.isEmpty()) return false;
                // if stack isnt empty we get the most recent bracket
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        // if the stack can empty, true is returned
        return stack.isEmpty();
    }
}