package ClassiQuarte.AI.ProdConsExample;

public class Main {
    public static void main(String[] args) {
        CellaCondivisa c = new CellaCondivisa();
        Producer p = new Producer(c);
        Consumer cons = new Consumer(c);

        p.start();
        cons.start();
    }
}
