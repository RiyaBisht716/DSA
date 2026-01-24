class Abc{
        protected int num;
        String name;
        int[]arr ; 

    

    //getNum is a method for accessing the num from a class
int getNum(){
        return num;
}
    //setNum is a method to set the given num
void setNum(){
        this.num = num;
}

public Abc(int num,String name){
        this.num = num;
        this.name = name;
        this.arr = new int[num];
}
}

class ObjectDemo {
    int num;
    float gpa;

    public ObjectDemo(int num,float gpa){
        this.num = num;
        this.gpa = gpa;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    
    // protected void finalize() throws Throwable{
    //     super.finalize();
    // }
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        return this.num == ((ObjectDemo)obj).num;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
class SubClass extends Abc{
    public SubClass(int num,String name){
        super(num,name);

    }

}


public class AccessControl {
    public static void main(String [] args){
        // Abc obj = new Abc(12,"Riya");
        // need to do a few things
        // 1. access the data members
        // 2. modify the data members
        //ArrayList<Integer> list = new ArrayList<>(23);
//        list.DEFAULT_CAPACITY;
        // obj.getNum();
        // int n = obj.num;
        // ObjectDemo obj1 = new ObjectDemo(12,56.8f);
        // ObjectDemo obj2 = new ObjectDemo(12,78.9f);

        // if(obj1 == obj2){
        //     System.out.println("obj1 is equal to obj2");
        // }
        // if(obj1.equals(obj2)){
        //     System.out.println("obj1 is equal to obj2");
        // }

        // System.out.println(obj1.getClass().getName());
        SubClass obj3 = new SubClass(12,"Riya Bisht");
        int n = obj3.num;

        System.out.println(obj3 instanceof Object);


    }
}
