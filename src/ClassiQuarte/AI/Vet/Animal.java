package ClassiQuarte.AI.Vet;

public class Animal extends Thread {

    private String animalType; //{cat or dog}
    private VetOffice vetOffice;

    public Animal(VetOffice vetOffice) {
        this.vetOffice = vetOffice;
        this.animalType = getRandomAnimalType(0.1);
    }

    @Override
    public void run() {
        try {
            vetOffice.enterRoom(this);
            int sleepTime = (int) (Math.random() * (6000 - 2000)) + 2000;
            sleep(sleepTime);
            vetOffice.exitRoom(this);
        } catch (InterruptedException t) {
            System.out.println(Thread.currentThread().getName() + " interrotto.");
        }
    }

    private String getRandomAnimalType(double dogProbability) {
        /*if (Math.random() < dogProbability) return "Dog";
        else return "Cat";*/

        //Operatore ternario
        return Math.random() < dogProbability ? "Dog" : "Cat";
    }

    public String getAnimalType() {
        return animalType;
    }
}
