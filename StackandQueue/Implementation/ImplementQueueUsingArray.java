package StackandQueue.Implementation;

class ArrayQueue{
    int []arr;
    int start,end;
    int currSize, maxSize;


    //constructor

    public ArrayQueue(){
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 10;
    }


    //Time Complexity :- O(1), Space Complexity :- O(1)
    public void push(int x){
        //check kahi Queue bhara toh nhi hai
        if(currSize == maxSize) {
            System.out.println("Queue is Full");
            System.exit(1);
        }

        //agar queue empty hai toh initialize kro start and end ko

        if(end == -1){
            start = 0;
            end = 0;
        }

        else{
            //circular increment of end
            end = (end + 1) % maxSize;
        }
        arr[end] = x;
        currSize++;
    }

    public int pop(){
        //check queue is empty

        if(start == -1){
            System.out.println("Queue is Empty");
            System.exit(1);

        }
        int popped = arr[start];
        //agar queue mai sirf single element ho
        if(currSize == 1){
            start = -1;
            end = -1;

        }
        else {
            //circular increment of start

            start = (start + 1) % maxSize;

        }
        currSize--;
        return popped;
    }

    public int top(){
        if(start == -1){
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    public boolean isEmpty(){
        return (currSize == 0);
        }
}


public class ImplementQueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);

        System.out.println("Pop: " + q.pop());
        System.out.println("Top: " + q.top());

    }
}
