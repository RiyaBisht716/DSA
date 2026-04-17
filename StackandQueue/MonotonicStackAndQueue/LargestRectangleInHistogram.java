package StackandQueue.MonotonicStackAndQueue;
import java.util.*;
class Solution{
    // Time complexity :- O(n) + O(n) ~ O(n)
    //Space Complexity:- O(n) for stack only

    public int LargestRectangleInHistogram(int [] heights){
        //store index of height of bar to maintain the increasing order of bar
        Stack<Integer> st = new Stack<>();
        // to find the max area 
        int maxArea = 0;
        int n = heights.length; 
        //traverse kr rhe hai har bar ke liye or sath mai he area bhi calculate kr rhe hai

        for(int i = 0;i<=n;i++){
            int currHeight = (i == n)? 0: heights[i];

            // ismain push and pop har element ke liye 1 he baar chl rha hai isliye (n count)

            while(!st.isEmpty() && heights[st.peek()]>= currHeight){
                int height = heights[st.pop()];
                int width = st.isEmpty()? i: i- st.peek() -1;

                maxArea = Math.max(maxArea, height * width);

            }

            // otherwise push the current elment into the stack
            st.push(i);

        }
        return maxArea;
    }

}

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] heights ={1,1,5,6,2,3,1};
        System.out.println("The largest area in the histogram is: " +sol.LargestRectangleInHistogram(heights));
        
    }
    
}
