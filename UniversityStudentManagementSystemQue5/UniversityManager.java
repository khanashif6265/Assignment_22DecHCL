package UniversityStudentManagementSystemQue5;
import java.util.*;
import java.util.regex.Pattern;
public class UniversityManager extends UniversityOperations {
    // Collections
    List<Student> studentList = new ArrayList<>();
      Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();

          HashMap<Integer, Student> studentMap = new HashMap<>();
    Hashtable<Integer, Student> studentTable = new Hashtable<>();
    TreeMap<Integer, Student> sortedMap = new TreeMap<>();

          Set<String> courseSet = new HashSet<>();

    Scanner sc = new Scanner(System.in);


    private static final String NAME_REGEX = "^[A-Za-z ]{3,25}$";

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
                       int id = sc.nextInt();

            if (studentMap.containsKey(id)) {
                   System.out.println("Duplicate Student ID not allowed ");
                return;
            }

            sc.nextLine();
                   System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (!Pattern.matches(NAME_REGEX, name)) {
                    System.out.println("Invalid Name ");
                return;
            }

            System.out.print("Enter Course: ");
                String course = sc.nextLine();

            System.out.print("Enter Marks: ");
                 int marks = sc.nextInt();

            Student s = new Student(id, name, course, marks);

            studentList.add(s);
               studentVector.add(s);
            studentStack.push(s);

            studentMap.put(id, s);
               studentTable.put(id, s);

            courseSet.add(course);

            System.out.println("Student Added Successfully ");

        } catch (Exception e) {
            System.out.println("Invalid Input ");
            sc.nextLine();
        }
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
                System.out.println("No Student Records Found");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Override
    public void searchStudent(int id) {
        Student s = studentMap.get(id);
                  if (s != null) {
            System.out.println("Student Found ");
               System.out.println(s);
        } else {
               System.out.println("Student Not Found ");
        }
    }

    @Override
    public void removeStudent(int id) {
        Student s = studentMap.remove(id);

        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            studentTable.remove(id);
            System.out.println("Student Removed Successfully ");
        } else {
            System.out.println("Student Not Found ");
        }
    }

    @Override
    public void sortStudentsByMarks() {
        studentList.sort(Comparator.comparingInt(Student::getMarks).reversed());
             System.out.println("Students Sorted by Marks (Descending) ");
        displayStudents();
    }

    @Override
    public void countStudentsCourseWise() {
        HashMap<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.getCourse(),
                    countMap.getOrDefault(s.getCourse(), 0) + 1);
        }

        System.out.println("\n--- Course Wise Student Count ---");
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    @Override
    public void displayAllCourses() {
        System.out.println("\n--- Unique Courses ---");
        for (String course : courseSet) {
            System.out.println(course);
        }
    }


    public void convertHashMapToTreeMap() {
        sortedMap = new TreeMap<>(studentMap);
        System.out.println("HashMap converted to TreeMap (Sorted by ID) ");

        for (Student s : sortedMap.values()) {
            System.out.println(s);
        }
    }
}
