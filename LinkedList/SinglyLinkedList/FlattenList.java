package LinkedList.SinglyLinkedList;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode(int x) {
        this.val = x;
        this.next = null;
        this.child = null;
    }
}

public class FlattenList {
    // Function to convert a vector to a linked list

    //Brute Force Solution

    static ListNode convertArrToLinkedList(List<Integer> arr) {

        /* Create a dummy node to serve as
         the head of the linked list */
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        /* Iterate through the vector and
         create nodes with vector elements */
        for (int i=0; i < arr.size(); i++) {

            // Create a new node with the vector element
            temp.child = new ListNode(arr.get(i));
            
            // Update the temporary pointer
            temp = temp.child;
        }
        
        /* Return the linked list starting
         from the next of the dummy node */
        return dummyNode.child;
    }


    // Function to flatten a linked list with child pointers 
    private static ListNode flattenLinkedList(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        // Traverse through the linked list
        while (head != null) {

            /* Traverse through the child
             nodes of each head node */
            ListNode t2 = head;
            
            while (t2 != null) {

                // Store each node's data in the array
                arr.add(t2.val);
                
                // Move to the next child node
                t2 = t2.child;
            }
            // Move to the next head node
            head = head.next;
        }

        // Sort the array containing node values
        Collections.sort(arr);
        return convertArrToLinkedList(arr);

    }



// Optimal Solution :-  Time Complexity:-
    private static ListNode merge(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp =  dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.child = list1;
                temp = list1;
                list1 = list1.child;
            }
            else{
                temp.child = list2;
                temp = list2;
                list2 = list2.child;
            }
            temp.next = null;
        }
        if(list1 != null) temp.child = list1;
        else temp.child = list2;

        if(dummy.child != null){
            dummy.child.next = null;
        }
        return dummy.child;
    }

    private static ListNode flattenLinkedListOptimal(ListNode head){
        //base case

        //hum list ke last element tk ja rhe hai
        if(head == null || head.next == null){
            return head;
        }

        //Recursively flatten the rest of the linked list
        ListNode mergedHead = flattenLinkedList(head.next);//new head return kro
        return merge(head,mergedHead);// yeh function merge ko call kr rha hai
    }
    static void printList(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.child;   
    }
    System.out.println();
}

       // Print original linked list in grid format
    private static void printOriginalLinkedList(ListNode head, int depth) {
    ListNode temp = head;

    while (temp != null) {
        // print indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("| ");
        }

        // print current node
        System.out.println(temp.val);

        // print child list
        if (temp.child != null) {
            printOriginalLinkedList(temp.child, depth + 1);
        }

        temp = temp.next;
    }
}


    public static void main(String[] args) {
        // Create linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print original list
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten and print
    
        //head = flattenLinkedList(head);
        head = flattenLinkedListOptimal(head);
        System.out.print("\nFlattened linked list: ");
        printList(head);
    }


    
}
