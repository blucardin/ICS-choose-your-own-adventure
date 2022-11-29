/* Create a choose your own adventure game

Feature a main character named Dr. Java
Have at least 4 different endings
Take your user’s input from the console
Display the story in the console
Prompt the user to make a choice at least 2 times before reaching their ending
Each choice must have at least two options
Program each section of the story in it’s own method; each section should have at least 4 sentences. I would like to be entertained by your story. That would be nice of you.
Use control structures in the main method to call on your methods according to the choices the user makes
Give the user the option to play again at the end of the story
 */

import java.util.Scanner;


public class App {
    static Scanner key = new Scanner(System.in);
    static String input; 

    public static String getUserInput(String s){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        while (true){
            System.out.println(s);
            String input = key.nextLine();
            if(input.equals("1") || input.equals("2")){
                return input;
            }
            else{
                System.out.println("Please enter a valid input");
            }
        }
    }
    public static void introduction() {
       input = getUserInput(""" 
            Welcome to Dr. Java's Choose Your Own Adventure Game! 
            You are Dr. Java, a computer science professor at a local community college. 
            You are in your office, grading papers, when you hear a knock at the door. 
            
            Do you: 
            1. Answer the door 
            2. Ignore the knock 
            """);
        
        switch (input) {
            case "1":
                answerTheDoor();
                break;
            case "2":
                IgnoreTheKnock();
                break;
        }
    }

    public static void answerTheDoor() {
        input = getUserInput("""
            You answer the door and find a student standing there.
            \"I'm sorry to bother you, but I'm having trouble with my code.\"
            \"It the program for my final project, and its due today.\" he exclaims.
            You don't have time to help him as you have a lot of grading to do.
            But you remember how difficult it is to debug code, especially as a undergrad.
            Do you:
            1. Help the student
            2. Tell the student to come back later
            """);
    }

    public static void helpTheStudent() {
        input = getUserInput("""
            You decide to help the student.
            You take a look at the code and notice that the student is missing a semicolon.
            You tell the student to add the semicolon and the program will run.
            The student thanks you and runs off to turn in his project.
            You finish grading the rest of your papers and go home for the day.
            You have a great weekend and enjoy the rest of your summer.
            THE END
            """);
    }

    public static void automatedEmail(){
        getUserInput("""
            An hour later, you get an automated email from the school's IT department.
            The school's cloud computing resources are down and they need you to fix it.
            Someone has overloaded the system with, several high computation jobs, and the load balancer has gone offline.
            You have to fix the problem before the students can submit their final projects.
            Do you:
            1. Fix the problem
            2. Email the IT department and tell them to fix it
            """);
}

    public static void tellTheStudentToComeBackLater() {
        System.out.println("You tell the student to come back later.");
        System.out.println("The student looks disappointed, but leaves.");
        automatedEmail();
    }

    public static void IgnoreTheKnock() {
        System.out.println("You ignore the knock and continue grading papers.");
        automatedEmail();
    }

    public static void fixTheProblem() {
        System.out.println("You decide to fix the problem.");
        System.out.println("You spend the rest of the day trying to figure out what is wrong.");
        System.out.println("You finally figure out that the load balancer is overloaded because some student programed an infinite loop that propengated to all the servers.");
        System.out.println("You reset the load balancer, and revoke permissions from the student.");
        System.out.println("You finish grading the rest of your papers and go home for the day.");
        System.out.println("You have a great weekend and enjoy the rest of your summer.");
        System.out.println("THE END");
    }

    public static void story() {
        boolean invalid = false;
        do{
            String input = key.nextLine();
            switch (input) {
                case "1":
                    answerTheDoor();
                    invalid = false;
                    do{
                        switch (key.nextLine()) {
                            case "1":
                                helpTheStudent();
                                return;
                            case "2":
                                tellTheStudentToComeBackLater();
                                break;
                            default:
                                System.out.println("Invalid input. Please enter 1 or 2.");
                                invalid = true;
                                break;
                        }
                    } while (invalid);
                    input = "2";

                case "2":
                    IgnoreTheKnock();
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    invalid = true;
                    break;
            }
        }while(invalid);
        
    }

    public static void main(String[] args) throws Exception {
        while(true) {
            story();
            System.out.println("Would you like to play again? (y/n)");
            String answer = key.nextLine();
            if (answer.equals("n")) {
                System.out.println("Thanks for playing!");
                key.close();
                break;
            }
        }
    }
}
        
        
