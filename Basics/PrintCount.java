package Basics;
public class PrintCount {

    
    public static void printCount(int cnt){
        if(cnt==3)
        return;

        System.out.println(cnt);
        cnt++;
        printCount(cnt);
    }
    public static void main(String[]args){
        printCount(0);
    
    }
    
}
