//Learn how to use random feature
//+= 1 means: what is being added(+) equals(=) 1 
//== you are comparing
//= you are assigning whats on the left to the right
import java.util.Random;
public class DiceGame1{
    public static void main(String [] args) {
        Random random = new Random();
        int totalNumberOfTurns = 10;
        int computerDie; //create a variable that will store the computer's die
        int computerScore = 0; // create variable that keeps track of how many times the computer won. Intialize score to zero because before starting everyone has a score of zero 
        int userScore =0; //create variable to keep track of user score and start at zero
        int userDie;
        
        
        for( int turn =1; turn <= totalNumberOfTurns; turn++){
        //create for loop that runs 10 times
        // turn++ = before you come back up and run the loop again and check to see whether variable turn is less than or equal to variable totalNumberOfTurns, add 1 to turn
        //starts at 1
            
            computerDie = random.nextInt(6) + 1; 
            //^ generates random integer of 1 through 6 for computer die
            userDie = random.nextInt(6) + 1;
            //^ generates random integer of 1 through 6 for user die
            //EX: random.nextInt(6); range is 0 to 5
            //EX: random.nextInt(6) + 1; range is 1 to 6
            //EX: random.nextInt(6) + 2 ; range is 2 to 7
            //Think random.nextInt(6)+ 1 is a total of 6 numbers starting at 1
            
            //create if statement to compare these two dice to see which one is greater. If there is a tie, dont do anything. If it is greater we keep track of it 
            if(computerDie > userDie) {
                computerScore = computerScore +1;//if computer wins, add one point
                System.out.println("Computer won turn " + turn);
            } else if(userDie > computerDie) {
                userScore += 1; //SAME -> userScore = userScore +1; // if user wins, add one point. 
                System.out.println("User won turn " + turn);
            } else{
                System.out.println("Turn " + turn + " was a tie");
            }
            
        }
        //Now, being outside of this loop, display number of times, display who is the grand win, the commputer or user
        if (computerScore > userScore) {
            System.out.println("Computer is the grand winner, winning " + computerScore + " out of " + totalNumberOfTurns + " turns");
        }else if(userScore > computerScore) {
            System.out.println("User is the grand winner, winning " + userScore + " out of " + totalNumberOfTurns + " turns.");
        }else if( computerScore == userScore){
            System.out.println("It was a tie with computer winning " + computerScore + " turns and user winning " + userScore + " turns all out of " + totalNumberOfTurns);
        }
    }
}
        