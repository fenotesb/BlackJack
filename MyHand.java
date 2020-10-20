import java.util.*; 
import java.util.Random;
//Creates a child class for deck called MyHand
class MyHand extends Deck {
   String[] myhand;
  
  public MyHand ()
  {
 myhand =  new String[2];
  }

//creates a hand.
public void makeHand() {
  
  
//Creates the random spots people can get there hand from
Random rand = new Random();
//first card
int rand_int1 = rand.nextInt(52);
//second card
int rand_int2 = rand.nextInt(52);
//make sure the same card is not taken
while (rand_int1 == rand_int2) 
rand_int2 = rand.nextInt(52);
//Sets the hand
this.myhand[0] = super.DeckFull.get(rand_int1 ); 
this.myhand[1] = super.DeckFull.get(rand_int2 );
// used to view what hand it is
}

public String[] getHand() {
return this.myhand;
 }

public void showHand (){
 for(int i = 0; i < 2; i++)
System.out.println(myhand[i]);

}
}