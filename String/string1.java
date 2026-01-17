package String;

public class string1 {
    public static void main(String[] args) {
        // String name1 = "Riya";
        // String name2 = "Riya";
        // System.out.println(name1 == name2);


         // == compare the reference variable of object is same or not
        String name1 = new String("Riya");
        String name2 = new String("Riya");
        // .equals to check the value of the object

        //System.out.println(name1==name2);
        System.out.println(name1.equals(name2));
        System.out.println(name1.charAt(2)); //charAt print the character at particular index
    }
    
} 
