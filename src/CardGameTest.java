import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Zeyad Abuamer
// date: 20/02/18
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        //System.out.println( c);
        //System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        //System.out.println(cards.addTopCard( c));
        cards.shuffle(); 
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        //System.out.println( "\n" + scores );
        
        // test Player class
        p = new Player( "Zeyad");
        p.add(c);
        Card temp = p.playCard();
        //System.out.println( temp);
        
        // test CardGame class too?
        Player p1, p2, p3, p4;
        p1 = new Player("test1");
        p2 = new Player("test2");
        p3 = new Player("test3");
        p4 = new Player("test4");
        
        game = new CardGame(p1, p2, p3, p4);
        System.out.println( game.playTurn(p1, cards.getTopCard()));
        System.out.println( game.playTurn(p2, cards.getTopCard()));
        game.playTurn(p3, cards.getTopCard());
        System.out.println( game.playTurn(p3, cards.getTopCard()));
        game.playTurn(p4, cards.getTopCard());
        System.out.println( game.showScoreCard() );
        System.out.println( game.isGameOver() );
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        //System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
