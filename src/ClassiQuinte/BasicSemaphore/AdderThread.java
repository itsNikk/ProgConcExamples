package ClassiQuinte.BasicSemaphore;

public class AdderThread extends Thread {

    private final SharedResource resource;

    public AdderThread(String name, SharedResource resource) {
        setName(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            resource.Add(1);
        }
    }
}
