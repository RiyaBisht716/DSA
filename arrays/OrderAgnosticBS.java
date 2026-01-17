package arrays;

public class OrderAgnosticBS {
    public static void main(String[] args) {
         int [] arr ={-14,-5,-4,0,12,34,56,78};
        int target = 78;
        int ans = orderAgnosticBS(arr,target);
        System.out.println(ans);
        
        
    }

    static int orderAgnosticBS(int [] arr, int target){
        int start =0;
        int end = arr.length-1;
        
        //check whether the array is sort in ascending or descending
        boolean isAsc = arr[start] < arr[end];
        while(start<=end){
        //int mid= start +end /2 will exceed the limit of integer
        int mid = start + (end-start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(isAsc){
            if(target < arr[mid]){
                end= mid - 1;
         }
            else{
            start = mid + 1;
            }
        
        }
        else{
            if(target > arr[mid]){
                end= mid - 1;
         }
            else{
                 start = mid + 1;
            
        }
            
     }
    }
       

    return -1;


    }
    
}
