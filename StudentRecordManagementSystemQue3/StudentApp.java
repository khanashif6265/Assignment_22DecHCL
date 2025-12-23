package StudentRecordManagementSystemQue3;
import java.util.Scanner;
public class StudentApp {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n-- STUDENT MANAGEMENT MENU --");

                System.out.println("1. Add Student");

                                 System.out.println("2. Display Students");

                          System.out.println("3. Remove Student by Roll No");

                System.out.println("4. Search Student by Roll No");

                       System.out.println("5. Exit");

                System.out.print("Enter choice: ");

                                     int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        manager.addStudent();
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                                  case 3:
                                    System.out.print("Enter Roll No: ");
                                    manager.removeStudent(sc.nextInt());
                                    break;

                    case 4:
                        System.out.print("Enter Roll No: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println("Please enter valid input!");
                sc.nextLine();
            }
        }
    }
}
