package ClassiQuinte.GeneralitaDeiThread;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println(t);
        t.setName("UnAltroNome");
        System.out.println(t);

        System.out.println();
        System.out.println("Priorità gestite da Java:");
        System.out.println("Min Priority: " + Thread.MIN_PRIORITY);
        System.out.println("Norm Priority: " + Thread.NORM_PRIORITY);
        System.out.println("Max Priority: " + Thread.MAX_PRIORITY);
    }
}