public class LinkedList {
    Node head;
    int size;
    Node tail;

    // Task: Method to insert node at head
    public void insertNodeAtHead(Registration data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;

    }
    // Task: Method to insert node at tail

    public void insertNodeAtTail(Registration data) {

        Node newNode = new Node(data);
        // Case 1: handle special case (if node is empty)
        if (head == null) {

            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;

    }
    // Task: Method to delete node by value

    public void deleteNodeByValue(Registration data) {

        // Case 1: empty list
        if (head == null) {
            return;
        }

        // Case 2: if head node is to be deleted
        if (head.studData.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        // Case 3: if any other node is to be deleted
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.studData.equals(data)) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Task: Method to search for a node
    public boolean searchKey(Registration data) {

        Node temp = head;
        while (temp.next != null) {
            if (temp.studData.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    // Task: Method to display/traverse all nodes
    public void displayLinkedList() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.studData);
            temp = temp.next;
        }
    }

    // Task: Method to convert list to array (Registration[])
    public Registration[] convToArray() {

        // count number of nodes
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // create an array of that size
        Registration[] dataArray = new Registration[size];

        // traverse through node to store into array
        temp = head;
        int index = 0;
        while (temp != null) {
            dataArray[index++] = temp.studData;
            temp = temp.next;
        }
        return dataArray;
    }
}
