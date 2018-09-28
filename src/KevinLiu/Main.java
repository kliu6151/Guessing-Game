package KevinLiu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 0;
        System.out.println("FOLLOW DIRECTIONS");
        System.out.println("Hi, what's your name?");
        String name = input.nextLine();
        System.out.println("What difficulty would you like? 1-10(1), 1-100(2), 1-1000(3), 1-10000(4)");
        int difficulty = input.nextInt();
        if (difficulty < 1 || difficulty > 4) {
            System.out.println("Sorry " + name + ", we don't have that difficulty");
            System.exit(1);
        } else {
            max = (int) Math.pow(10, difficulty);
        }
        System.out.println("Hi " + name + ", linear(1) or binary(2) ");
        int choice = input.nextInt();
        if (choice != 1 && choice != 2)
        {
            System.out.println("Sorry, we don't have that game mode");
            System.exit(1);
        }
        else if (choice == 1) {
            System.out.println("Binary");
            int randomNum = (int) (max * Math.random() + 1);
            int guesses = 0;
            System.out.println("Number generated, guess wisely " + name);
            int guess = input.nextInt();
            guesses++;
            while (guess != randomNum) {
                System.out.println("Sorry, try again " + name);
                if(guesses%10==0)
                {
                    System.out.println("Would you like to give up? (y - 1) (n - 2)");
                    int giveUp = input.nextInt();
                    if(giveUp == 1)
                    {
                        System.out.println("You gave up at " + guesses + " guesses");
                        System.exit(1);
                    }
                }
                guess = input.nextInt();
                guesses++;
                if (guess == randomNum) {
                    System.out.println("Congratulations, you have guessed the number! It took you " + guesses + " tries");
                    input.close();
                }
            }
        }
        else if(choice == 2)
        {
            int currentGuess = max/2;
            int lower = 0;
            int upper = max;
            System.out.println("I will be guessing your number " + name);
            System.out.println("Please input your number, I won't cheat, this is for you to remember/not cheat.");
            int yourNum = input.nextInt();
            System.out.println("too high(1),too low(2)");
            System.out.println(currentGuess);
            while(currentGuess != yourNum)
            {
                int higher = input.nextInt();
                if(higher == 2)
                {
                    lower = currentGuess;
                    currentGuess = (upper+currentGuess)/2;
                    System.out.println(currentGuess);
                }
                else if (higher ==1)
                {
                        upper = currentGuess;
                        currentGuess = (lower+currentGuess)/2;
                        System.out.println(currentGuess);
                }
            }

            System.out.println("Did i get it? Yes or No");
            String win = input.next();
            while(!win.toLowerCase().equals("yes") && !win.toLowerCase().equals("no"))
            {
                if (win.toLowerCase().equals("yes"))
                    System.out.println("I got it, good game " + name);
                else if (win.toLowerCase().equals("no"))
                    System.out.println("stop lying, cheater");
                else
                    {
                    System.out.println("Incorrect statement");
                    win = input.next();
                        if (win.toLowerCase().equals("no"))
                            System.out.println("stop lying, cheater");
                    }
            }
        }
    }
}


