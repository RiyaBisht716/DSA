package LinkedList.SinglyLinkedList;
import java.util.*;

class ListNode {
    int data ;
    ListNode next;

    public ListNode(int data1 , ListNode next1){
        this.data = data1;
        this.next = next1;

    }
    
    public ListNode(int data1){
        this.data = data1;
        this.next = null;
        
    }
}

public class FindIntersectionPointOfLL{
     // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    //check that intersection is present or not using hashset
    //$$$$$$$$$$$$$$$$$$ Better Approach - (TC-  O(n1 + n2)  , SC-(O(n1))) $$$$$$$$$$$

    static ListNode intersectionPresentUsingSet(ListNode head1, ListNode head2 ){
        Set<ListNode> set = new HashSet<>();// Set to store visited nodes from the first list
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        //this will add the head1 data into the set
        while(temp1 != null){
            set.add(temp1);// Insert nodes of the first list into the set
            temp1 = temp1.next;

        }
        //this will simultaneously check if the head2 data is common and found in head 1 data it will return the head2

        while(temp2 != null){
            if(set.contains(temp2)) return temp2;// If node is found in set, it's the intersection point
            temp2 = temp2.next;
        }
        //if no intersection point will be find it will return null
        return null;

    }
//Find the Difference
    static int FindDifference(ListNode head1, ListNode head2){
        int len1 =0;
        int len2 = 0;

        while(head1 != null || head2 != null){
            if(head1 != null){
                len1++;
                head1 = head1.next;
            }
            if(head2 != null){
                len2++;
                head2 = head2.next;
            }
        }
        return (len1-len2);
    }

    // ########### Optimal Approach :- TC-O(2* (n1 + n2), SC- O(n1)########

    static ListNode findIntersectionPoint(ListNode head1, ListNode head2){

        int diff = FindDifference(head1 ,head2);

        if(diff < 0){
            while(diff++ != 0) head2 = head2.next;
        }
        else{
            while(diff-- != 0) head1 = head1.next;
        }
        

        //Compare and traverse the node

        while(head1 != null){
            if(head1 == head2){ // Intersection point found
                return head1;
            }
            head2 = head2.next;
            head1 = head1.next;

        }
        return head1;

    }
    // #############  TC- O(2* max(length of list1, length of list2)), SC- O(1)########
    static ListNode IntersectionPresentOptimal(ListNode head1 ,ListNode head2){

        // Agar kisi bhi linked list ka head NULL hai,
        // to intersection possible nahi hai
        if(head1 == null || head2 == null ) return null;
         // temp1 pointer list 1 se traverse karega
        // temp2 pointer list 2 se traverse karega
        ListNode temp1 = head1;
        ListNode temp2 = head2;

      // Loop tab tak chalega jab tak
        // dono pointers same node par nahi aa jaate
        while(temp1 != temp2){

            // Dono pointers ko ek-ek step aage badhao
            temp1 = temp1.next;
            temp2 = temp2.next;

            // Agar dono same node par aa gaye,
            // wahi intersection point hoga
            if(temp1 == temp2)
                return temp1;

            // Agar t1 list 1 ke end par pahunch gaya,
            // to usse list 2 ke head par bhej do
            if(temp1 == null)
                temp1 = head2;

            // Agar t2 list B ke end par pahunch gaya,
            // to usse list A ke head par bhej do
            if(temp2 == null)
                temp2 = head1;
        }

        // Yahan do cases ho sakte hain:
        // 1) Intersection node mil gaya
        // 2) Dono pointers NULL par mil gaye (no intersection)
        return temp1;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);
        
    
        ListNode head1 = head;
        head = head.next.next.next;  // Intersection point
        ListNode headSec = new ListNode(3);
        ListNode head2 = headSec;
        headSec.next = head;  // Creating intersection
        // Printing the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);

        ListNode answerNode = intersectionPresentUsingSet(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.data);
        }
    }
}