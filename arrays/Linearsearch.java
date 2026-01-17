package arrays;

public class Linearsearch{
    public static void main(String[] args) {

        int[] nums = {12,34,56,78,90};
        int target = 56;
        int ans = LinearSearch(nums,target);
        System.out.println(ans);
        
    }
    //search in the array return the index if item is found
    //otherwise if item is not found return -1;

    static int LinearSearch(int[] arr,int target){
        if(arr.length == 0){
            return -1;

        }
        //run for loop
        for(int index=0;index<arr.length;index++){    
            //check for a element at every index if it is a target
            int element = arr[index];
            if(element == target){
                return index;

            }   
        }
        //This line will execute if none of the return statement;
        return -1;
    

    }

}
