import java.util.*;

// đối tượng Card
class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        // sắp xếp theo rank trước, nếu rank giống nhau thì sắp xếp theo suit
        if (this.rank.equals(otherCard.getRank())) {
            return this.suit.compareTo(otherCard.getSuit());
        } else {
            return this.rank.compareTo(otherCard.getRank());
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}