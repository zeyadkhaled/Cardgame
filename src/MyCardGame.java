import java.util.Scanner;
import cardgame.*;

// MyCardGame - provides a menu allowing any of the players to play their card,
//              an option to see the score card, and one to quit the game at any time.
//              When the game is over it dislays the winners.
// author: Zeyad Abuamer
// date: 20/02/18
public class MyCardGame
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    System.out.println( "Start of MyCardGame\n");
    
    // CONSTANTS
    final int MENU_EXIT    = 0;
    final int MENU_PLAY_P1 = 1;
    final int MENU_PLAY_P2 = 2;
    final int MENU_PLAY_P3 = 3;
    final int MENU_PLAY_P4 = 4;
    final int MENU_SCORES  = 5;
    
    // VARIABLES
    Player     p1, p2, p3, p4;
    CardGame   game;
    int        selection;
    
    // PROGRAM CODE
    
    // create players...
    p1 = new Player( "Zeyad");
    p2 = new Player( "David");
    p3 = new Player( "Elon");
    p4 = new Player( "Scarlet");
    
    // create game with the 4 players...
    game = new CardGame( p1, p2, p3, p4);
    
    // display menu, get and process selection, until exit
    do 
    {
      // display menu
      System.out.println();
      System.out.println( "MyCardGame @  Round: " + ( game.getRoundNo() + 1) 
                           + "\t TurnOfPlayer: " + ( game.getTurnOfPlayerNo() + 1) );
      System.out.println();
      System.out.println( MENU_PLAY_P1 + " - " + p1.getName() + " plays" );
      System.out.println( MENU_PLAY_P2 + " - " + p2.getName() + " plays" );
      System.out.println( MENU_PLAY_P3 + " - " + p3.getName() + " plays" );
      System.out.println( MENU_PLAY_P4 + " - " + p4.getName() + " plays" );
      System.out.println( MENU_SCORES  + " - Show scores" );
      
      // ask for and get selection
      System.out.println();
      System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
      selection = scan.nextInt();
      
      // process selection
      if ( selection == MENU_PLAY_P1 )
        play( p1, game);
      
      else if ( selection == MENU_PLAY_P2 )
        play( p2, game);
      
      else if ( selection == MENU_PLAY_P3 )
        play( p3, game);
      
      else if ( selection == MENU_PLAY_P4 )
        play( p4, game);
      
      else if ( selection == MENU_SCORES )
        System.out.println( game.showScoreCard());
      
      else if ( selection != MENU_EXIT)
        System.out.println( "Invalid selection! \n" );
      
    } while ( selection != MENU_EXIT  && !game.isGameOver());
    
    if (game.isGameOver())
    {
      System.out.print("Winner is : ");
      Player[] players = game.getWinners();
      for (Player p : players)
      {
        System.out.println( p.getName());
      }
    }
    
    System.out.println( "\nEnd of MyCardGame\n" );   
  }
  
  // get the card, c, that player p wants to play
  // pass c to the game, see if it accepted c from p
  // if game didn't accept the card, give c back to the player! 
  // return accepted.
  private static boolean play( Player p, CardGame game)
  {
    Card       c;
    boolean    accepted;
    if ( ( !game.isGameOver()) && ( game.isTurnOf(p))) {
      if ( game.playTurn( p , p.playCard())) {
        accepted = true;
      }
      else
        accepted = false;
    }
    else {
      System.out.println("It's not your turn " + p.getName() );
      accepted = false;
    }
    return accepted;
  }
  
}
