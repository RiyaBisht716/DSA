package LinkedList.DoublyLinkedList;
import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data1,Node next1,Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;

    }

    public Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;

    }
}

public class ReverseDLL {
    private static Node ArrayToDLL(int []arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
                prev.next = temp;
                prev = temp;
            }
            return head;
            

    }
    private static void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // ############ Brute Force:-(TC-O(2N), SC- O(N))############# //
    private static Node reverseDoublyUsingStack(Node head){
        if(head == null || head.next ==null)
        return head;

        Stack<Integer> st = new Stack<>();
        Node temp = head;
        //push the data into stack
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }

        //reset the temp to head
        temp = head;
        //pop the data from stack and put in Node
        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;

        }
        return head;
    }
    // ############### Optimal Approach:- (TC-(O(N)),SC- (O(1)) ################//

    private static Node reverseDoublyLL(Node head){
        Node curr = head;
        Node last = null; //track the new head
        while(curr != null){
            //swap the node
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            //move to next node
            last = curr;
            curr = temp;

        }
        return last;//the last will be my final head
    }

    
    public static void main(String []args){
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = ArrayToDLL(arr);
        System.out.print("Before reversed: ");
        printList(head);
       // head = reverseDoublyUsingStack(head);
        head = reverseDoublyLL(head);
        System.out.print("After reversed: ");
        printList(head);


    }
    
}
