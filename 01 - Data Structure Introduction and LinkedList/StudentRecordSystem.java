class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
            return;
        }
        temp.next = temp.next.next;
    }

    public Student searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateGradeByRollNumber(int rollNumber, String newGrade) {
        Student student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        studentList.addStudentAtBeginning(1, "John", 20, "A");
        studentList.addStudentAtEnd(2, "Alice", 21, "B");
        studentList.addStudentAtPosition(3, "Bob", 22, "C", 1);
        System.out.println("All Students:");
        studentList.displayAllStudents();
        Student student = studentList.searchStudentByRollNumber(2);
        if (student != null) {
            System.out.println("\nStudent found: " + student.name + ", " + student.age + ", " + student.grade);
        } else {
            System.out.println("\nStudent not found.");
        }
        studentList.updateGradeByRollNumber(2, "A+");
        studentList.deleteStudentByRollNumber(1);
        System.out.println("\nAll Students after update and deletion:");
        studentList.displayAllStudents();
    }
}
