package ClassiQuinte.AspettareLaTerminazione;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.err.println("Thread pronti");
        RunnerThread t1 = new RunnerThread("t1");
        RunnerThread t2 = new RunnerThread("t2");
        RunnerThread t3 = new RunnerThread("t3");

        System.err.println("Thread partiti");
        t1.start();
        t2.start();
        t3.start();

        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            //BRUTTO, ma efficace.. perchè?
            //ora siamo sicuri che il main sarà sempre l'ultimo a terminare
            //come miglioriamo/scriviamo meglio questa soluzione?
            Thread.sleep(100);
        }
        System.err.println("Chiusura MAIN");
    }
}
