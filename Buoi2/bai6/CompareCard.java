import java.util.*;

// đối tượng comparecard để so sánh 2 Card với nhau
class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // sắp xếp theo rank trước, nếu rank giống nhau thì sắp xếp theo suit
        if (card1.getRank().equals(card2.getRank())) {
            return card1.getSuit().compareTo(card2.getSuit());
        } else {
            return card1.getRank().compareTo(card2.getRank());
        }
    }
}