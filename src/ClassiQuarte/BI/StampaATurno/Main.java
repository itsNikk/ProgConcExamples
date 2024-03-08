package ClassiQuarte.BI.StampaATurno;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadPrinter printer1 = new ThreadPrinter("PrinterThread1");
        ThreadPrinter printer2 = new ThreadPrinter("PrinterThread2");
        ThreadPrinter printer3 = new ThreadPrinter("PrinterThread3");

        printer1.start();
        printer3.start();
        printer2.start();

        /*while (printer1.isAlive() || printer2.isAlive() || printer3.isAlive()) {
            Thread.sleep(100);
        }*/
        printer2.interrupt();
        printer1.interrupt();
        printer3.interrupt();

        printer3.join();
        printer1.join();
        printer2.join();


        System.out.println("Main chiude");
    }
}
