package ClassiQuinte.ThreadRecap.InterruptMain;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1("T1");
        Thread3 t3 = new Thread3("T3");

        t1.start();
        t3.start();

        Thread.sleep(3000);
        t3.interrupt();
        t1.interrupt();
        System.out.println("Main: Interrompo tutti i thread e chiudo l'applicazione.");
    }
}
