package ClassiQuarte.BI.Esercizi.AttesaConTimeout;

public class Main {
    public static void main(String[] args) {
        Thread even = new EvenPrinterThread("EvenPrinterThread");
        Thread odd = new OddPrinterThread("OddPrinterThread");

        even.start();
        odd.start();

        try {
            Thread.sleep(3000);
            if (even.isAlive() || odd.isAlive()) {
                even.interrupt();
                odd.interrupt();
                System.out.println("Il main termina forzatamente i Thread ed il programma.");
            } else {
                System.out.println("Il main termina :)");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrotto mentre in sleep");
        }
    }
}
