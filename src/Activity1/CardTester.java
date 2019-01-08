package Activity1;

/**
 * Created by Teacher on 1/7/2019.
 */
public class CardTester {
   public static void main(String[] args) {
       Card[] cards = {
               new Card("Jack", "Hearts", 0),
               new Card("Queen", "Diamonds", 0),
               new Card("Ace", "Spades", 1),
       };

       for (Card card : cards) {
           System.out.println(card.suit());
           System.out.println(card.rank());
           System.out.println(card.pointValue());
           // Always returns true because card is compared with itself
           System.out.println(card.matches(card));
       }

       System.out.println(cards[0].matches(cards[1]));
   }
}
