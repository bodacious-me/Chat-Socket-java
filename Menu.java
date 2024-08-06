import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void NewMenu() {
        System.out.println("Please Enter The Related Operation Number");
        System.out.println("\n1.Sign Up \n2.Log In\n3.Show Users\n4.Exit");
        try (Scanner scanner = new Scanner(System.in);) {

            int Answer = scanner.nextInt();

            switch (Answer) {
                case 1:
                    Operations.SignUp();

                    break;
                case 2:
                    Operations.LogIn();
                    break;
                case 3:
                    Operations.ShowUsers();
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Invalid Input Number");
                    Menu.NewMenu();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
