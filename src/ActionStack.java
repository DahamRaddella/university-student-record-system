public class ActionStack {
    private class Node {
        String action;
        Node next;

        Node(String action) {
            this.action = action;
            this.next = null;
        }
    }

    private Node top;

    // අලුත් ක්‍රියාවක් Stack එකට දැමීම (Push)
    public void pushAction(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }

    // අවසානයට කළ ක්‍රියාව බැලීම හෝ ඉවත් කිරීම (Pop)
    public String popAction() {
        if (top == null) {
            return "No recent actions.";
        }
        String temp = top.action;
        top = top.next;
        return temp;
    }
    
    // Stack එකේ තියෙන සියලු ක්‍රියා බැලීම (Display History)
    public void displayRecentActions() {
        if (top == null) {
            System.out.println("History is empty.");
            return;
        }
        Node current = top;
        System.out.println("\n===== Recent Actions =====");
        while (current != null) {
            System.out.println(current.action);
            current = current.next;
        }
        System.out.println("==========================");
    }
}