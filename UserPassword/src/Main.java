
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Runtime rs = Runtime.getRuntime();
        User[] users = new User[4];

        int incercari = 0;

        users[0] = new User();
        users[0].user = "ionel";
        users[0].parola = "a";


        users[1] = new User();
        users[1].user = "maria";
        users[1].parola = "b";

        users[2] = new User();
        users[2].user = "ioana";
        users[2].parola = "c";

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
            }else{
                System.out.println("Mai incearca!");
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
