import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize result array to store days until warmer temperature
        int[] res = new int[temperatures.length];
        // Stack stores pairs of [temperature, index] to track previous days
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            // While current temp is warmer than top of stack
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                // Pop and calculate days difference
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            // Add current day's temp and index to stack
            stack.push(new int[]{t, i});
        }
        return res;
    }
}