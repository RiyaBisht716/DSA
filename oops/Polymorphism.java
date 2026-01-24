//Polymorphism -> poly means many and morphism means ways to represent


    
    //class shapes
class Shapes{
        void area(){
            System.out.println("I am in shapes");
        }

}

    //class circle
class Circle extends Shapes{
        void area(){
            System.out.println("Area is pi * r* r");
}

}

    //class triangle
class Triangle extends Shapes{
        void area(){
            System.out.println("Area is 0.5 * b* h");
    }

}

    //class square
class Square extends Shapes{
        void area(){
            System.out.println("Area is square of side");
}
}
//Method Overloading
class Numbers{
    int sum(int a,int b){
        return a + b;
    }
    int sum(int a,int b,int c){
        return a + b;
    }
}
public class Polymorphism {
public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();

        circle.area();
}

}
