import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        // Create stack to store numbers
        Stack<Integer> stack = new Stack<>();

        // Process each token from left to right
        for (String c : tokens) {
            if (c.equals("+")) {
                // Add top two numbers and push result
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                // Subtract in correct order (second - first pop)
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                // Multiply top two numbers and push result
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                // Divide in correct order (second / first pop)
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                // If token is a number, convert to integer and push
                stack.push(Integer.parseInt(c));
            }
        }
        // Return final result
        return stack.pop();
    }
}