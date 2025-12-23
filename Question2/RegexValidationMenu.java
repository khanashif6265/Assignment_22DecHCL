package Question2;
import java.util.Scanner;
import java.util.regex.Pattern;
public class RegexValidationMenu {
    private static final String MOBILE_REGEX = "^[6-9][0-9]{9}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{5,15}$";
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- REGEX VALIDATION MENU ---");
                System.out.println("1. 6265004592");
                System.out.println("2. akas6365@gmail.com");
                System.out.println("3. aka@123");
                System.out.println("4. Akash@3434");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number:");

                        String mobile = sc.nextLine();

                        if (Pattern.matches(MOBILE_REGEX, mobile)) {
                            System.out.println("Welcome Valid Mobile Number ");

                        } else {
                            System.out.println("Invalid Mobile Number ");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        if (Pattern.matches(EMAIL_REGEX, email)) {
                            System.out.println("Welcome! Valid Email ID ");
                        } else {
                            System.out.println("Invalid Email ID ");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();
                        if (Pattern.matches(USERNAME_REGEX, username)) {
                            System.out.println("Welcome! Valid Username ");
                        } else {
                            System.out.println("Invalid Username ");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Password:");
                        
                        String password = sc.nextLine();

                        if (Pattern.matches(PASSWORD_REGEX, password)) {
                            System.out.println("Welcome! Strong Password");
                        } else {
                            System.out.println("Invalid Password");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you! Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: Please enter valid input!");
                sc.nextLine(); // clear buffer
            }
        }
    }

}
