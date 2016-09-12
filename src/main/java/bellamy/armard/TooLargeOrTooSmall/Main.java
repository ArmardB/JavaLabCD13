package bellamy.armard.TooLargeOrTooSmall;
import java.util.*;

/**
 * Created by armardbellamy on 9/9/16.
 */
public class Main {

    Scanner scanner = new Scanner(System.in);
    boolean guessing = true;
    int secretNumber = (int) Math.ceil(Math.random() * 10);
    ArrayList<Integer> userGuesses = new ArrayList<Integer>();


    public void checkGuess(int userGuess){
        addUserGuess(userGuess);
        if (isRepeatNumber(userGuess)){
            return;
        }

        if(userGuess != secretNumber){
            if (userGuess > secretNumber){
                System.out.println(userGuess + " is too high!!!");
            } else {
                System.out.println(userGuess + " is too low!!!");
            }
        } else{
            System.out.println("You got it! The number was " + secretNumber + ". It took you " + userGuesses.size() + " tries!");
            guessing = false;
        }
    }

    public void addUserGuess(int userGuess){
        userGuesses.add(userGuess);
    }

    public boolean isRepeatNumber(int userGuess){
        if (userGuesses.size() == 1){
            return false;
        }

        if (userGuess == userGuesses.get(userGuesses.size()-2)){
            System.out.println("You've already guessed this number!");
            return true;
        }
        return false;
    }

    public void runGame(){
        int userGuess = -1;

        while(guessing){
            System.out.print("Enter a number between 1 and 10: ");
            userGuess = scanner.nextInt();
            checkGuess(userGuess);
        }
    }

    public static void main(String[] args){

        Main main = new Main();
        System.out.println("Welcome to the number guessing game. ");
        main.runGame();
    }
}
