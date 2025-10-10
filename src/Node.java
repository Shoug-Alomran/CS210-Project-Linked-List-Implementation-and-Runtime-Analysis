public class Node {
// Task: Field to store Registration data
    Registration studData;
// Task: Field to store next Node reference
    Node nextRef;

// Task: Constructor to initialize node with Registration

    public Node(Registration studData) {
        this.studData = studData;
        this.nextRef = null;
    }
    
}


