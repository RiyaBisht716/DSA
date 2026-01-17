package arrays;

public class EvenDigits {
    public static void main(String[] args) {
        int [] nums = {12,456,789,23,12};
       // System.out.println(findnumbers(nums));
        System.out.println(digits(0));
        
    }
    //

    static int findnumbers(int[] nums){
        int cnt = 0;
        for(int num : nums){
            if(even(num)){
                cnt++;
            }
        }
        return cnt;

    }
//function to check whether a number contains even digits or not
    static boolean even(int num){
        int numberOfdigits = digits(num);
        /* 
        if(numberOfdigits % 2 == 0){
            return true;
        }
        return false;
        */
        return numberOfdigits % 2== 0 ;


    }


    static int digits2(int num){
        if(num<0){
            num = num * -1;

        }
        if(num ==0){
            return 1;
        }
        return (int)(Math.log10(num)) +1; //--**important increase the time complexity**--
    }

    //count number of digits in a number
    static int digits(int num){

        //negative number case

        if(num <0){
            num = num * -1;
        }


        if(num == 0){
            return 1;
        }

        int cnt = 0;
        while(num > 0){
            cnt++;
            num = num /10;
        }
        return cnt;

    }

    
}
