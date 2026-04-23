package StackandQueue.ImplementationProblems;
import java.util.*; 

//Time Complexity: O(N), since finding the indices of previous greater elements takes O(N) time and we traverse the array once to compute the stock span, that takes O(N) as well.

//Space Complexity: O(N), the stack space used to find the previous greater elements can go up to O(N) in the worst case.
class Solution{
    private int[] findPGE(int []arr){
        int n = arr.length;
        //to store the pge
        int [] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            int curr = arr[i];
            
            while(!st.isEmpty() && arr[st.peek()]<= curr){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;

            }
            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;

    }


    public int[] stockSpan(int []arr, int n){
        int [] pge = findPGE(arr);

        int ans [] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = i - pge[i];
        }
        return ans;
    }

}


public class StockSpan {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {120, 100, 60, 80, 90, 110, 115}; // Stock prices for each day

        // Create an instance of the Solution class
        Solution sol = new Solution(); 
        
        // Call the function to find the stock span for each day
        int[] ans = sol.stockSpan(arr, n);
        
        // Print the result
        System.out.print("The span of stock prices is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " "); // Display the span of each day
        }
    }
}
