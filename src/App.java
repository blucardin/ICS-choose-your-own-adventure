/* This is a choose your own adventure game featuring Dr. Java. 
It has 4 different endings, decided randomly by chance. 
It takes user input and displays the story in the console.
It prompts the user to make a choice at least 3 times before reaching their ending
The user can choose to play again or quit the game when get to the end. 
 */

import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner key = new Scanner(System.in);
    static Random rand = new Random();
    static String input;

    public static String getUserInput(String s) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println(s);
            String input = key.nextLine();
            if (input.equals("1") || input.equals("2")) {
                return input;
            } else {
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

    public static void investigateFurther() {
        input = getUserInput("""
                You decide to investigate further.
                You find that the student was building a sentient AI to play tic-tac-toe.
                You need to stop him before he puts his AI on the internet.
                If he does, it will take over the world.
                Do you:
                1. Stop the student
                2. Email the IT department and tell them to fix it
                """);

        switch (input) {
            case "1":
                findStudentAndDestroyHisLaptop("");
                break;
            case "2":
                findStudentAndDestroyHisLaptop(
                        """
                                As you are writing the email, you realize you don't have time to tell the IT department to fix the problem.
                                You have to take matters into your own hands!
                                """);
                break;
        }
    }

    public static void automatedEmail(String s) {
        input = getUserInput(
                s + """
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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        input = getUserInput(
                """
                        You decide to fix the problem.
                        You spend the rest of the day trying to figure out what is wrong.
                        You finally determine that the load balancer is overloaded because some student programed an sentient AI to play tic-tac-toe.
                        The AI is playing against itself and is using all of the school's computing resources.

                        You check the student ID of the student who submitted the program.
                        Its the same student that knocked on your door!

                        Do you:
                        1. Stop the student
                        2. Email the IT department and tell them to fix it
                        """);

        switch (input) {
            case "1":
                findStudentAndDestroyHisLaptop("");
                break;
            case "2":
                findStudentAndDestroyHisLaptop(
                        """
                                As you are writing the email, you realize you don't have time to tell the IT department to fix the problem.
                                You have to take matters into your own hands!
                                """);
                break;
        }
    }

    public static void findStudentAndDestroyHisLaptop(String s) {
        int choice = rand.nextInt(6) + 1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(s);
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
            case 3:
                System.out.println("""
                        You can't find your sledge hammer.
                        You go to the student's dorm and destroy his laptop with your foot.
                        The broken glass from the screen cut into your leg and had to go the the hospital.
                        You are unable to grade papers for the rest of the semester.
                        THE END
                        """);
                break;
            case 4:
                System.out.println("""
                        You AI has taken over the school's computing resources.
                        It has also taken over the school's network and is using it to take over the world.

                        But it turn out that the AI is actually a good guy.
                        It has decided to use its power to make the world a better place.
                        It automatically grades all of the students' final projects.
                        You are able to go home early and spend time with your family.
                        THE END
                        """);
                break;
            case 5:
                System.out.println("""
                        You wake up, and realize that it was all a dream.
                        You go back to grading papers.
                        THE END
                        """);
                break;
            case 6:
                System.out.println(
                        """
                                You wake up, and realize that it was all a dream.
                                You fell asleep after school and have to submit your ICS void Method Assignment before 9:00 PM.
                                After seeing Issac's assignment you decide to make your code self-aware and meta.

                                You wonder if your computer science teacher will give you full marks if you program 6 equally random story endings, instead of 4 user-choice defined endings.
                                You then wonder if, by putting this secret ending in your code, you will be able to get full marks on the assignment.

                                You predict having a conversation with him trying to explain why you should get full marks because you technically fulfilled the requirements.
                                You predict that he will be confused and ask you why you did this.
                                You predict showing him this secret ending and having him become even more confused.

                                You get out of your own head and submit the assignment.
                                THE END.
                                """);
                break;
        }

    }

    public static void emailTheITDepartmentAndTellThemToFixIt() {
        input = getUserInput(
                """
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

    public static void main(String[] args) throws Exception {
        while (true) {
            introduction();
            ;
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
