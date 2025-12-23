package EmployeeRecordManagementSystemQue4;
            import java.util.Scanner;
public class EmployeeApp {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();
                           Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- EMPLOYEE MANAGEMENT MENU ---");
                System.out.println("1. Add Employee");
                      System.out.println("2. Display Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Remove Employee by ID");
                          System.out.println("5. Demonstrate Null Support");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        manager.addEmployee();
                        break;

                    case 2:
                        manager.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        manager.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        manager.demonstrateNullSupport();
                        break;

                    case 6:
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
