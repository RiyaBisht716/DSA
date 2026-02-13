package LinkedList.SinglyLinkedList;
import java.util.*;
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class MergeKSortedList {

    // Better Solution

    //merge two sorted list
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;// pointer

        while(l1 != null && l2 != null){
            if(l1.data< l2.data){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) temp.next = l1; //left over l1 ki values ko add kr do
        if(l2 != null) temp.next = l2;// left over l2 ki value ko add kr do

        return dummy.next;

    } 
 
    //merge k sorted lists using sequencial merge

    private static ListNode mergeKLists(ListNode[] lists){
        //kahi list khali toh nhi hai
        if(lists.length == 0)  return null;

        ListNode head = lists[0];

        for(int i = 1 ;i < lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }

    //Optimal Solution: Using Priority Queue(Min heap)


    // Time Complexity :- O(nlogk) , Space Complexity:- O(k)
    private static ListNode mergeKListsUsingPriorityQueue(ListNode []lists){
        if(lists.length == 0) return null;

        // define min heap on node value

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.data - b.data);

        //insert first node of each list

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;


        //process heap

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();// remove and return smallest node from min heap

            temp.next = minNode;
            temp = temp.next;
            
            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }
        return dummy.next;
        
    }

     // Helper function to print list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args){

     // L1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // L2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // L3: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode result = mergeKListsUsingPriorityQueue(lists);

        System.out.print("Merged List: ");
        printList(result);

    
}
}
