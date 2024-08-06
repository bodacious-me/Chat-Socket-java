import java.util.Scanner;

public class Account {
    public static void Dashboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome To The Dashboard ");
        Client.NewClient();
        int Answer = scanner.nextInt();
        switch (Answer) {
            case 1:
                Menu.NewMenu();

            case 2:

                break;

            default:
                System.out.println("Invalid Iput");
                Menu.NewMenu();

                break;
        }
        scanner.close();

    }
}
