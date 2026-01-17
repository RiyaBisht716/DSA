package arrays;

public class Maximumwealth {
    public static void main(String[] args) {
        
    }
     
    public int maximumWealth(int[][] accounts){
        //persons = row
        //account = col
        int ans = Integer.MIN_VALUE;
         
        /*ints is an array representing all the account balances for one person.*/

        for(int[] ints: accounts){
            //when you start a new col,take a new sum for that row
            int sum = 0;
            for(int anInt : ints){
                sum+= anInt;
            }
            //now we have sum of accounts of person
            //check with overall ans
            if(sum>ans){
                ans = sum;
            }
        }
        return ans;
    }
}
