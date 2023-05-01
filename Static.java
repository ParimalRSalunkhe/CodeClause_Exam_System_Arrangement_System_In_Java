import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private int marks;

    public Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Marks: " + marks;
    }
}

class SeatingArrangementSystem {
    private List<Student> students;
    private int numStudents;
    private int numSeats;

    public SeatingArrangementSystem(int numStudents, int numSeats) {
        this.numStudents = numStudents;
        this.numSeats = numSeats;
        students = new ArrayList<>(numStudents);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void arrangeSeats() {
        Collections.sort(students, Comparator.comparing(Student::getMarks).reversed());

        int row = 1;
        int seat = 1;

        for (Student student : students) {
            System.out.println(student.getName() + " - Row: " + row + ", Seat: " + seat);

            if (seat == numSeats) {
                row++;
                seat = 1;
            } else {
                seat++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SeatingArrangementSystem system = new SeatingArrangementSystem(10, 5);

        system.addStudent(new Student("Alice", 1, 90));
        system.addStudent(new Student("Bob", 2, 85));
        system.addStudent(new Student("Charlie", 3, 80));
        system.addStudent(new Student("David", 4, 75));
        system.addStudent(new Student("Emily", 5, 70));
        system.addStudent(new Student("Frank", 6, 65));
        system.addStudent(new Student("Gina", 7, 60));
        system.addStudent(new Student("Harry", 8, 55));
        system.addStudent(new Student("Iris", 9, 50));
        system.addStudent(new Student("John", 10, 45));

        system.arrangeSeats();
    }
}
