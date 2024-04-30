package ClassiQuarte.BI.Esercizi.MagazzinoInsolito;

public class Supplier extends Thread {

    private Warehouse warehouse;

    public Supplier(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            warehouse.supplyGoods(
                    (int) (Math.random() * (10 - 1)) + 1);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
