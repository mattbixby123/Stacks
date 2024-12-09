import java.util.Stack;

public class largestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // Get length of input array
        int n = heights.length;
        // Arrays to store indices of first smaller height on left and right
        int[] leftMost = new int[n];  // leftMost[i] = first smaller bar on left of i
        int[] rightMost = new int[n]; // rightMost[i] = first smaller bar on right of i
        // Stack to keep track of indices of increasing heights
        Stack<Integer> stack = new Stack<>();

        // Find first smaller bar on left for each position
        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;  // Default to -1 (no smaller bar on left)
            // Pop bars from stack that are >= current height
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack not empty, top has first smaller height
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack for reuse
        stack.clear();
        // Find first smaller bar on right for each position
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;  // Default to n (no smaller bar on right)
            // Pop bars from stack that are >= current height
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack not empty, top has first smaller height
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate maximum area possible
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Adjust boundaries to include current bar
            leftMost[i] += 1;
            rightMost[i] -= 1;
            // Calculate area with current height extending from leftMost to rightMost
            // Width = rightMost - leftMost + 1
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
        return maxArea;
    }
}