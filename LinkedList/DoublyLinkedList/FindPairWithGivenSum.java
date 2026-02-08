package LinkedList.DoublyLinkedList;
import java.util.*;
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

public class FindPairWithGivenSum {

    //Function to find tail

    static Node findTail(Node head){
        Node tail = head;
        while(tail  != null && tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    //Function to find pairs
    // #################### Total TC:- O(N) , SC:- O(1) ######################
    static List<List<Integer>> findPairs(Node head , int k){
        List<List<Integer>> ans = new ArrayList<>();
 //agar list he khali hai toh
        if(head == null) return ans;

        Node left = head;
        Node right = findTail(head);  //TC -O(N)

        while(left != null && right != null && left != right && right.next != left){ //Tc:_ O(N)
            int sum = left.data + right.data;

            if(sum == k){
                //converting into list
                ans.add(Arrays.asList(left.data,right.data));
                left = left.next;
                right = right.next;
            }
            else if(sum < k){
                //increase the left
                left = left.next;
            }
            else{
                //decrease the right
                right = right.prev;
            }
        }
        return ans;

    }

    static Node arrayToDLL(int[] arr) {

    if (arr.length == 0) return null;

    Node head = new Node(arr[0]);
    Node curr = head;

    for (int i = 1; i < arr.length; i++) {

        Node newNode = new Node(arr[i]);

        curr.next = newNode;
        newNode.prev = curr;

        curr = newNode;
    }

    return head;
}

static void printPairs(List<List<Integer>> v) {

    for (List<Integer> p : v) {
        System.out.print("(" + p.get(0) + ", " + p.get(1) + ") ");
    }

    System.out.println();
}

public static void main(String[] args) {

    int[] arr = {1, 2, 4, 5, 6, 8, 9};
    int target = 7;

    Node head = arrayToDLL(arr);

    System.out.print("Pairs summing to " + target + ": ");

    List<List<Integer>> result = findPairs(head, target);

    printPairs(result);
}

    
}
