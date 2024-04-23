package ClassiQuarte.AI.Vet;

public class VetOffice {

    private int dogCount;
    private int catCount;

    public VetOffice() {
        catCount = dogCount = 0;
    }

    public synchronized void enterRoom(Animal animal) throws InterruptedException {
        if (animal.getAnimalType().equals("Dog")) {
            //quando fermo un cane? Quando c'è almeno un gatto o più di 4 cani
            while (catCount > 0 || dogCount >= 4) wait();

            dogCount++;
            System.out.println("Un cane è entrato. Cani totali: " + dogCount + " Gatti totali: " + catCount);

        } else if (animal.getAnimalType().equals("Cat")) {
            //quando fermo un gatto? "Un gatto non può entrare nella sala se sono già presenti un cane o un gatto"
            while (catCount > 0 || dogCount > 0) wait();

            catCount++;
            System.out.println("Un gatto è entrato. Cani totali: " + dogCount + " Gatti totali: " + catCount);
        }
    }

    public synchronized void exitRoom(Animal animal) {
        switch (animal.getAnimalType()) {
            case "Dog":
                dogCount--;
                System.out.println("Un cane è uscito. Cani totali: " + dogCount + " Gatti totali: " + catCount);
                break;
            case "Cat":
                catCount--;
                System.out.println("Un gatto è uscito. Cani totali: " + dogCount + " Gatti totali: " + catCount);
                break;
        }
        notifyAll();
    }
}
