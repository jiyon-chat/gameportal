import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[3];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category of the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        int ans = errorCheck(sc);
        return possibleAnswers[ans - 1].cat;
    }
    public static int errorCheck(Scanner sc) {
        if(sc.hasNextInt()) {
            int input = sc.nextInt();
            //Category c = q.ask(sc);
            if (input > 3 || input < 1) {
                System.out.println("Hey! this number is not what I wanted. Try again.");
                return errorCheck(sc);
            } else {
              //  c.points++;
                return input;
            }
        } else {
            System.out.println("This is not a number. Discarding this input");
            sc.next(); // discarding the next input
            return errorCheck(sc);
        }
    }
}