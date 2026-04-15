package StackandQueue.MonotonicStackAndQueue;
import java.util.*;


class Solution{

    // Time Complexity :- O(n + n)= O(2n)
    //space Complexity :- O(n) + O(n) // stack and res array

    public int [] nextGreaterElement1(int[]arr){

        Stack<Integer> st = new Stack<>(); // store next greater element
        int n = arr.length;
        int [] res = new int[n];


        for(int i= n-1;i>=0;i--){
            // remove all choti value hata do j
            while( !st.empty() && st.peek() <= arr[i]){
                st.pop();

            }

            // agar khali toh -1 kr do
            if(st.empty()){
                res[i] = -1;
            }
            // top element daal do

            else{
                res[i] = st.peek();
            }
            // current element daal do
            st.push(arr[i]);

            // add kr do element stack mai
        }
        // print result
        return res;
    }
}

public class NextGreaterElement1 {
    public static void main(String[] args){
        int[] n1 = {4,1,2};
        //create a object
        Solution sol = new Solution();
        int [] ans = sol.nextGreaterElement1(n1);

        for( int x: ans){
            System.out.print(x + " ");

        }
        System.out.println();
    }
    
}
