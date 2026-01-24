package oops.StaticExample;
public class InnerClasses {
    
    static class Test{
        String name;
        public Test(String name){
            this.name = name;
        }
        @Override

        public String toString(){
            return name;
        }

    }


public static void main(String[] args) {
    Test a = new Test("Riya");
    Test b = new Test("Rinku");

    System.out.println(a);
    // System.out.println(a.name);//Riya
    // System.out.println(b.name);//Rinku

}
    
}
