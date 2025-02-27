import java.util.*;

class CardCollection {
    Map<String, List<String>> cards = new HashMap<>();

    void add(String symbol, String card) {
        cards.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
    }

    List<String> getCards(String symbol) {
        return cards.getOrDefault(symbol, new ArrayList<>());
    }

    public static void main(String[] args) {
        CardCollection cc = new CardCollection();
        cc.add("Hearts", "A");
        cc.add("Hearts", "K");
        cc.add("Spades", "Q");

        System.out.println("Cards in Hearts: " + cc.getCards("Hearts"));
        System.out.println("Cards in Spades: " + cc.getCards("Spades"));
    }
}
