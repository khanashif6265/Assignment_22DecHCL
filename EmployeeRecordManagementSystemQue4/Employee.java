package EmployeeRecordManagementSystemQue4;

public class Employee {
    private int empId;
          private String name;
    private String department;

    public Employee(int empId, String name, String department) {
        this.empId = empId;
             this.name = name;
        this.department = department;
    }

    public int getEmpId() {
             return empId;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId +
                        ", Name: " + name +
                ", Department: " + department;
    }
}
