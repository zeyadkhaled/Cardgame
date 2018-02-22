package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Zeyad Abuamer
// date: 20/02/18

public class Cards
{
  final int NOOFCARDSINFULLPACK = 52;
  
  // properties
  Card[] cards;
  int    valid;  // number of cards currently in collection
  
  // constructors
  public Cards( boolean fullPack)
  {
    cards = new Card[ NOOFCARDSINFULLPACK ];
    valid = 0;
    
    if ( fullPack)
      createFullPackOfCards();
  }
  
  // methods
  public Card getTopCard()
  {
    Card tmp;
    
    if ( valid <= 0)
      return null;
    else
    {
      valid--;
      tmp = cards[valid];
      cards[valid] = null;
      return tmp;
    }
  }
  
  public boolean addTopCard( Card c)
  {
    if ( valid < cards.length)
    {
      cards[valid] = c; 
      valid++;
      return true;
    }
    return false;
  }
  
  private void createFullPackOfCards()
  {
    for ( int i = 0; i < cards.length; i++) {
      addTopCard( new Card(i) );
    }
    shuffle();
  }
  
  public void shuffle()
  {
    Card tmp = new Card(0);
    Card tmp2 = new Card(0);
    for ( int i = 0; i < 100; i++) {
      int rand = (int) (Math.random() * 52);
      int rand2 = (int) (Math.random() * 52);
      tmp = cards[rand];
      tmp2 = cards[rand2];
      cards[rand] = tmp2;
      cards[rand2] = tmp;
    }
  } 
} 
