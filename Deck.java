import java.util.*; 
import java.lang.String;

class Deck { 
// this line of code creates an array representing the numbers and letters on the cards. This array is made with the final keyword which means its values should and cannot be changed. The arrays name is capital because it is common practice when the keyword final is used. 
public final String[] SUITS = { "H", "D", "C", "S" }; // H="Heart", D="Diamond", C="Clubs", S="Spades"
//This array is made with the final keyword which means its values should and cannot be changed. It was made to represent the full length of a deck.The arrays name is capital because it is common practice when the keyword final is used.
public final String[] RANKS = { "A-", "2-", "3-", "4-", "5-", "6-", "7-", "8-", "9-", "10-", "J-", "Q-", "K-" };

public int DeckLength = 51; 
// This is an array list made to represent the deck.
public ArrayList<String> DeckFull =new ArrayList<String>();

public boolean Lose = false;

// This is where the array list made to represent the deck gets its values.
public Deck() { 
for(int initialVar1 = 0; initialVar1 < SUITS.length; initialVar1++) 
{ for(int initialVar2 = 0; initialVar2 < RANKS.length; initialVar2++) { 
this.DeckFull.add(RANKS[initialVar2] + SUITS[initialVar1]); } }  }

/*public Deck(ArrayList<String> DeckFull) {
this.DeckFull = DeckFull;
for(int initialVar1 = 0; initialVar1 < SUITS.length; initialVar1++) 
{ for(int initialVar2 = 0; initialVar2 < RANKS.length; initialVar2++) { 
DeckFull.add(RANKS[initialVar2] + SUITS[initialVar1]); } }  }
*/

// this was mainly used for testing purposes
public void showDeck() 
{
 for(int i = 0; i < DeckLength; i++)
 { System.out.println(this.DeckFull.get(i)); } } 

/*This was used for testing
 * 
 * public void showDeck(ArrayList<String> DeckFull) 
{ this.DeckFull  = DeckFull;
for(int i = 0; i < DeckLength; i++)
{ System.out.println(DeckFull.get(i)); } } 
*/

public void RemoveCard(String card)
{
String[] CardStr = card.split("-", 2);

/*System.out.println(CardStr[0]+" this is the firat Cardstr " ); 
System.out.println(CardStr[1]+" this is the second Cardstr ");
System.out.println(CardStr+" this is the Cardstr ");
*/
int resultCard = 0;

if (!(CardStr[0].equals("K")) &&!(CardStr[0].equals("Q")) && !(CardStr[0].equals("J")) && !(CardStr[0].equals("A")))
{
resultCard = Integer.parseInt(CardStr[0]);

}
if (CardStr[0].equals("K"))
  resultCard = 13;

if (CardStr[0].equals("Q"))
  resultCard = 12;

if (CardStr[0].equals("J"))
  resultCard = 11;

if (CardStr[0].equals("A"))
  resultCard = 1;

/*This was used for testing
 * System.out.println( " this is the resultCard not KQJA " + resultCard);
  */
if (CardStr[1].equals("H") ) 
{
  /*This was used for testing
   * System.out.println(" this is the first part of the ifstatement ");*/
  int indext = resultCard -1;
  this.DeckFull.set(indext,"Empty");
}

if (CardStr[1].equals("D") ) 
{
  /*This was used for testing
   * System.out.println(" this is the first part of the ifstatement ");*/
  int indext = resultCard +12;
  this.DeckFull.set(indext,"Empty");
}

if (CardStr[1].equals("C") ) 
{
  /*This was used for testing
   * System.out.println(" this is the first part of the ifstatmetn ");*/
  int indext = resultCard +25;
  this.DeckFull.set(indext,"Empty");
}

if (CardStr[1].equals("S") ) 
{
  /*This was used for testing
   * System.out.println(" this is the first part of the ifstatmetn ");*/
  int indext = resultCard +38;
  this.DeckFull.set(indext,"Empty");
}
this.showDeck();


}

public String[] MakeHand()
{
Random random = new Random();
int rand1 = random.nextInt(53);

/*This was used for testing
 * System.out.println("Random Integers: "+rand1); 
*/
int rand2 = random.nextInt(53);

while (rand2 == rand1 )
   rand2 = random.nextInt(53);

/*This was used for testing
 * System.out.println("Random Integers: "+rand2); 
*/

String[] ans = new String[2]; 
        ans[0] = this.DeckFull.get(rand1); 
        ans[1] = this.DeckFull.get(rand2); 
        while (ans[0].equals("Empty")){
          rand1 = random.nextInt(53);
        ans[0] = this.DeckFull.get(rand1);
        }
        while (ans[1].equals("Empty")){
          rand2 = random.nextInt(53);
        ans[1] = this.DeckFull.get(rand2);
        }
        this.RemoveCard(rand1);
        this.RemoveCard(rand2);
        
return ans;
}
  

public void RemoveCard(int index)
{
  this.DeckFull.set(index,"Empty");
  
}

public String DrawCard()
{
Random random = new Random();
int rand1 = random.nextInt(53);
/*This was used for testing
 * System.out.println("Random Integers from class: "+rand1);*/
String card;
card = this.DeckFull.get(rand1);
/*
 * This was used for testing
System.out.println("Random card from class: "+card);
*/
while (card.equals("Empty")){
  /*This was used for testing
rand1 = random.nextInt(53);*/
card = this.DeckFull.get(rand1);
/*This was used for testing
System.out.println("Random card from class while loop: "+card);
*/
}

this.RemoveCard(rand1);
return card;  
}

public int GetScore(String[] hand)
{
  String card;

int resultCard = 0;
int score = 0;


for(int i = 0; i < 2; i++)
 { 

card= hand[i];
  
String[] CardStr = card.split("-", 2);


if (!(CardStr[0].equals("K")) &&!(CardStr[0].equals("Q")) && !(CardStr[0].equals("J")) && !(CardStr[0].equals("A")))
{
resultCard = Integer.parseInt(CardStr[0]);

}
if (CardStr[0].equals("K"))
  resultCard = 13;

if (CardStr[0].equals("Q"))
  resultCard = 12;

if (CardStr[0].equals("J"))
  resultCard = 11;

if (CardStr[0].equals("A"))
{
Scanner scan = new Scanner(System.in);
System.out.println("The Ace can have a vaule of 1 or 11 please type in 1 or 11? \n");
String CardValue = scan.nextLine();
System.out.println("You entered: \n" + CardValue + "\n");

if(CardValue.equals("1"))   
resultCard = 1;
if(CardValue.equals("11"))   
resultCard = 11;
else 
{System.out.println("There are two aces so you will get one of each so you dont loose right away");}
}

score = score + resultCard; 
  /*This was used for testing
   * System.out.println("Your score is: "+ score+" In loop "+i );
*/


}
return score;
}


public int WinLoseH(int score)  
{
  
  if (score == 21)
  {
    System.out.println("Your score is: "+ score+" You WIN!!!!!" );
  
    int Lose = 1;
  return Lose;
  }
  
  
  if (score > 21){
    System.out.println("Your score is: "+ score+" You Lose!!!!!" );
   int Lose = 1;
  return Lose;
  }
  else 
  {int Lose = 0;
    return Lose;}
}

public int WinLoseC(int score)  
{
  
  if (score == 21)
  {
    System.out.println("The CPU score is: "+ score+" They WIN!!!!!" );
 
    int Lose = 1;
  return Lose;
  }
  
  if (score > 21){
    System.out.println("The CPU score is: "+ score+" They Lose!!!!!" );
   int Lose = 1;
  return Lose;
  }
  else 
  {int Lose = 0;
    return Lose;}
}

