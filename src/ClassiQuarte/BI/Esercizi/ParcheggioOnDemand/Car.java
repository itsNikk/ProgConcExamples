package ClassiQuarte.BI.Esercizi.ParcheggioOnDemand;

public class Car extends Thread {
    private ParcheggioOnDemand parcheggioOnDemand;

    public Car(String name, ParcheggioOnDemand parcheggioOnDemand) {
        super(name); //super(name) = setName(name)
        this.parcheggioOnDemand = parcheggioOnDemand;
    }

    @Override
    public void run() {
        int driveTime = (int) (Math.random() * (4000 - 1000)) + 1000;
        int parkTime = (int) (Math.random() * (1500 - 500)) + 500;
        try {
            //1) guida pe un po'
            sleep(driveTime);
            //2) cerca di accedere al parcheggio
            parcheggioOnDemand.enterParkingLot(0);
            //3) se ce la fa, posteggia per un po'
            sleep(parkTime);
            //4) libera il posto
            parcheggioOnDemand.exitParkingLot(0);
        } catch (InterruptedException r) {
            System.out.println(getName() + " interrotto,");
        }
    }
}
