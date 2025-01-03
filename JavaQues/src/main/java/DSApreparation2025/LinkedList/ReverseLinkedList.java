package DSApreparation2025.LinkedList;


class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class ReverseLinkedList {

    public static void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    public static Node reverseLinkedList(Node head){
        Node prev = null;
        Node temp = head;
        while(temp!=null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp=front;
        }
        return prev;
    }
    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
