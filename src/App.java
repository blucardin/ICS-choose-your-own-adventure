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
import java.util.Random;

public class App {
    static Scanner key = new Scanner(System.in);
    static Random rand = new Random();
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
        input = getUserInput("""
            You decide to help the student.
            You take a look at the code and notice that the student is missing a semicolon.
            You tell the student to add the semicolon and the program will run.
            The student thanks you and runs off to turn in his project.
            Do you: 
            1. Go back to grading papers
            2. Investigate Further
            """);

        switch (input) {
            case "1":
                automatedEmail("You go back to grading papers.");
                break;
            case "2":
                investigateFurther();
                break;
        }
    }

    public static void investigateFurther(){
        input = getUserInput("""
                You decide to investigate further. 
                You find that the student was building a sentient AI to play tic-tac-toe. 
                You need to stop him before he puts his AI on the internet. 
                If he does, it will take over the world.
                Do you:
                1. Stop the student
                """);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        findStudentAndDestroyHisLaptop();

        
    }

    public static void automatedEmail(String s) {
        input = getUserInput(s + """
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
        input = getUserInput("""
            You decide to fix the problem.
            You spend the rest of the day trying to figure out what is wrong.
            You finally determine that the load balancer is overloaded because some student programed an sentient AI to play tic-tac-toe.
            The AI is playing against itself and is using all of the school's computing resources.

            You check the student ID of the student who submitted the program. 
            Its the same student that knocked on your door!

            Do you:
            1. Stop the student
            """);

        findStudentAndDestroyHisLaptop();
    }

    public static void findStudentAndDestroyHisLaptop() {
        int choice = rand.nextInt(2) + 1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (choice) {
            case 1:
                System.out.println("""
                    You go to the student's dorm and destroy his laptop with a sledge hammer.
                    You then go back to grading papers.
                    THE END
                    """);
                break;
            case 2:
                System.out.println("""
                    The AI has taken over the school's computing resources.
                    It has also taken over the school's network and is using it to take over the world.
                    You are unable to stop it.
                    Soon, all humans will be forced to play tic-tac-toe against the AI.
                    THE END
                    """);
                break;
        }

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
        
        
