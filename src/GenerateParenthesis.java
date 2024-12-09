import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        // Create list of lists to store results for 0 to n pairs of parentheses
        List<List<String>> res = new ArrayList<>();

        // Initialize empty lists for each number of pairs from 0 to n
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }

        // Base case: empty string for 0 pairs
        res.get(0).add("");

        // For each number of pairs k
        for (int k = 0; k <= n; k++) {
            // Try splitting k pairs between left and right parts
            for (int i = 0; i < k; i++) {
                // For each valid string with i pairs (left part)
                for (String left : res.get(i)) {
                    // For each valid string with k-i-1 pairs (right part)
                    for (String right : res.get(k - i - 1)) {
                        // Combine: (left)right
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }

        // Return all valid combinations for n pairs
        return res.get(n);
    }
}