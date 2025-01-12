package Ex01_WorkingWithAbstraction.P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardName = scanner.nextLine();
        String suitName = scanner.nextLine();

        RankPowers rankPowersEnum = RankPowers.valueOf(cardName);
        SuitPowers suitPowersEnum = SuitPowers.valueOf(suitName);

        Card card = new Card(rankPowersEnum, suitPowersEnum);
        card.printCard();
    }
}
