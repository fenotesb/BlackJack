import java.util.*; 
import java.lang.String;


public class BlackJack
{
  
public static void main(String args[])
{
int Lose = 0; 
int resultScle;
String  Name;
String output;
String YesNo;
String drawCard;

int HandScore;

String[] hand;


//Gets the name of player
Scanner scan = new Scanner(System.in);
System.out.println("Welcome to a game of Black Jack with a twsit\n In this game K=13 Q =12 and J =11 you can see your oppents hand and there are no slpits and no draws \n What is your name? \n");
Name = scan.nextLine();
//Creates player objects for both cpu and player
Player HumanPlayer = new Player();
Player CpuPlayer = new Player();
//Sets name for both Human and CPU player object
HumanPlayer.setName(Name);
CpuPlayer.setName("Cpu");
System.out.println("You entered: \n" + HumanPlayer.GetName() + "\n");

////////////////////////////////////////////////////////////////////////
System.out.println("On a Scale of one to three how much do you like to play this game?");
output = scan.nextLine();
 resultScle = Integer.parseInt(output);
try{
  String [] LoveForGame = {"You don't really seem to like this game","I see you don't mind playing but, wouldn't mind doing something else instead","Glad to see you love this game as much as I do"};
System.out.println(LoveForGame[resultScle-1]);}
catch (Exception e) {
  System.out.println("You need to enter a number between 1 and 3.");}

///////////////////////////////////////////////////////////////////////////
//Creates a deck object
Deck Gamedeck = new Deck();
//makes hand for human player
hand  = Gamedeck.MakeHand();
//sets the given hand into the human player object
HumanPlayer.setHand(hand);
hand = HumanPlayer.GetHand();
System.out.println("These are the two cards in  "+ HumanPlayer.GetName()+"'s hand \n" + hand[0]+" "+hand[1]); 
//Calulates the score of human player hand and sets in into the human player object
HandScore = Gamedeck.GetScore(hand);
HumanPlayer.setScore(HandScore);
System.out.println("This is the score in "+ HumanPlayer.GetName()+" hand \n" + HumanPlayer.GetScore());
//checks to see if its eqaul to or above 21
Gamedeck.WinLoseH(HumanPlayer.GetScore());
//makes hand for cpu and sets it into the cpu player object
hand  = Gamedeck.MakeHand();
CpuPlayer.setHand(hand);

hand = CpuPlayer.GetHand();
System.out.println("These are the two cards in "+ CpuPlayer.GetName()+"'s hand \n" + hand[0]+" "+hand[1]); 
//Calulates the score of CPPU player hand and sets in into the CPU player object
HandScore = Gamedeck.GetScore(hand);
CpuPlayer.setScore(HandScore);
System.out.println("This is the score in "+CpuPlayer.GetName() +" hand \n" + CpuPlayer.GetScore());
//checks to see if its eqaul to or above 21
Lose = Gamedeck.WinLoseC(CpuPlayer.GetScore());
//loop that plays the game
while ((Lose == 0)&& (CpuPlayer.GetScore()<21)&&(HumanPlayer.GetScore()<21)){

System.out.println("Would you like to draw a card? (Y/N)");
YesNo = scan.nextLine();
System.out.println("You entered: " + YesNo + "\n");
if (YesNo.equals("N")){
  //Make sure teh cpu doesnt draw a card if its score is above 16
  if (CpuPlayer.GetScore()<17){
//Draws a card from the deck and displays
drawCard=Gamedeck.DrawCard();
System.out.println("This is "+CpuPlayer.GetName()+"'s drawen carded \n" + drawCard);
//Calulates the score of CPU player hand and sets in into the CPU player object
HandScore = Gamedeck.GetScore(drawCard,HandScore);
CpuPlayer.setScore(HandScore);
System.out.println("This is the score in "+CpuPlayer.GetName() +"'s hand \n" + CpuPlayer.GetScore());

Lose = Gamedeck.WinLoseC(CpuPlayer.GetScore());
//breaks loop if there is a looser
if (Lose ==1){
break;}
}
else{
//Checks to see if there is a winner by comparing scores
  Lose=HumanPlayer.WinLoseHorC(HumanPlayer.GetScore(), CpuPlayer.GetScore());
}}
if (YesNo.equals("Y"))
{
  //Draws a card from the deck
drawCard=Gamedeck.DrawCard();
System.out.println("This is "+HumanPlayer.GetName()+"'s drawen carded \n" + drawCard);
//Calulates the score of human player hand and sets in into the huamn player object
HandScore = Gamedeck.GetScore(drawCard,HandScore);
HumanPlayer.setScore(HandScore);
System.out.println("This is the new score in "+ HumanPlayer.GetName()+" hand \n" + HumanPlayer.GetScore());
Lose = Gamedeck.WinLoseH(HumanPlayer.GetScore());
//breaks loop if there is a looser
if (Lose ==1){
break;}
//Make sure teh cpu doesnt draw a card if its score is above 16
if (CpuPlayer.GetScore()<17){
drawCard=Gamedeck.DrawCard();
System.out.println("This is "+CpuPlayer.GetName()+"'s drawen carded \n" + drawCard);
//Calulates the score of CPPU player hand and sets in into the CPU player object
HandScore = Gamedeck.GetScore(drawCard,HandScore);
CpuPlayer.setScore(HandScore);
System.out.println("This is the score in "+CpuPlayer.GetName() +"'s hand \n" + CpuPlayer.GetScore());
Lose = Gamedeck.WinLoseC(CpuPlayer.GetScore());
//breaks loop if there is a looser
if (Lose ==1){
break;}
}

}

}



}
}


