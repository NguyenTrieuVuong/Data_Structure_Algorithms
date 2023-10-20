import java.util.*;

public class Deck {
    public static void main(String[] args) {
        // tạo bộ bài gồm 52 quân bài
        List<Card> deck = new ArrayList<>();
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }

        // sắp xếp bộ bài bằng phương thức sort và đối tượng CompareCard
        Collections.sort(deck, new CompareCard());
        System.out.println("Sorted deck:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // sắp xếp bộ bài bằng phương thức sort và Comparable
        Collections.shuffle(deck); 
        System.out.println("Shuffle deck:");
        for (Card card : deck) {
            System.out.println(card);
        }
        Collections.sort(deck);
        System.out.println("Sorted deck using Comparable:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}