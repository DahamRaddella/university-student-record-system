public class RequestQueue {
    private class Node {
        String requestDetails;
        Node next;

        Node(String requestDetails) {
            this.requestDetails = requestDetails;
            this.next = null;
        }
    }

    private Node front, rear;

    // ඉල්ලීමක් Queue එකට එකතු කිරීම (Enqueue)
    public void addRequest(String requestDetails) {
        Node newNode = new Node(requestDetails);
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Added Request: " + requestDetails);
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Added Request: " + requestDetails);
    }

    // ඊළඟ ඉල්ලීම සැකසීම (Dequeue)
    public String processNextRequest() {
        if (front == null) {
            return "No pending requests.";
        }
        String temp = front.requestDetails;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp;
    }
}