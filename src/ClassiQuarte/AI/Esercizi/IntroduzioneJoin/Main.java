package ClassiQuarte.AI.Esercizi.IntroduzioneJoin;

public class Main {
    public static void main(String[] args) {
        Thread even = new EvenPrinterThread("EvenPrinter");
        Thread odd = new OddPrinterThread("OddPrinter");

        even.start();
        odd.start();

        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrotto mentre in join");
        }

        System.out.println("Il main termina :)");
    }
}
