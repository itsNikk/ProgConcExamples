package ClassiQuarte.AI.ProdConsExample;

public class Main {
    public static void main(String[] args) {
        CellaCondivisa c = new CellaCondivisa();
        Producer p1 = new Producer("P1", c);
        Producer p2 = new Producer("P2", c);
        Consumer cons1 = new Consumer("C1",c);
        Consumer cons2 = new Consumer("C2",c);

        p1.start();
        p2.start();
        cons1.start();
        cons2.start();
    }
}
