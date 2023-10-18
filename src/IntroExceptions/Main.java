package IntroExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a, b;
        System.out.print("Inserire a:> ");
        try {
            a = s.nextInt();
        } catch (InputMismatchException e) {
            a = 0;
            s.nextLine(); //utile per far avanzare lo scanner, così lo si "resetta".
        }

        System.out.print("Inserire b:> ");
        try {
            b = s.nextInt();
        } catch (InputMismatchException e) {
            b = 0;
            s.nextLine();
        }

        System.out.println("Inserire operazione:> ");
        String op = s.next();

        System.out.println(a + " " + op + " " + b);



    }
}
