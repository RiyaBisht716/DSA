//Inheritance
class Box{
    double l;
    double h;
    double w;
    //constructor
    Box(){
        this.h = -1;
        this.l = -1;
        this.w = -1;

    }
    //cube
    Box(double side){
        //super(): Object class
        this.w = side;
        this.l = side;
        this.h = side;

    }
    Box(double l, double h, double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }
    Box(Box old){
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;

    }
    public void information(){
        System.out.println("Running the box");
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    BoxWeight(double l ,double h,double w,double weight){
    super(l,h,w); //what is this? call the parent class constructor
    this.weight = weight;//used to initialise values present in parent class
    //private values cannot be access by child class 

    BoxWeight(double side, double weight ){
        super(side);
        this.weight = weight;

    }

}
}

class BoxPrice extends BoxWeight{
    double cost;

    //constructor  
    BoxPrice(){
        super();
        this.cost = -1;

    }
    BoxPrice(BoxPrice other){
        super(other);
        this.cost = other.cost;

    }

    BoxPrice(double side, double weight,double cost){
        super(side,weight);
        this.cost = cost;

    }
    BoxPrice(double l, double h, double w, double weight, double cost){
        super(l,h,w,weight);
        this.cost = cost;
    }

}



public class Inheritance{
public static void main(String[] args) {
        // Box box = new Box(3);
        // Box box1 = new Box(box);
        // System.out.println(box.l + " " + box.w + " " + " " + box.h);

        // BoxWeight box3 = new BoxWeight();
        // BoxWeight box4 = new BoxWeight(2,3,4,8);
        // System.out.println(box3.h + " " + box3.weight);

        //there are many variables in both parent and child classes
        //you are given access to variables that are in the ref type i.e Boxweight
        //hence, you should have access to weight variable
        //this also means, that the ones you are trying to access should be initialised
        //but here, when the obj itself is of type parent class,how will you call the constructor of child  class
        //this is why error
        //BoxWeight box6 = new Box(2,3,4);
        //System.out.println(box6);

        BoxPrice box = new BoxPrice(5,8,200);
        
    }
}

