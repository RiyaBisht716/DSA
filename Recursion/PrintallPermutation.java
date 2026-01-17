package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintallPermutation {
    // Helper function to generate permutations using backtracking
    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // If current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate over all elements
        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Include this element
            used[i] = true;
            current.add(nums[i]);

            // Recurse for next element
            backtrack(nums, used, current, result);

            // Backtrack: remove element and mark unused
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // Function to return all permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, current, result);
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PrintallPermutation sol = new PrintallPermutation();

        // Get all permutations
        List<List<Integer>> permutations = sol.permute(nums);

        // Print all permutations
        for (List<Integer> perm : permutations) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
