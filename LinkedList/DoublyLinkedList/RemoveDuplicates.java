package LinkedList.DoublyLinkedList;
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class RemoveDuplicates {
    private static void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // ################## Time Complexity :- O(N) , Space Complexity:- O(1) ####################

    static Node removeDuplicates(Node head){
        Node temp = head;
        //jab tk last node tk na jaye
        while(temp != null && temp.next != null){ // bahar wla while loop pura travderse nhi kr rha kuch node he kr rha hai
            Node nextNode = temp.next;
            while(nextNode != null && temp.data == nextNode.data){ // this while will traverse half nodes
                nextNode = nextNode.next;
            }
            //join the link
            temp.next = nextNode;
            //nextNode exist kr rha hai na
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;

        }
        return head;
    }
    static Node arrayToDLL(int[] arr){

        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;

        }
        return head;

    }
    public static void main(String [] args){
        int[]arr = {1,1,2,2,3,4,4};
        Node head = arrayToDLL(arr);
         // Print the original list
        System.out.print("Original List: ");
        printList(head);

        // Remove duplicate nodes
        head = removeDuplicates(head);

        // Print the updated list
        System.out.print("After Removing Duplicates (keeping 1 occurrence): ");
        printList(head);

    }
    
}
