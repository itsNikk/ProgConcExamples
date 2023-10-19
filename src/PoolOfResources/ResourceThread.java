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
            int resource = -1;
            try {
                //lemme try to get a resource....
                resource = manager.request();
                //if I obtain it, lemme hold it for a while...
                sleep(500 + (long) (Math.random() * 1000));
                //and then I release it...
                manager.release(resource);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
                //This check is actually not that necessary but still... ;)
                // (WHY is this check not that important?)
                if (resource >= 0) manager.release(resource);
            }
        }
    }
}
