package LinkedList.SinglyLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ReverseKthGroup {
      // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    //to find the kth node

    private static ListNode getKthNode(ListNode temp, int k){
        k -= 1;
        while(k > 0 && temp != null){
            k--;
            temp = temp.next;

        }
        return temp;
    }

    static ListNode reverseK(ListNode temp){
        //agar single node exist hai toh
        if(temp == null || temp.next == null){
            return temp;
        }

        ListNode back = null;
        ListNode curr = temp;
        while(curr != null){
            ListNode front = curr.next;
            curr.next = back;
            back = curr;
            curr = front;
        }
        return back;
}

static ListNode reverseKGroup(ListNode head, int k){
    ListNode temp = head;
    ListNode prevLast = null; // point to prev of next node

    while(temp != null){

        //pahele kth node pr jao
        ListNode kthNode = getKthNode(temp,k);

        //jb kth node null mtlb remaining node < k ho
        if(kthNode == null){
            //tb bs link kro , no reverse
            //but jb prev null na ho kyuki null ka next null pointer error dega
            if(prevLast != null) prevLast.next = temp;
            break;
        }
        //store next of kth for further reverse tracking

        ListNode nextNode = kthNode.next;
        kthNode.next = null;// break link to reverse
        reverseK(temp);

        if(temp == head) head = kthNode;
        else{
            prevLast.next = kthNode;
            
        }
        prevLast = temp;
        temp = nextNode;
    }
    return head;

    }
    //using Recursion
     //reverse exactly k nodes
    static ListNode reverseKthRecursion(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null && k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head after reverse
    }

    static ListNode reverseKGroupRecursion(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Step 1: check if k nodes exist
        while (curr!= null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) return head;  // not enough nodes

        // Step 2: reverse first k nodes using helper
        ListNode newHead = reverseKthRecursion(head, k);

        // Step 3: recursive call for remaining list
        head.next = reverseKGroupRecursion(curr, k);

        return newHead;
    }

    // array -> linked list converter
    static ListNode arrayToList(int[] arr){
        if(arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i = 1;i<arr.length;i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args){
        int[]arr = {1,2,3,4,5,6,7,8,9,10,11};
        int k = 3;
        ListNode head = arrayToList(arr);

        System.out.print("Original List: ");
        printList(head);

        //head  = reverseKGroup(head,k);
        head = reverseKGroupRecursion(head,k);
        System.out.print("After Reverse " + k + " Group: " );
        printList(head);

        
    
    }
}
