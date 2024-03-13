import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        ToyStore store = new ToyStore();

        // add some toys
        Toy toy1 = store.creatToy(1, "Toy 1", 10, 20);
        store.addToy(toy1);
        Toy toy2 = store.creatToy(2, "Toy 2", 5, 10);
        store.addToy(toy2);
        Toy toy3 = store.creatToy(3, "Toy 3", 20, 70);
        store.addToy(toy3);

        //Inventars
        store.listToys();

        // set the weight of a toy
        store.setToyWeight(2, 30);

        //Inventars
        store.listToys();

        // play the game
        store.play();

        // get the prize toy
        try {
            store.getPrizeToy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}