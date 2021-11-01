import javax.swing.JOptionPane;
import java.util.Random; //because we are generating random numbers we need to import the random class 

public class SlotMachine{
    public static void main( String [] args){
        
        //+=1
        String userStringInput; //create a string variable to store what is returned from JOptionPane. 
        double userAmountEntered; //create a double variable to store userStringInput being converted to a double
        Random random = new Random();
        int wordIndex; //declare integer variable
        String word = ""; //initialize as nothing with "" not " " (< has a space)
        String outputString = "";
        String word1 = ""; //initalize word1 to NOTHING using ""
        String word2 = ""; //initalize word2 to NOTHING using ""
        String word3 = ""; //initalize word3 to NOTHING using ""
        char playAgain = 'y';
        double totalUserAmountEntered = 0; //user starts with ZERO DOLLARS
        double totalAmountWonSoFar = 0; //user starts at ZERO DOLLARS
        
        while( playAgain == 'y') { //DONT FORGET TO USE DOUBLE EQUALS (==) 
            outputString = ""; //add this so when it loops again it starts at NOTHING and does not display past play
            userStringInput = JOptionPane.showInputDialog("Insert money: ");
            //Anything user types with jOptionPane will be returned as a string, so string must be converted to a number
            userAmountEntered = Double.parseDouble(userStringInput);
            //need to convert string to a double to input values like 2.50
            totalUserAmountEntered = totalUserAmountEntered + userAmountEntered;
            //also be written as  += userAmountEntered;

            //create a forloop that runs three times
            for(int wordCount = 1; wordCount<=3; wordCount++){

                wordIndex = random.nextInt(6); //this will generate random numbers from 0 to 5, 6 is NOT INCLUDED

                if( wordIndex == 0){//REMEMBER double equals (==) is to compare, and single equals (=) is to assign value
                word = "Cherries";
                } else if (wordIndex == 1) {
                word = "Oranges";
                } else if (wordIndex == 2) {
                word = "Plums";
                } else if (wordIndex == 3) {
                word = "Bells";
                } else if (wordIndex == 4) {
                word = "Melons";
                } else if (wordIndex == 5) {
                word = "Bars";
                }

                if(wordCount == 1){
                    word1 = word;
                } else if (wordCount == 2) {
                    word2 = word;
                } else if (wordCount == 3) {
                    word3 = word;
                } 
            }
            //this is what is being displayed
            outputString = outputString + "[ " + word1 + " ]\t\t\t\t\t\t[ " + word2 + " ]\t\t\t\t\t\t[ " + word3 + " ]";

            //word1   word2  word3

            // a        a        b
            //if none match, display user has won zero dollars
            if( (word1 != word2) && (word1 != word3) && (word2 != word3) ){
                outputString = outputString + "\n\nYou have won $0";
                totalAmountWonSoFar = totalAmountWonSoFar + 0;
            //if two match, display user has won twice the amount entered
            }else if (( (word1 == word2) && (word1 != word3) ) || ( (word1 == word3) && (word1 != word2)) || ( (word2 == word3) && (word2 != word1)  )) {
               outputString = outputString + "\n\nYou have won $" + (userAmountEntered *2); 
                totalAmountWonSoFar = totalAmountWonSoFar + (userAmountEntered *2);
            //if all match, display user has won three times the amount entered
            }else{ 
                outputString = outputString + "\n\nYou have won $" + (userAmountEntered*3);
                totalAmountWonSoFar = totalAmountWonSoFar + (userAmountEntered *3);
            }
            //THIS IS THE MAIN THING THAT IS BEING DISPLAYED
            outputString = outputString + "\n\nAmount you've inserted so far: $" + totalUserAmountEntered + "\nAmount won so far: $" + totalAmountWonSoFar;
            
            playAgain = JOptionPane.showInputDialog( outputString + "\n\n\nDo you want to play again?\nPress y for yes, and any key for no : ").charAt(0); //Ask program to extrack first character from users answer to whether they want to play the game or not. 
            //

        } //THIS IS THE END OF THE WHILE LOOP!!!!!!!
        // if user doesn't want to play again, display the total amount of money entered into the slot machine and the total amount won.
            if (totalUserAmountEntered > totalAmountWonSoFar){
              JOptionPane.showMessageDialog(null, "You inserted $" + totalUserAmountEntered + " and won $" + totalAmountWonSoFar + ", making a loss of $" + (totalUserAmountEntered - totalAmountWonSoFar) + ". Thanks for playing!");  
            }else if (totalUserAmountEntered < totalAmountWonSoFar){
                JOptionPane.showMessageDialog(null, "You inserted $" + totalUserAmountEntered + " and won $" + totalAmountWonSoFar + ", making a profit of $" + (totalAmountWonSoFar - totalUserAmountEntered) + ". Thanks for playing!"); 
            }else {
                JOptionPane.showMessageDialog(null, "You inserted $" + totalUserAmountEntered + " and won $" + totalAmountWonSoFar + ". You didn't make any profit or loss. Thanks for playing!");
            }
        
            System.exit(0);//Anytime JOptionPane is used, you must use an EXIT

        
        
    }
}