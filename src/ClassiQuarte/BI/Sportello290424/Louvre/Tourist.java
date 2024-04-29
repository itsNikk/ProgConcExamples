package ClassiQuarte.BI.Sportello290424.Louvre;

public class Tourist extends Thread {

    private Museum museum;

    public Tourist(String name, Museum museum) {
        //super(name); same as below
        setName(name);
        this.museum = museum;
    }

    @Override
    public void run() {
        try {
            //1) aspetto un po'
            sleep((int) (Math.random() * (4000 - 1000)) + 1000);
            System.out.println(getName() + " aspetta un po'...");
            //2) cerco di entrare nel museo
            museum.enter();
            //3) Guardo il quadro per un po'
            sleep((int) (Math.random() * (500 - 200)) + 200);
            //4) esco
            museum.exit();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
