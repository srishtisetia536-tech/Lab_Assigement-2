import java.util.*;

abstract class Person {
    protected String name;
    protected String email;

    Person() {}

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void displayInfo();
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    void calculateGrade() {
        if (marks >= 85) grade = 'A';
        else if (marks >= 70) grade = 'B';
        else if (marks >= 55) grade = 'C';
        else grade = 'D';
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }

    public void displayInfo(String note) {
        displayInfo();
        System.out.println(note);
    }

    public int getRollNo() {
        return rollNo;
    }
}

interface RecordActions {
    void addStudent(Student s);
    void deleteStudent(int rollNo);
    void updateStudent(Student s);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

class StudentManager implements RecordActions {
    private Map<Integer, Student> record = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        if (record.containsKey(s.getRollNo())) {
            System.out.println("Error: Duplicate Roll Number.");
            return;
        }
        record.put(s.getRollNo(), s);
        System.out.println("Student Added Successfully.");
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (record.remove(rollNo) == null) {
            System.out.println("Student Not Found.");
            return;
        }
        System.out.println("Student Deleted.");
    }

    @Override
    public void updateStudent(Student s) {
        if (!record.containsKey(s.getRollNo())) {
            System.out.println("Student Not Found.");
            return;
        }
        record.put(s.getRollNo(), s);
        System.out.println("Record Updated.");
    }

    @Override
    public Student searchStudent(int rollNo) {
        return record.get(rollNo);
    }

    @Override
    public void viewAllStudents() {
        if (record.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }
        for (Student s : record.values()) {
            s.displayInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        int choice;

        while (true) {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter Option: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Roll No: ");
                int r = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Email: ");
                String e = sc.nextLine();
                System.out.print("Course: ");
                String c = sc.nextLine();
                System.out.print("Marks: ");
                double m = sc.nextDouble();

                Student st = new Student(r, n, e, c, m);
                sm.addStudent(st);
            }
            else if (choice == 2) {
                System.out.print("Enter Roll No: ");
                int r = sc.nextInt();
                sm.deleteStudent(r);
            }
            else if (choice == 3) {
                System.out.print("Roll No: ");
                int r = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Email: ");
                String e = sc.nextLine();
                System.out.print("Course: ");
                String c = sc.nextLine();
                System.out.print("Marks: ");
                double m = sc.nextDouble();

                Student st = new Student(r, n, e, c, m);
                sm.updateStudent(st);
            }
            else if (choice == 4) {
                System.out.print("Enter Roll No: ");
                int r = sc.nextInt();
                Student found = sm.searchStudent(r);
                if (found == null) System.out.println("Record Not Found.");
                else found.displayInfo();
            }
            else if (choice == 5) {
                sm.viewAllStudents();
            }
            else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid Option.");
            }
        }
        sc.close();
    }
}
