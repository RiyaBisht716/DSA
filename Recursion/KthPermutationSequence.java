package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        // Calculate factorial of n-1
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);  // Add last element (n)
        
        StringBuilder ans = new StringBuilder();
        k = k - 1;  // Convert k to 0-based index
        
        while (true) {
            ans.append(numbers.get(k / fact));  // Add the digit at the position
            numbers.remove(k / fact);  // Remove that number from the list
            
            if (numbers.isEmpty()) {
                break;  // Exit when all numbers are used
            }

            k = k % fact;  // Reduce k to fit within the remaining sub-permutation
            fact = fact / numbers.size();  // Update factorial for the remaining numbers
        }
        
        return ans.toString();  // Return the Kth permutation sequence
    }



    public static void main(String[] args) {
        int n = 3, k = 3;
        KthPermutationSequence obj = new KthPermutationSequence();
        String ans = obj.getPermutation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}

