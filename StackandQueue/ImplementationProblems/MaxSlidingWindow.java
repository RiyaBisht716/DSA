package StackandQueue.ImplementationProblems;
import java.util.*;


class Solution{
    //Time Complexity: O(n) Each element is pushed and popped from the deque at most once, so overall traversal is linear.

//Space Complexity: O(k) Deque stores at most k elements at any time, one for each index in the window.
    public List<Integer> MaxSlidingWindow(int []arr, int k){
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;i++){


            // window out of bound mai hain

            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.pollFirst();
            }

            // maintain the decreasing order

            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }

            //add current element

            dq.offerLast(i);

            if(i >= k-1){
                ans.add(arr[dq.peekFirst()]);
            }
        }
        return ans;

    

    }
}
public class MaxSlidingWindow {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        List<Integer> ans = sol.MaxSlidingWindow(arr, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
    
}
