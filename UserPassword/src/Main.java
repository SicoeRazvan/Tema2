
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Runtime rs = Runtime.getRuntime();
        User[] users = new User[4];

        int incercari = 0;

        users[0] = new User();
        users[0].user = "Ion";
        users[0].parola = "12345";


        users[1] = new User();
        users[1].user = "Tom";
        users[1].parola = "789";

        users[2] = new User();
        users[2].user = "Maria";
        users[2].parola = "abc";

        String u;
        String p;

        while (incercari < 3) {
            u = citireNume("user: ");
            p = citireNume("parola: ");

            if (login(users, u, p) == true) {
                System.out.println("Esti logat!");

                try {
                    rs.exec("notepad");
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            }

            incercari++;
            System.out.println("Incercari " + incercari + "\n");
        }
    }


    public static boolean login(User[] a, String u, String p) {

        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null)
                if (u.equalsIgnoreCase(a[i].user) && p.equalsIgnoreCase(a[i].parola)) {
                    found = true;
                    break;
                }
        }
        return found;
    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String nume = scan.nextLine();
        return nume;
    }
}
