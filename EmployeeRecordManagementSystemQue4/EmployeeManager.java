package EmployeeRecordManagementSystemQue4;
import java.util.*;
        import java.util.regex.Pattern;
          public class EmployeeManager extends EmployeeOperations {


               // Collections
    HashMap<Integer, Employee> hashMap = new HashMap<>();
         Hashtable<Integer, Employee> hashtable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);


               private static final String NAME_REGEX = "^[A-Za-z ]{3,20}$";

    @Override
    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
                 int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
                       String name = sc.nextLine();

            if (!Pattern.matches(NAME_REGEX, name)) {
                        System.out.println("Invalid Name! Only alphabets allowed ");
                return;
            }

                 System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            Employee emp = new Employee(id, name, dept);

                    hashMap.put(id, emp);
              hashtable.put(id, emp);
            treeMap.put(id, emp);

            System.out.println("Employee Added Successfully ");

        } catch (Exception e) {
            System.out.println("Invalid Input! ");
            sc.nextLine();
        }
    }

    @Override
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
                    System.out.println("No Employee Records Found!");
            return;
        }

        System.out.println("\n--- Employees (TreeMap - Sorted) ---");
               for (Map.Entry<Integer, Employee> entry : treeMap.entrySet()) {

                   System.out.println(entry.getValue());
        }
    }

    @Override
    public void searchEmployee(int empId) {
        Employee emp = hashMap.get(empId);

        if (emp != null) {
              System.out.println("Employee Found ");
            System.out.println(emp);
        } else {
               System.out.println("Employee Not Found ");
        }
    }

    @Override
    public void removeEmployee(int empId) {
        if (hashMap.containsKey(empId)) {
                  hashMap.remove(empId);
            hashtable.remove(empId);
            treeMap.remove(empId);

                  System.out.println("Employee Removed Successfully ");
         } else {
                    System.out.println("Employee Not Found ");
        }
    }

    // Demonstration of null support
    public void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demonstration ---");


        hashMap.put(null, null);
        System.out.println("HashMap allows null key & null value ");

        try {
            treeMap.put(null, null);
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key ");
        }


        try {
            hashtable.put(null, null);
        } catch (Exception e) {
               System.out.println("Hashtable does NOT allow null key or null value ");
        }
    }
}
