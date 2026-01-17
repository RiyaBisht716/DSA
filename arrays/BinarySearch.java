package arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr ={-14,-5,-4,0,12,34,56,78};
        int target = 56;
        int ans = BinarySearch(arr,target);
        System.out.println(ans);
        
    }
    static int BinarySearch(int[]arr,int target){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
        //int mid= start +end /2 will exceed the limit of integer
        int mid = start + (end-start)/2;

        if(target < arr[mid]){
            end= mid - 1;

        }
        else if(target > arr[mid]){
            start = mid + 1;
            
        }
        else{
            return mid;
        }
    }
    return -1;
}

    
}
