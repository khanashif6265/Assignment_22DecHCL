package UniversityStudentManagementSystemQue5;
import java.util.Scanner;
public class UniversityApp {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- UNIVERSITY MANAGEMENT MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Remove Student by ID");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Convert HashMap to TreeMap");
                System.out.println("7. Count Students Course-wise");
                System.out.println("8. Display All Courses");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> manager.addStudent();
                    case 2 -> manager.displayStudents();
                    case 3 -> {
                        System.out.print("Enter ID: ");
                        manager.searchStudent(sc.nextInt());
                    }
                    case 4 -> {
                        System.out.print("Enter ID: ");
                        manager.removeStudent(sc.nextInt());
                    }
                    case 5 -> manager.sortStudentsByMarks();
                    case 6 -> manager.convertHashMapToTreeMap();
                    case 7 -> manager.countStudentsCourseWise();
                    case 8 -> manager.displayAllCourses();
                    case 9 -> {
                        System.out.println("Exiting Program...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice ❌");
                }

            } catch (Exception e) {
                System.out.println("Please enter valid input!");
                sc.nextLine();
            }
        }
    }
}
