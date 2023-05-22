/*
 * Jiyon Chatterjee Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) throws Exception {
        // Create Categories
        Category plague = new Category("Plague", "You want to stay in quarantine, away from disease."
                + "You might just survive the apocalypse.");
        Category zombies = new Category("Zombie Apocalypse", "You are brave, extroverted, and outgoing "
                + "but it might get you infected by a hungry zombie!");
        Category nuclear = new Category("Nuclear Winter",
                "You want to stay close to your friends and family to survive, but keep strangers out because resources are limited.");
        
        // Create Questions
        Question q1 = new Question("How would you spend your weekend?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Cooking at home.", plague);
        q1.possibleAnswers[1] = new Answer("Paintball with friends.", zombies);
        q1.possibleAnswers[2] = new Answer("Go to the movies.", nuclear);

        Question q2 = new Question("What movie genre?");
        q2.possibleAnswers[0] = new Answer("Rom-Com", plague);
        q2.possibleAnswers[1] = new Answer("Horror", zombies);
        q2.possibleAnswers[2] = new Answer("Superhero", nuclear);
       
        Question q3 = new Question("Cats or dogs?");
        q3.possibleAnswers[0] = new Answer("Cats", plague);
        q3.possibleAnswers[1] = new Answer("Dogs", zombies);
        q3.possibleAnswers[2] = new Answer("Neither.", nuclear);
       
        Question q4 = new Question("Favorite Season?");
        q4.possibleAnswers[0] = new Answer("Winter", plague);
        q4.possibleAnswers[1] = new Answer("Summer", zombies);
        q4.possibleAnswers[2] = new Answer("Fall", nuclear);

        Question q5 = new Question(
                "Ideal workspace?");
        q5.possibleAnswers[0] = new Answer(
                "Office", plague);
        q5.possibleAnswers[1] = new Answer("Outdoors", zombies);
        q5.possibleAnswers[2] = new Answer(
                "Wherever there's WiFi!", nuclear);
        

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question[] qList = { q1, q2, q3, q4, q5 };
        for (Question q : qList)
         {
            Category c = q.ask(sc);
            c.points++;
        }

        // Get most common category from the questions asked
        // Return Category
        Category[] cList = { plague, zombies, nuclear };
        int[] counts = { plague.points, zombies.points, nuclear.points };
        // these need to be in the same order or the points will be incorrect!
        int index = getMostPopularCatIndex(counts);
        System.out.println("If you were an apocalypse, you would be " + cList[index].label + ". ");
        System.out.println(cList[index].description);

    }

    public static void gameIntro(Scanner sc) {
        // requires 1 to keep going
        System.out.println("What Apocalypse Are You?");
        System.out.println("You get to choose numbers 1-3 for every question. Enter '1' to play!");
        int play = sc.nextInt();
        if (play != 1) {
            System.out.println("Unidentifiable input. Please enter '1' to play");
            gameIntro(sc);
        }
    }

    public static int getMostPopularCatIndex(int[] counts) {
        // returns the index that is the max
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

   
    }