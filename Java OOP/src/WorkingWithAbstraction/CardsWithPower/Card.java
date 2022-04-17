package WorkingWithAbstraction.CardsWithPower;

public class Card {
    private int power;
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower(){
        return this.rank.getRank() + this.suit.getSuit();
    }
}
