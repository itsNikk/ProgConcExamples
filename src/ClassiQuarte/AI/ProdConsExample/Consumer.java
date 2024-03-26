package ClassiQuarte.AI.ProdConsExample;

public class Consumer extends Thread {

    private CellaCondivisa cella;

    public Consumer(CellaCondivisa cellaCondivisa) {
        this.cella = cellaCondivisa;
    }

    @Override
    public void run() {
        int v;
        for (int i = 0; i < 10; i++) {
            try{
                v = cella.getValore();
                //System.out.print(" C:" + v);
            } catch (InterruptedException c){
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
