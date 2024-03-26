package ClassiQuarte.AI.ProdConsExample;

public class CellaCondivisa {
    private int valore; //il valore attualmente salvato nella cella
    private int numItems = 0; // quanti valori ho nel buffer limitato

    final int BUFFERSIZE = 1; //quanto grande è il buffer

    public synchronized int getValore() throws InterruptedException {
        if (numItems == 0) wait();
        numItems--;
        System.out.print(" C:" + valore);
        notify();
        return valore;
    }

    public synchronized void setValore(int valore) throws InterruptedException {
        if (numItems == BUFFERSIZE) wait();
        this.valore = valore;
        System.out.print(" P:" + valore);
        numItems++;
        notify();
    }
}
