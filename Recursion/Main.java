package Recursion;
import java.util.*;
class LetterCombineOfphoneNo{
    private final String[] map;

    public LetterCombineOfphoneNo(){
        map = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    }

    private void backtrack(String digits , List<String> ans,int index,String current){
        //base case
        if(index == digits.length()){
            ans.add(current);
            return;
        }

        //characters of dgits ke sath match karana hai

        String s = map[digits.charAt(index)-'0'];
        //loop joh characters mai iterate karega

        for(int i=0;i<s.length();i++){
            //recursion and add current character

            backtrack(digits,ans,index + 1,current + s.charAt(i));

        }

        //
    }

    public List<String> findPhoneNo(String digits){
        List<String> ans = new ArrayList<>();

        //agar digit array khali ho toh
        if(digits.length() == 0){
            return ans;
        }

        backtrack(digits,ans,0,"");
        return ans;
    }
}

    public class Main{
        public static void main(String[] args) {
            LetterCombineOfphoneNo sol = new LetterCombineOfphoneNo();
            String digits = "23";
            List<String> result = sol.findPhoneNo(digits);

            for(String combination: result){
                System.out.print(combination + " ");
            }


        }
    }

