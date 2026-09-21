public class StudentLinkedList {

    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    
    public boolean addStudent(Student student) {

        if (student == null) {
            return false;
        }

        if (student.getMarks() < 0 || student.getMarks() > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return false;
        }

        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }

    
    public Student searchStudent(int studentId) {

        Node current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    
    public boolean updateStudent(int studentId, String name,
                                 String programme, double marks) {

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return false;
        }

        Node current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {

                current.data.setName(name);
                current.data.setProgramme(programme);
                current.data.setMarks(marks);

                return true;
            }

            current = current.next;
        }

        System.out.println("Student record not found.");
        return false;
    }

    
    public boolean deleteStudent(int studentId) {

        if (head == null) {
            System.out.println("Student list is empty.");
            return false;
        }

        if (head.data.getStudentId() == studentId) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.getStudentId() == studentId) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        System.out.println("Student record not found.");
        return false;
    }

    
    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Node current = head;

        System.out.println("\n===== Student Records =====");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("==========================");
    }
}