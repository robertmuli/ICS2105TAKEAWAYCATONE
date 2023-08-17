class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    DoublyLinkedListNode head;

    DoublyLinkedList() {
        head = null;
    }

    DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            // If the list is empty, the new node becomes the head
            return newNode;
        } else if (data <= head.data) {
            // If the new data is less than or equal to the head's data,
            // insert the new node at the beginning of the list
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            DoublyLinkedListNode current = head;

            while (current.next != null && current.next.data < data) {
                // Traverse the list to find the appropriate location
                current = current.next;
            }

            // Insert the new node after 'current'
            newNode.prev = current;
            newNode.next = current.next;

            if (current.next != null) {
                // Update the 'prev' pointer of the next node if it exists
                current.next.prev = newNode;
            }

            current.next = newNode;
            return head;
        }
    }

    void printList(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        int t = 1; // Number of test cases

        while (t-- > 0) {
            int n = 4; // Number of elements in the linked list
            DoublyLinkedListNode head = null;

            // Construct the initial doubly linked list
            head = list.sortedInsert(head, 3);
            head = list.sortedInsert(head, 4);
            head = list.sortedInsert(head, 10);

            // Print the initial doubly linked list
            System.out.println("Initial Doubly Linked List:");
            list.printList(head);

            int data = 5; // Data to be inserted
            head = list.sortedInsert(head, data);

            // Print the doubly linked list after insertion
            System.out.println("Doubly Linked List after Insertion:");
            list.printList(head);
        }
    }
}