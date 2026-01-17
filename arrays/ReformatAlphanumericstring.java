package arrays;

import java.util.*;


public class ReformatAlphanumericstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//take input from keyboard

        String s = sc.nextLine();//take input from the user
        int k = sc.nextInt(); // "k" is a segment length or a character length to be taken

        //Step1:- Remove all the hyphens and convert into uppercase

        s =s.replaceAll("-" ,"").toUpperCase();

        //Step2:- Using StringBuilder to group from the end of the strings

        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();

        int count =0; //to track the character ,to group them together
        for(int i = sb.length() -1 ; i>=0 ; i--){
            result.append(sb.charAt(i));
            count++;
            if(count == k && i!=0){
                result.append("-");
                count =0;
            }
        }
        System.out.println(result.reverse().toString());


    }
    
}
