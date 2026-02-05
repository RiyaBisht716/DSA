package LinkedList.SinglyLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class CheckLLisPalindromeOrNot {
     // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
     // Function to reverse a linked list using the recursive approach
    static ListNode reverseLinkedList(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the new head
        ListNode newHead = reverseLinkedList(head.next);

        // Store the next node in 'front' to reverse the link
        ListNode front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the original link
        head.next = null;

        // Return the new head obtained from the recursion
        return newHead;
    }

    //xxxxxxx check if the linked list is a palindrome using stack xxxxxxx
// xxxxxxxxxxxxxxxxx [T.C.-> O(2*N) , S.C. -> O(N)] xxxxxxxxxxx

static boolean isPalindromeUsingStack(ListNode head) {

    
    Stack<Integer> st = new Stack<>();

    // Initialize a temporary pointer to the head of the linked list
    ListNode temp = head;

    // Traverse the linked list and push values onto the stack

    while (temp != null) {

        st.push(temp.val);
        temp = temp.next;
    }

    // Reset the temporary pointer back to the head of the linked list
    temp = head;

    // Compare values by popping from the stack and checking against linked list nodes

    while (temp != null) {

        if (temp.val != st.top()) {

            // If values don't match, it's not a palindrome
            return false;
        }
        st.pop();
        temp = temp.next;
    }

    // If all values match, it's a palindrome
    return true;
}

   //xxxxxxx check if the linked list is a palindrome using stack xxxxxxx
// xxxxxxxxxxxxxxxxx [T.C.-> O(N) , S.C. -> O(1)] xxxxxxxxxxx
    // Function to check if the linked list is a palindrome
    static boolean isPalindrome(ListNode head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return true;  // It's a palindrome by definition
        }

        // Initialize two pointers, slow and fast, to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the linked list to find the middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // Move slow pointer one step at a time
            fast = fast.next.next;  // Move fast pointer two steps at a time
        }

        // Reverse the second half of the linked list starting from the middle
        ListNode newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        ListNode first = head;

        // Pointer to the reversed second half
        ListNode second = newHead;

        // Compare data values of nodes from both halves
        while (second != null) {
            if (first.val != second.val) {
                // If values do not match, the list is not a palindrome
                reverseLinkedList(newHead);  // Reverse the second half back to its original state
                return false;
            }

            first = first.next;  // Move the first pointer
            second = second.next; // Move the second pointer
        }

        // Reverse the second half back to its original state
        reverseLinkedList(newHead);

        // The linked list is a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printList(head);

    

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }

        System.out.println("After checking the List");
        printList(head);
    }

    
}
