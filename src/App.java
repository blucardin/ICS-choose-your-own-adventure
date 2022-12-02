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
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void introduction() {
       input = getUserInput(""" 
            Welcome to Dr. Java's Choose Your Own Adventure Game! 
            You are Dr. Java, a professor at a local community college. 
            You got your PhD from the University of Washington, and now head the Computer Science and IT divisions.
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

        switch (input) {
            case "1":
                helpTheStudent();
                break;
            case "2":
                tellTheStudentToComeBackLater();
                break;
        }
    }

    public static void helpTheStudent() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("""
            You decide to help the student.
            You take a look at the code and notice that the student is missing a semicolon.
            You tell the student to add the semicolon and the program will run.
            The student thanks you and runs off to turn in his project.
            You finish grading the rest of your papers and go home for the day.
            You have a great weekend and enjoy the rest of your summer.
            THE END
            """);
    }

    public static void automatedEmail(String s) {
        getUserInput(s + """
            An hour later, you get an automated email from the school's IT department.
            The school's cloud computing resources are down and they need you to fix it.
            Someone has overloaded the system with, several high computation jobs, and the load balancer has gone offline.
            You have to fix the problem before the students can submit their final projects.
            Do you:
            1. Fix the problem
            2. Email the IT department and tell them to fix it
            """);
        
        switch (input) {
            case "1":
                fixTheProblem();
                break;
            case "2":
                emailTheITDepartmentAndTellThemToFixIt();
                break;
        }
}

    public static void tellTheStudentToComeBackLater() {
        automatedEmail("""
            You tell the student to come back later.
            The student looks disappointed, but leaves.
            """);
    }

    public static void IgnoreTheKnock() {
        automatedEmail("You ignore the knock and continue grading papers.");
    }

    public static void fixTheProblem() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("""
            You decide to fix the problem.
            You spend the rest of the day trying to figure out what is wrong.
            You finally figure out that the load balancer is overloaded because some student programed an infinite loop that propagated to all the servers.
            You reset the load balancer, and revoke permissions from the student.
            You finish grading the rest of your papers and go home for the day.
            You have a great weekend and enjoy the rest of your summer.
            THE END
            """);
    }

    public static void emailTheITDepartmentAndTellThemToFixIt() {
        input = getUserInput("""
            You decide to email the IT department and tell them to fix it.
            Then you get an email from yourself, and remember that you are the head of the IT department.
            The servers are still down, and they have to be fixed before the students can submit their final projects.
            You are starting to get frustrated. 
            Do you:
            1. Fix the problem
            2. Email the IT department and tell them to fix it
            """);
        switch (input) {
            case "1":
                fixTheProblem();
                break;
            case "2":
                emailTheITDepartmentAndTellThemToFixIt();
                break;
        }
    }

    public static void story() {
        introduction();        
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
        
        
