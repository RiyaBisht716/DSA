package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    // Function to find all combinations recursively
    public void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if we have considered all elements in the array
        if (ind == arr.length) {
            // If the target is zero, we have found a valid combination
            if (target == 0) {
                ans.add(new ArrayList<>(ds));  // Add the current combination to the result
            }
            return;
        }

        // Recursive case: pick the element if it's less than or equal to the target
        if (arr[ind] <= target) {
            ds.add(arr[ind]);  // Add the current element to the combination
            findCombination(ind, target - arr[ind], arr, ans, ds);  // Continue with the same index to allow repeated elements
            ds.remove(ds.size() - 1);  // Backtrack by removing the last added element
        }

        // Skip the current element and move to the next index
        findCombination(ind + 1, target, arr, ans, ds);
    }

    // Main function to get all combinations
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();  // To store the result
        List<Integer> ds = new ArrayList<>();  // To store a current combination
        findCombination(0, target, candidates, ans, ds);  // Start the recursive search
        return ans;  // Return all valid combinations
    }

    public static void main(String[] args) {
       
        int[] v = {2, 3, 6, 7};  // Candidate numbers
        int target = 7;  // Target sum
        CombinationSum1 obj = new CombinationSum1();
        // Get all combinations
        List<List<Integer>> ans = obj.combinationSum(v, target);

        // Output the combinations
        System.out.println("Combinations are: ");
        for (List<Integer> combination : ans) {
            for (int num : combination) {
                System.out.print(num + " ");  // Print each element of the combination
            }
            System.out.println();  // Print a newline after each combination
        }
    }
}
