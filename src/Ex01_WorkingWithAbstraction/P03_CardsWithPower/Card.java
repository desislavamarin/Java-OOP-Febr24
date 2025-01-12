package Ex01_WorkingWithAbstraction.P03_CardsWithPower;

public class Card {

    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public Card(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    public int getPower() {
        return rankPowers.getValue() + suitPowers.getValue();
    }

    public void printCard() {
        System.out.printf("Card name: %s of %s; Card power: %d", rankPowers, suitPowers, getPower());
    }
}
