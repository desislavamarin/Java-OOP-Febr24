package Ex01_WorkingWithAbstraction.P06_GreedyTimes;

import java.util.*;

public class Bag {

    private static final Comparator<Item> COMPARE_ITEM_BY_NAME = Comparator.comparing(Item::getName);
    private static final Comparator<Item> COMPARE_ITEM_BY_AMOUNT = Comparator.comparing(Item::getAmount);

    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void add(Item itemToAdd) {
        if(canAdd(itemToAdd)) {
            Item item = getItem(itemToAdd);
            if (item == null) {
                this.items.add(itemToAdd);
            } else {
                item.setAmount(item.getAmount() + itemToAdd.getAmount());
            }
        }
    }

    public void print() {
        getAllTypesAmount().entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("<%s> $%d%n", entry.getKey(), entry.getValue());
                    this.items.stream()
                            .filter(item -> item.getItemType().equals(entry.getKey()))
                            .sorted(COMPARE_ITEM_BY_NAME.reversed().thenComparing(COMPARE_ITEM_BY_AMOUNT))
                            .forEach(item -> {
                                System.out.printf("##%s - %d%n", item.getName(), item.getAmount());
                            });
                });
    }

    public Item getItem(Item itemToAdd) {
        return this.items.stream()
                .filter(item -> item.equals(itemToAdd))
                .findFirst()
                .orElse(null);
    }

    public boolean canAdd(Item item) {
        //check for capacity
        if (this.capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }
        if (item.getItemType() == null) {
            return false;
        }

        switch (item.getItemType()) {
            case Gem :
                if (item.getAmount() + getTotalAmountByType(ItemType.Gem) > getTotalAmountByType(ItemType.Gold)) {
                    return false;
                }
                break;
            case Cash:
                if (item.getAmount() + getTotalAmountByType(ItemType.Cash) > getTotalAmountByType(ItemType.Gem)) {
                    return false;
                }
                break;
        }
        return true;
    }

    public long getTotalAmount() {
        return this.items.stream()
                .mapToLong(Item::getAmount)
                .sum();
    }

    private long getTotalAmountByType(ItemType itemType) {
        return this.items.stream()
                .filter(item -> item.getItemType().equals(itemType))
                .mapToLong(Item::getAmount)
                .sum();
    }

    private Map<ItemType, Long> getAllTypesAmount() {
        Map<ItemType, Long> map = new HashMap<>();
        for (ItemType itemType : ItemType.values()) {
            map.put(itemType, getTotalAmountByType(itemType));
        }
        return map;
    }

}
