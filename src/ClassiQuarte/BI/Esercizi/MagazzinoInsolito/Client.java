package ClassiQuarte.BI.Esercizi.MagazzinoInsolito;

public class Client extends Thread {

    private Warehouse warehouse;

    public Client(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            int value = warehouse.getGoods();
        } catch (InterruptedException e) {
            System.out.println(getName() + " intgerrotto");
        }
    }
}
