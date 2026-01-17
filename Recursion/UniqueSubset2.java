package Recursion;
import java.util.*;

public class UniqueSubset2 {
    
    // Function to generate all unique subsets
    public void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Iterate over array from 'start' index
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in current subset
            current.add(nums[i]);

            // Recurse for next index
            backtrack(i + 1, nums, current, result);

            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        UniqueSubset2 obj = new UniqueSubset2();
        List<List<Integer>> ans = obj.subsetsWithDup(nums);

        for (List<Integer> subset : ans) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i != subset.size() - 1) System.out.print(",");
            }
            System.out.print("] ");
        }
        System.out.println();
        sc.close();
    }
}

