package Ex01_WorkingWithAbstraction.P06_GreedyTimes;

import java.util.*;

import static Ex01_WorkingWithAbstraction.P06_GreedyTimes.ItemType.getItem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            //get the item
            ItemType itemType = getItem(name);
            //create the item
            Item item = new Item(itemType, name, amount);
            //put the item in the bag
            bag.add(item);

        }

        bag.print();
    }
}