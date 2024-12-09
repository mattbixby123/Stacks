import java.util.Arrays;
import java.util.Stack;

public class carFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // Create array of pairs to store position and speed together
        int[][] pair = new int[position.length][2];
        // Fill the pairs array with position and speed values
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort pairs by position in descending order (rightmost cars first)
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack will store time to reach target for each car
        Stack<Double> stack = new Stack<>();

        // Process each car from right to left
        for (int[] p : pair) {
            // Calculate time needed to reach target for current car
            stack.push((double) (target - p[0]) / p[1]);

            // If current car (top of stack) reaches target earlier or at same time
            // as car in front, they form a fleet (remove current car)
            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }

        // Number of elements in stack represents number of fleets
        return stack.size();
    }
}