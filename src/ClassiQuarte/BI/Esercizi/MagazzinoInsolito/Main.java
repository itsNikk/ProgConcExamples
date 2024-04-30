package ClassiQuarte.BI.Esercizi.MagazzinoInsolito;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse(6);

        ArrayList<Supplier> suppliers = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        final int NUM_SUPPLIERS = 10;
        final int NUM_CLIENTS = 10;

        for (int i = 0; i < NUM_SUPPLIERS; i++) suppliers.add(new Supplier("Supplier#" + (i + 1), warehouse));
        for (int i = 0; i < NUM_CLIENTS; i++) clients.add(new Client("Clients#" + (i + 1), warehouse));

        //for (Supplier supplier : suppliers) supplier.start();
        for (int i = 0; i < suppliers.size(); i++) suppliers.get(i).start();
        for (int i = 0; i < clients.size(); i++) clients.get(i).start();

        //for (Supplier supplier : suppliers) supplier.join();
        for (int i = 0; i < suppliers.size(); i++) suppliers.get(i).join();
        for (int i = 0; i < clients.size(); i++) clients.get(i).join();


        System.out.println("Main chiude");

    }

}
