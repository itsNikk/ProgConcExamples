package ConcEx1;

//Monitor
public class Pizzaiolo {

    private int time;
    private boolean pizzaOrdered;
    private boolean pizzaBoyAvailable;

    public synchronized void orderPizza(int time) throws InterruptedException {
        while (!pizzaBoyAvailable) wait();
        this.time = time;
        pizzaOrdered = true;
        notify();
        wait();
    }

    public synchronized void manage() throws InterruptedException {
        System.out.println("No pizza to create :(");
        pizzaBoyAvailable = true;
        while (!pizzaOrdered) wait();
        System.out.println("Someone ordered, YAI! :)");
        pizzaBoyAvailable = false;
        System.out.println("pizza pronta tra " + time / 1000 + " sec.");
        Thread.sleep(time);
        System.out.println("PRONTA!");
        pizzaBoyAvailable = true;
        notify();
    }


}
