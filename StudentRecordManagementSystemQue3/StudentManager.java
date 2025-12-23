package StudentRecordManagementSystemQue3;
import java.util.*;
import java.util.regex.Pattern;
public class StudentManager extends StudentOperations {

    List<Students> studentList = new ArrayList<>();
    Vector<Students> studentVector = new Vector<>();

    Scanner sc = new Scanner(System.in);


    private static final String NAME_REGEX = "^[A-Za-z ]{3,20}$";

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
                  String name = sc.nextLine();

            if (!Pattern.matches(NAME_REGEX, name)) {
                        System.out.println("Invalid Name! Only alphabets allowed.");
                return;
            }

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            Students s = new Students(roll, name, course);

            studentList.add(s);
              studentVector.add(s);

            System.out.println("Student Added Successfully ");

        } catch (Exception e) {
            System.out.println("Error: Invalid Input!");
            sc.nextLine();
        }
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Student Records Found!");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Students s : studentList) {
               System.out.println(s);
        }
    }

    @Override
    public void removeStudent(int rollNo) {
         boolean found = false;

        Iterator<Students> it = studentList.iterator();
        while (it.hasNext()) {
            Students s = it.next();
                     if (s.getRollNo() == rollNo) {
                it.remove();
                studentVector.remove(s);
                found = true;
                System.out.println("Student Removed Successfully ");
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found ");
        }
    }

    @Override
    public void searchStudent(int rollNo) {
        for (Students s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student Found ");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student Not Found ");
    }
}
