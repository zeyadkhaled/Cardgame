package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Zeyad Abuamer
// date: 20/02/18
public class ScoreCard
{
  // properties
  int[] scores;
  
  // constructors
  public ScoreCard( int noOfPlayers)
  {
    scores = new int[noOfPlayers];
    
    // init all scores to zero
    for ( int i = 0; i < scores.length; i++)
      scores[i] = 0;
  }
  
  // methods
  public int getScore( int playerNo)
  {
    return scores[ playerNo];
  }
  
  public void update( int playerNo, int amount)
  {
    scores[playerNo] += amount;
  }
  
  public String toString()
  {
    String s;
    s = "\n"
      + "_____________\n"
      + "\nPlayer\tScore\n"
      + "_____________\n";
    
    for ( int playerNo = 0; playerNo < scores.length; playerNo++)
    {
      s = s + playerNo + "\t" + scores[playerNo] + "\n";
    }
    
    s += "_____________\n";
    return s;
  }
  
  public int[] getWinners()
  {
    int count = 0;
    int max = 0;
    
    for ( int i = 0; i < scores.length; i++) {
      max = Math.max(max, scores[i]);
    }
    
    for (int i = 0; i < scores.length; i++) {
      if (max == scores[i])
        count++;
    }
    
    int[] last = new int[count];
    for (int i = 0 , j = 0; i < scores.length; i++) {
      if ( max == scores[i]) {
        last[j] = i;
        j++;
      }
    }
    return last;
  } 
}
