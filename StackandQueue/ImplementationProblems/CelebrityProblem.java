package StackandQueue.ImplementationProblems;

class Celebrity{
    //celebrity:- joh insaan ko sab log jante hai but woh kisi ko nhi janta or ek matrix mai ek he celebrity ho sakta hai agar dusra hua toh woh celebrity thodena hua samjhe
    

    // Time Complexity:- O(2n) and space complexity :- O(1)
    public int celebrity(int[][] m){
        int n = m.length;

        int top = 0;
        int down = n-1;

        while(top<down){
            //agar top down ko janta hai top celebrity nhi hua
            if(m[top][down] == 1){
                top++;
            }
            //agar  down  top ko janta hai toh down celebrity nhi hua
            else if(m[down][top] == 1){
                down--;
            }
            //agar dono kisi ko nhi jante
            else{
                top++;
                down--;

            }

        }

        if(top > down){
            //koe celebrity he nhi hai
            return -1;
        }

        // Check if the person pointed by top is a celebrity
        for(int i=0;i<n;i++){
            if(i == top) continue;// person khud ko nhi janega skip kro khud ko compare krne se(diagonal element skip kro)
            // top celebrity nhi hai kyuki  woh janta hai but usko koe nhi janta
            if(m[top][i] == 1 && m[i][top] == 0){
                return -1;
            }
        }
        //return index of top
        return top;

    }
}



public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] m = {
            {0, 1, 1, 0}, 
            {0, 0, 0, 0}, 
            {1, 1, 0, 0}, 
            {0, 1, 1, 0}
        };

        Celebrity cel = new Celebrity();
        int res = cel.celebrity(m);

        // Print the result
        System.out.println("The index of the celebrity is: " + res);
        
    }


}
