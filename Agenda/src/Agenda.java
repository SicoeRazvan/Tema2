import java.util.Scanner;

public class Agenda {
    static Person[] persons = new Person[3];
    static int pozitie = 0;

    public static void main(String[] args) {
        int optiune;

        do {
            afisareMeniu();
            System.out.print("Optiune -> ");
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            if (optiune > 0 || optiune == 0) {
                switch (optiune) {
                    case 1: {
                        adaugare();
                        break;
                    }

                    case 2: {
                        afisare();
                        break;
                    }

                    case 3: {
                        stergere();
                        break;
                    }

                    case 4: {
                        modificare();
                        break;
                    }

                    case 5: {
                        cautare(citireNume("Cautare nume: "));
                        break;
                    }
                }
            }else{
                System.out.println("Optiune invalida");
            }
        } while (optiune != 0) ;
    }

    public static void afisareMeniu() {
        System.out.println("1. Adaugare");
        System.out.println("2. Afisare");
        System.out.println("3. Stergere");
        System.out.println("4. Modificare");
        System.out.println("5. Cautare");
        System.out.println("0. Exit");
    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String nume = scan.nextLine();
        return nume;
    }

    public static int citireTelefon(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        int telefon = scan.nextInt();
        return telefon;
    }

    public static void adaugare() {
        if (pozitie < persons.length) {
            String nume = citireNume("Nume: ");
            int telefon = citireTelefon("Telefon: ");
            persons[pozitie] = new Person();
            persons[pozitie].nume = nume;
            persons[pozitie].telefon = telefon;
            pozitie++;
        } else {
            System.out.println("Agenda e plina. Nu mai poti adauga contacte noi");
        }

    }

    public static void afisare() {
        System.out.println("Agenda:");
        for (int i = 0; i < pozitie; i++) {
            if (persons[i] != null) {
                System.out.println(persons[i].nume + " " + persons[i].telefon);
            }
        }
        System.out.print("\n");
    }

    public static int findIndex(String nume) {
        int found = -1;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {
                if (persons[i].nume.equalsIgnoreCase(nume)) {
                    found = i;
                    break;
                }
            }
        }
        return found;
    }

    public static void stergere() {
        String nume = citireNume("Da-ti numele de sters: ");
        int indexCautat;

        indexCautat = findIndex(nume);

        if(indexCautat != -1) {
            System.out.println("Am sters urmatorul contact: " + persons[indexCautat].nume);
            for (int i = indexCautat; i < persons.length-1; i++) {
                persons[i] = persons[i + 1];
            }
            pozitie--;
        }else{
            System.out.println("Nu am gasit contactul");
        }
    }

    public static void modificare() {
        Scanner scan = new Scanner(System.in);
        String nume = citireNume("Da-ti numele de modificat: ");

        int indexCautat;
        indexCautat = findIndex(nume);

        if (indexCautat != -1) {
            System.out.print("Noul nume: ");
            String noulNume = scan.nextLine();

            System.out.print("Noul telefon: ");
            int noulTelefon = scan.nextInt();

            persons[indexCautat].nume = noulNume;
            persons[indexCautat].telefon = noulTelefon;
        } else {
            System.out.println("Nu am gasit contactul in agenda!");
        }
    }

    public static void cautare(String nume) {
        boolean found = false;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {
                if (persons[i].nume.equalsIgnoreCase(nume)) {
                    System.out.println("Am gasit contactul" + "\n" + persons[i].nume + " " + persons[i].telefon);
                    found = true;
                }
            }
        }

        if (found == false) {
            System.out.println("Nu am gasit contactul in agenda!");
        }
    }
}
