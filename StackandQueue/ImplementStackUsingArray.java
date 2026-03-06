package StackandQueue;
class ArrayStack{
    private int[] arr;
    private int capacity;
    private int topIndex;
    //constructor 

    public ArrayStack(int size){
        capacity = size;
        arr = new int[capacity];
        topIndex = -1;
    }
    //push elements
    public void push(int x){
        if(topIndex >= capacity -1){
            System.out.println("Stack is overflow");
            return;

        }
        // pahele top increment higa fir push hoga element
        arr[++topIndex] = x;

    }
    //removes and return top element
    public int pop(){
        if(topIndex == -1){
            System.out.println("Stack is Underflow");
            return -1;
        }
        return arr[topIndex--];
    }
    //return top element
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;

        }
        return arr[topIndex];
    }
    //check whether the stack is empty or not

    public boolean isEmpty(){
        return topIndex == -1;
    }
}



public class ImplementStackUsingArray {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());



    }

}
