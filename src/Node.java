public class Node {
    Registration studData; // Field to store Registration data
    Node next; // Field to store next Node reference

    // Task: Constructor to initialize node with Registration
    public Node(Registration studData) {
        this.studData = studData;
        this.next = null;
    }

}
