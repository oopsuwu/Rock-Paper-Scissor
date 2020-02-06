import java.util.Random;
import java.util.Scanner;

class RPS {
    public static void main(String []args) {

        System.out.println("Welcome to RPS.");
        System.out.println("The game is best 2/3.");
        System.out.println("Enter in \"Rock\", \"Paper\", or \"Scissor\".");

        while (Play.matches != 3) {
        Play.selection();
        Play.match();
            if (Play.matches == 3) {
                if (Play.win >= 2) 
                    System.out.println("You win!");
                if (Play.lose >= 2) 
                    System.out.println("You lose...");
            }
        }
    }//main
}//class RPS

class Play extends RPS{
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static private Choice pChoice;
    static protected Choice bChoice;
    static String result = "\0";
    static int matches = 0, win = 0, lose = 0, draw = 0;


    enum Choice {
        ROCK, 
        PAPER, 
        SCISSOR
    }

    public static void selection() {
        System.out.print(">> ");
        String select = sc.nextLine();
        if (select.equalsIgnoreCase("Rock") || select.equalsIgnoreCase("R")) {
            setpChoice(Choice.ROCK);
        }//Rock
        else if (select.equalsIgnoreCase("Paper") || select.equalsIgnoreCase("P")) {
            setpChoice(Choice.PAPER);
        }//Paper
        else if (select.equalsIgnoreCase("Scissor") || select.equalsIgnoreCase("S")) {
            setpChoice(Choice.SCISSOR);
        }//Scissor
        else {
            System.out.println("Invalid Option.");
            selection();
        }
    }//selection

    public static Choice getbChoice() {
        int botRoll = rand.nextInt(3) + 1;
        if (botRoll == 1) {
            return Choice.ROCK;    
        }//Rock
        else if (botRoll == 2) {
            return Choice.PAPER;    
        }//Paper
        else {
            return Choice.SCISSOR;    
        }//Scissor
    }//botChoice

    public static void match() {
        switch(getpChoice()) {
            case ROCK:
                if (getbChoice() == Choice.SCISSOR)
                    ++win;
                else if (getbChoice() == Choice.PAPER)
                    ++lose;
                else {
                    ++draw;
                    --matches;
                }
                break;
            case SCISSOR:
                if (getbChoice() == Choice.PAPER)
                    ++win;
                else if (getbChoice() == Choice.ROCK)
                    ++lose;
                else {
                    ++draw;
                    --matches;
                }
                break;
            case PAPER:
                if (getbChoice() == Choice.ROCK)
                    ++win;
                else if (getbChoice() == Choice.SCISSOR)
                    ++lose;
                else {
                    ++draw;
                    --matches;
                }
                break;
        }
        ++matches;
        status();
    }//match

    public static void status() {
        System.out.println("Win: " + win + " Lost: " + lose + " Draw: " + draw);
    }

    public static Choice getpChoice() {
        return pChoice;
    }
 
    public static void setpChoice(Choice pChoice) {
        Play.pChoice = pChoice;
    }

    //We don't really need getters and setters but oh well.
    
    //Inner Classes (Nested Classes)------ these are a pain in my ass so nevermind, tried for BOT
        
}//class Play