 public int GetScore(String card, int HandScore)
{

int resultCard = 0;

  
String[] CardStr = card.split("-", 2);

if (!(CardStr[0].equals("K")) &&!(CardStr[0].equals("Q")) && !(CardStr[0].equals("J")) && !(CardStr[0].equals("A")))
{
resultCard = Integer.parseInt(CardStr[0]);

}
if (CardStr[0].equals("K"))
  resultCard = 13;

if (CardStr[0].equals("Q"))
  resultCard = 12;

if (CardStr[0].equals("J"))
  resultCard = 11;

if (CardStr[0].equals("A"))
{
Scanner scan = new Scanner(System.in);
System.out.println("The Ace can have a vaule of 1 or 11 please type in 1 or 11? \n");
String CardValue = scan.nextLine();
System.out.println("You entered: \n" + CardValue + "\n");

if(CardValue.equals("1"))   
resultCard = 1;
if(CardValue.equals("11"))   
resultCard = 11;
else 
{System.out.println("You entered:the wrong input");}
}

HandScore = HandScore + resultCard; 
 // System.out.println("Your score is: "+ HandScore+" In loop of adding Drawcard ");(used for testing)

return HandScore;
}
}
class Player {
  public String name; 
  public int Lose = 0;
  public String[] hand;
  public int score;
  
public Player() { 
this.name = name;
this.Lose = 0;
this.hand = hand;
this.score =score;

}
public void setName(String name){
  this.name = name;
}
public void setHand(String[] hand){
  this.hand = hand;
}

public void setScore(int score){
  this.score = score;
}
public String GetName (){
  return name;
}
public int GetScore(){
  return score;
}

public String[] GetHand(){
  return hand;
}
public int WinLoseHorC(int Hscore, int Cscore)  
{
  if (Hscore > Cscore )
  {
    System.out.println("Your score is: "+ Hscore+" You WIN!!!!!" );
    
  int Lose = 1;
  return Lose;}
  if (Hscore < Cscore )
  {
    System.out.println("The CPU score is: "+ Cscore+" You LOSE" );
    
  int Lose = 1;
  return Lose;}
  
  else 
  {return 0;}
  
}
  
}

