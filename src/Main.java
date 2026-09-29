import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // දැනට පවතින Data Structures පමණක් Initialize කිරීම
        StudentLinkedList linkedList = new StudentLinkedList();
        ActionStack stack = new ActionStack();
        RequestQueue queue = new RequestQueue();
        
        while (true) {
            System.out.println("\n=== University Student Record & Campus Management ===");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records (Linked List)");
            System.out.println("5. Add Service Request to Queue");
            System.out.println("6. Process Next Service Request (Queue)");
            System.out.println("7. Display Recent Actions (Stack)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter බොත්තම කියවීම සඳහා
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Programme: ");
                    String prog = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    
                    Student newStudent = new Student(id, name, prog, marks);
                    if (linkedList.addStudent(newStudent)) {
                        System.out.println("Student added successfully.");
                        stack.pushAction("Added Student ID: " + id); // Stack එකට ක්‍රියාව යැවීම
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Programme: ");
                    String newProg = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    
                    if (linkedList.updateStudent(updateId, newName, newProg, newMarks)) {
                        System.out.println("Student updated successfully.");
                        stack.pushAction("Updated Student ID: " + updateId);
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (linkedList.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully.");
                        stack.pushAction("Deleted Student ID: " + deleteId);
                    }
                    break;
                    
                case 4:
                    linkedList.displayStudents();
                    stack.pushAction("Viewed all student records");
                    break;
                    
                case 5:
                    System.out.print("Enter Service Request Details: ");
                    String request = scanner.nextLine();
                    queue.addRequest(request);
                    stack.pushAction("Added Service Request: " + request);
                    break;
                    
                case 6:
                    String processed = queue.processNextRequest();
                    System.out.println("Processed: " + processed);
                    stack.pushAction("Processed Request: " + processed);
                    break;
                    
                case 7:
                    stack.displayRecentActions();
                    break;
                    
                case 8:
                    System.out.println("Exiting System...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}