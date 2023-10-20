import java.util.*;

public class bai7 {
    public static void main(String[] args) {
        // Generate a sequence of N random integers, each <= M and no two numbers are equal.
        int N = 10;
        int M = 20;

        // Create a deck of 52 cards and shuffle it.
        List<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        Collections.shuffle(deck);
        System.out.println(deck);
    }
}