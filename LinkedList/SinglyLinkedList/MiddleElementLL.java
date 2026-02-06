package LinkedList.SinglyLinkedList;
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


public class MiddleElementLL {
    // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    //find Midlle node by counting the node 
    //Brute Force:-  TC-(O(n +n/2)), SC:- O(1)
    static ListNode findMiddle(ListNode head){
        //agar list empty ya single node hai toh
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        int mid = (cnt/2) + 1;

        temp = head;

        while(temp != null){
            mid--;
            if(mid == 0){
                break;
            }
        temp = temp.next;

        }
        return temp;
    }

    //Middle element using Tortoise and Hare Algorithm
    // ################# Optimal -TC- O(N/2) , SC- O(1) #################


    static ListNode middleElement(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        // Creating a sample linked list:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Find the middle node
        ListNode middleNode = middleElement(head);
       // ListNode middleNode1 = findMiddle(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);

        
    }
    
}
