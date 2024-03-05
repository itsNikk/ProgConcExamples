package ClassiQuarte.AI.StampaATurno;

import java.nio.channels.InterruptedByTimeoutException;

public class Main {
    public static void main(String[] args) {

        PrinterThread printerThread1 = new PrinterThread("PrinterThread_1");
        PrinterThread printerThread2 = new PrinterThread("PrinterThread_2");
        PrinterThread printerThread3 = new PrinterThread("PrinterThread_3");

        //fa lavorare tutti i thread
        printerThread1.start();
        printerThread2.start();
        printerThread3.start();
        System.out.println("Tutti i thread sono partiti");

        //quando hanno finito tutti, chiude l'applicazione
        //Soluzione 1
        /*while (printerThread1.isAlive() || printerThread2.isAlive() || printerThread3.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException a) {
                break;
            }
        }*/
        //Soluzione 2 - TOP!
        try {
            printerThread1.interrupt();
            printerThread2.interrupt();
            printerThread3.interrupt();

            printerThread1.join();
            printerThread3.join();
            printerThread2.join();
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Main: Chiudo l'applicazione.");
    }
}
