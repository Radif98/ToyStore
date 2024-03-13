import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore()
    {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public Toy creatToy(int id, String name, int quantity, double weight)
    {
        Toy toy = new Toy(id, name, quantity, weight);
        return toy;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void listToys() {
        System.out.println("Инвентарь магазина:");
        for (Toy toy : toys) {
            System.out.println(toy.getName() + " - weight: " + toy.getWeight());
        }
    }

    public void setToyWeight(int id, double weight)
    {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play()
    {
        // calculate total weight
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        // generate random number
        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        // find the prize toy
        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }

        // add the prize toy to the list of prize toys
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToys.add(prizeToy);

            // decrement the quantity of the prize toy
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }

    public void getPrizeToy() throws IOException
    {
        if (prizeToys.size() > 0) {
            // remove the first prize toy from the list of prize toys
            Toy prizeToy = prizeToys.remove(0);

            // write the prize toy to a file
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}
