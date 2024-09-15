import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT = 15; // Time limit for each question in seconds

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        // Adding some questions
        questions.add(new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "A"));
        questions.add(new Question("What is 2 + 2?", "3", "4", "5", "6", "B"));
        questions.add(new Question("What is the color of the sky?", "Green", "Blue", "Red", "Yellow", "B"));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println("A. " + question.getOptionA());
            System.out.println("B. " + question.getOptionB());
            System.out.println("C. " + question.getOptionC());
            System.out.println("D. " + question.getOptionD());

            // Timer setup
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    scanner.close();
                    System.exit(0);
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000); // Schedule the task to run after TIME_LIMIT seconds

            // Get user's answer
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim().toUpperCase();
            timer.cancel(); // Cancel the timer if the user answers in time

            if (answer.equals(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was " + question.getCorrectAnswer());
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

class Question {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
