package LinkedList.SinglyLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Add_1_ToLL {
     // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
        

    }
    // Add one to Linked list in iterative -(TC:- O(3N), SC- O(1))

    static ListNode AddOneToLLIterative(ListNode head){
        head = reverseList(head);//kyuki yeh singly linkedlist hai only forward direction allowed
        ListNode temp = head;
        int carry = 1;

        while(temp != null){
            temp.val  = temp.val + carry;
            if(temp.val < 10){
                carry = 0;
                break;

            }
            else{
                temp.val = 0;
                carry = 1;
            }
            temp = temp.next;


        }
        if(carry == 1){
            head = reverseList(head);
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        head = reverseList(head);
        return head;
    

    }
    static int helper(ListNode temp){
        //base case
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.val += carry;
        if(temp.val < 10) return 0; 
        temp.val = 0;
        return 1;


    }
    // Add the one to the linked list by Recursion
    //$$$$$$$$$$$$$$$$ TC- O(N),SC-(N), where N is a recursion stack call git $$$$$$$$$$$$$
    static ListNode AddOneRecursive(ListNode head){

        int carry = helper(head);

        if(carry == 1){
            ListNode newNode = new  ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    public static void main(String [] args){
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);

        System.out.print("Before Addition: ");
        printList(head);

        //head = AddOneToLLIterative(head);
        head = AddOneRecursive(head);

        System.out.print("After Addition: ");
        printList(head);



    }
    
    
}
