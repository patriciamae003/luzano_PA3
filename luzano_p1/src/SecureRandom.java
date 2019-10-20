import java.util.Scanner;
import java.util.Random;

/*
    This program generates two random integers,
    asks user to enter the level of difficulty
    and the type of problems he/she wants to do.
    This program will generate 10 problems
    of the specified operation and then identify
    if the user is right or wrong.
 */

public class SecureRandom {
    // Asks user the level of difficulty
    // 1 for 1 digit numbers
    // 2 for 2 digit numbers
    // 3 for 3 digit numbers
    // 4 for 4 digits numbers
    public static int difficultyLevel() {
        Scanner scnr = new Scanner(System.in);
        int level;

        System.out.print("Enter level of difficulty: ");
        level = scnr.nextInt();

        return level;
    }

    // Asks user for their preferred type of problem
    public static int operationType() {
        Scanner scnr = new Scanner(System.in);
        int operation;

        System.out.println("\nType of Arithmetic Problem");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Subtraction");
        System.out.println("4. Division");
        System.out.println("5. Random mix of all types");
        System.out.print("Choose a type of problem: ");
        operation = scnr.nextInt();

        return operation;
    }

    // Generates a question for the user
    public static int newQuestion(int n, int op) {
        Scanner scnr = new Scanner(System.in);
        Random random = new Random();
        int num1;
        int num2;
        double userAns;
        int randOp;

        System.out.println();

        // difficulty level of 1
        if(n == 1) {
            // generates random number from 0-9
            num1 = random.nextInt(10);
            num2 = random.nextInt(10);
        }
        // difficulty level of 2
        else if(n == 2) {
            // generates random number from 10-99
            num1 = random.nextInt(90) + 10;
            num2 = random.nextInt(90) + 10;
        }
        //difficulty level of 3
        else if(n == 3) {
            // generates random number from 100-999
            num1 = random.nextInt(900) + 100;
            num2 = random.nextInt(900) + 100;
        }
        // difficulty level of 4
        else {
            // generates random number from 1000-9999
            num1 = random.nextInt(9000) + 1000;
            num2 = random.nextInt(9000) + 1000;
        }

        // Addition
        if (op == 1) {
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            userAns = scnr.nextInt();
            // user enters incorrect answer
            if (userAns != num1 + num2) {
                return 0;
            }
        }
        // Multiplication
        else if(op == 2) {
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            userAns = scnr.nextInt();
            // user enters incorrect answer
            if(userAns != num1 * num2) {
                return 0;
            }
        }
        // Subtraction
        else if(op == 3) {
            System.out.println("How much is " + num1 + " minus " + num2 + "?");
            userAns = scnr.nextInt();
            if(userAns != num1 - num2) {
                return 0;
            }
        }
        // Division
        else if(op == 4) {
            System.out.println("How much is " + num1 + " divided " + num2 + "?");
            userAns = scnr.nextInt();
            if(userAns != (double)num1/num2) {
                return 0;
            }
        }
        // Random
        else {
            randOp = random.nextInt(4);
            if(randOp == 0) {
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                userAns = scnr.nextInt();
                if (userAns != num1 + num2) {
                    return 0;
                }
            }
            else if(randOp == 1) {
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                userAns = scnr.nextInt();
                if(userAns != num1 * num2) {
                    return 0;
                }
            }
            else if(randOp == 2) {
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                userAns = scnr.nextInt();
                if(userAns != num1 - num2) {
                    return 0;
                }
            }
            else {
                System.out.println("How much is " + num1 + " divided " + num2 + "?");
                userAns = scnr.nextInt();
                if(userAns != (double)num1/num2) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // Prints after the user get a correct answer
    public static void correctResponse() {
        Random random = new Random();
        int rand = random.nextInt(4) + 1;

        switch (rand) {
            case 1:
                System.out.println("Very Good!");
                break;

            case 2:
                System.out.println("Excellent!");
                break;

            case 3:
                System.out.println("Nice Work!");
                break;

            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    // Prints after user gets an incorrect answer
    public static void wrongResponse() {
        Random random = new Random();
        int rand = random.nextInt(4) + 1;

        switch (rand) {
            case 1:
                System.out.println("No. Please try again.");
                break;

            case 2:
                System.out.println("Wrong. Try once more.");
                break;

            case 3:
                System.out.println("Don't give up!");
                break;

            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int i;
        char cont = 'y';
        int numCorrect = 0;
        int numWrong = 0;
        int percentage;
        int n;
        int op;


        while (cont == 'y') {
            // based on user's input for level of difficulty
            n = difficultyLevel();
            // based on user's input for type of operation
            op = operationType();
            // Asks user to solve 10 problems
            for (i = 0; i < 10; i++) {
                if (newQuestion(n, op) == 1) {
                    correctResponse();
                    // counts number of correct answers
                    numCorrect++;
                } else {
                    wrongResponse();
                    // count number of wrong answers
                    numWrong++;
                }
            }
            System.out.println("\nNumber of correct answers: " + numCorrect);
            System.out.println("Number of incorrect answers: " + numWrong);
            // Calculates the percentage of correct answers
            percentage = numCorrect * 10;
            // if percentage is less than 75
            if (percentage < 75) {
                System.out.println("Please ask your teacher for extra help.");
            }
            // percentage is from 75-100
            else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            // End of session
            // Asks user if they wish to proceed to another session
            System.out.println("\nThe session has ended. Do you want to begin a new session (y or n)?");
            cont = scnr.next().charAt(0);
            System.out.println();
        }
    }
}
