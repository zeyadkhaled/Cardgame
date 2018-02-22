package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Zeyad Abuamer
// date: 20/02/18
public class CardGame
{
  // properties
  Cards             fullPack;
  ArrayList<Player> players;
  ScoreCard         scoreCard;
  Cards[]           cardsOnTable;
  int               roundNo;
  int               turnOfPlayer;
  
  // constructors
  public CardGame( Player p1, Player p2, Player p3, Player p4)
  {
    fullPack = new Cards( true);
    players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);
    scoreCard = new ScoreCard( players.size());
    roundNo = 0;
    turnOfPlayer = 0;
    cardsOnTable = new Cards[ players.size()];
    
    //Create empty Cards set for every player
    for (int i = 0; i < cardsOnTable.length; i++)
    {
      cardsOnTable[i] = new Cards(false);
    }
    
    //Give every player 13 cards
    for (int j = 0; j < 13; j++)
    {
      for (int k = 0; k < players.size(); k++)
      {
        players.get(k).add(fullPack.getTopCard());
      }
    }
  }
  
  // methods
  public boolean playTurn( Player p, Card c)
  {
    Card temp = new Card(0);
    if ((!isGameOver()) && (isTurnOf(p))) {
      System.out.println( p.getName() + " played " + c.toString());
      cardsOnTable[turnOfPlayer].addTopCard(c);
      
      // End of the round
      if (turnOfPlayer == 3) {
        roundNo++;
        
        //Find highest played card in all of the players' piles
        for (int i = 0; i < players.size(); i++) {
          temp = new Card(cardsOnTable[i].cards[ cardsOnTable[i].valid - 1].compareTo( temp));
        }
        
        // Update score of the player with the highest card
        for (int j = 0; j < players.size(); j++) {
          if (cardsOnTable[j].cards[cardsOnTable[j].valid - 1].equals(temp)) 
            scoreCard.update(j,1); 
        }
      }
      
      turnOfPlayer++;
      turnOfPlayer = turnOfPlayer % 4;
      return true;
    }
    else
      return false;
  }
  
  public boolean isTurnOf( Player p)
  {
    if ( players.get( turnOfPlayer).getName().equals( p.getName()))
      return true;
    else
      return false;
  }
  
  public boolean isGameOver()
  {
    if (roundNo >= 13)
      return true;
    else
      return false;
  }
  
  public int getScore( int playerNumber)
  {
    return scoreCard.getScore(playerNumber);
  }
  
  public String getName( int playerNumber)
  {
    return players.get(playerNumber).getName();
  }
  
  public int getRoundNo()
  {
    return roundNo;
  }
  
  public int getTurnOfPlayerNo()
  {
    return turnOfPlayer;
  }
  
  public Player[] getWinners()
  {
    int[] temp = scoreCard.getWinners();
    Player[] last = new Player[temp.length];
    for (int i = 0; i < temp.length; i++) {
      last[i] = players.get(temp[i]);
    }
    return last;
  }
  
  public String showScoreCard()
  {
    return scoreCard.toString();
  }
  
}