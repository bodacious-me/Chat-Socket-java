import java.util.HashMap;
import java.util.Scanner;

public class Operations {

    private static HashMap<String, String> UserDataBase = new HashMap<>();

    public static void SignUp() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please Enter A Username: ");
            String Username = scanner.nextLine();
            String SearchKey = Username;
            if (UserDataBase.containsKey(SearchKey)) {
                System.out.println("User Already Exists!");
                Menu.NewMenu();

            } else {
                System.out.println("Please Enter A Password: ");
                String Password = scanner.nextLine();
                UserDataBase.put(Username, Password);
                System.out.println("Account Created");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menu.NewMenu();
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    public static void LogIn() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please Enter A Username: ");
            String Username = scanner.nextLine();
            String SearchKey = Username;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (UserDataBase.containsKey(SearchKey)) {
                System.out.println("Please Enter A Password: ");
                String Password = scanner.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if (UserDataBase.get(Username).equals(Password)) {

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Account.Dashboard();

                } else {
                    System.out.println("Wrong Password!");
                    Menu.NewMenu();

                }

            } else {

                System.out.println("Username Doesn't Exist!");
                Menu.NewMenu();
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    public static void ShowUsers() {
        System.out.println("\n\n\n");

        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (String i : UserDataBase.keySet()) {
            System.out.println(i);
        }
        System.out.println("\n\n\n");
        Menu.NewMenu();

    }

}
