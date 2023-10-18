package PoolOfResources;

public class ResourceThread extends Thread {

    private final int TIMES = 2;
    private ResourceManager manager;

    public ResourceThread(String name, ResourceManager manager) {
        super(name);
        this.manager = manager;
    }


    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            try {
                //lemme try to get a resource....
                int resource = manager.request();
                //if I obtain it, lemme hold it for a while...
                sleep(500 + (long) (Math.random() * 1000));
                //and then I release it...
                manager.release(resource);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                //maybe we could do something more useful to handle the exception this time...
            }
        }
    }
}
