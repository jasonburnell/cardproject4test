package p1;

public class Main {


        static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        static String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"};
        public static void main(String[] args)
        {
            int[] deck = new int[52];
            unwrap(deck);
            shuffle(deck);
            final int CARDS_PER_HAND = 13;
            int[] north = deal(deck, CARDS_PER_HAND, CARDS_PER_HAND * 0);
            showHand(north, "North");
            int[] east = deal(deck, CARDS_PER_HAND, CARDS_PER_HAND * 1);
            showHand(east, "East");
            int[] south = deal(deck, CARDS_PER_HAND, CARDS_PER_HAND * 2);
            showHand(south, "South");
            int[] west = deal(deck, CARDS_PER_HAND, CARDS_PER_HAND * 3);
            showHand(west, "West");
        }
        public static void unwrap(int[] pack)
        // Initialize the deck - creates an array for the deck that is 52 cards long (0-51)
        {
            for (int i = 0; i < pack.length; i++)
                pack[i] = i;
        }
        public static void shuffle(int[] pack)
        //Shuffle the deck by switching places of a card with another random card.
        {
            for (int i = 0; i < pack.length; i++)
            {
                int index = (int) (Math.random() * pack.length);
                int temp = pack[i];
                pack[i] = pack[index];
                pack[index] = temp;
            }
        }
        public static int[] deal(int[] deck, int n, int offset)
        //Deal “n” cards offset from the beginning of the deck.  Return the hand dealt as an array of integers.
        {
            int[] hand = new int[13];
            for (int i = (0); i < n; i++)
            {
                hand[i] = deck[(i + offset)];
            }
            return hand;
        }
        public static void showHand(int[] hand, String player)
        //Show a player’s hand sorted by suit and rank.  The name of the player is passed as a string.
        {
            System.out.println(player + " was dealt: ");
            for (int i = 0; i < 13; i++)
            {
                System.out.print(hand[i] + " ");
                System.out.print(ranks[hand[i] / 13] + " of ");
                if (hand[i] / 13 < 1)
                    System.out.println(suits[0]);
                else if (hand[i] / 13 < 2)
                    System.out.println(suits[1]);
                else if (hand[i] / 13 < 3)
                    System.out.println(suits[2]);
                else if (hand[i] / 13 < 4)
                    System.out.println(suits[3]);
            }
            System.out.println("\n");
        }
    }


