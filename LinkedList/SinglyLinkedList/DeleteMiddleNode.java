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


public class DeleteMiddleNode {
    // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // $$$$$$$$$$$ Brute force  -TC -(O(n +n/2)), Sc- O(1) $$$$$$$$$$$$$$$$

    static ListNode deleteMiddleBrute(ListNode head){
        ListNode temp = head;
        int n = 0; // n is no of nodes

        //calculating the no of nodes in a Linked list
        while(temp != null){
            n++;
            temp = temp.next;
        }

        int ans = n/2;  // Calculate the index of the middle node

        temp = head;  // Reset the temporary node to the beginning of the linked list

           // Loop to find the middle node to delete

        while(temp != null){
            ans--;
             // If the middle node is found
            if(ans == 0){
                ListNode middle = temp.next;
                temp.next = temp.next.next;
                 // Exit the loop after deleting the middle node
                break;
            }
            temp = temp.next;
            
        }
        return head;

    }
    // ############# optimal approach :- Time complexity:- O(N/2), Space Complexity:- O(1) ###############
    static ListNode DeleteMiddleNode(ListNode head){

          // If list has only one node, delete it
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head; // here we skip slow by 1

        ListNode fast = head;
        fast = fast.next.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //here we change the link the middle node is deleted
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        
        // Creating a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printList(head);


        // Deleting the middle node
        head = DeleteMiddleNode(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printList(head);
    }
    
}
