package App;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Guesser {
    private final Display display;
    private final String word;
    private final boolean[] charactersGuessed;
    private boolean isFirstGuess = true;

    public Guesser() {

        String[] words = {"console", "revolution", "apple", "orange", "language"};

        Random rand = new Random();
        word = words[rand.nextInt(0, words.length - 1)];

        charactersGuessed = new boolean[word.length()];
        display = new Display();
    }

    public void doGuess(char character) {
        for (byte i = 0; i < charactersGuessed.length; i++) {
            if (word.charAt(i) == character) {
                charactersGuessed[i] = true;
            }
        }

        display.DisplayWord(word, charactersGuessed);
    }

    public Boolean IsWordGuessed()
    {
        byte count = 0;

        for (byte i = 0; i < charactersGuessed.length; i++)
        {
            if (charactersGuessed[i])
            {
                count++;
            }
        }

        return count == charactersGuessed.length;
    }

    public void play() {

        while (true) {

            if (IsWordGuessed()) {
                System.out.println("You guessed the word - " + word);
                break;
            }
            else if (isFirstGuess) {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter your first character: ");
                String s = in.nextLine();

                if (s.length() != 1) {
                    System.out.println("Invalid input");
                    continue;
                }

                isFirstGuess = false;

                char ch = s.charAt(0);

                doGuess(ch);
            } else {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter your character: ");
                String s = in.nextLine();
                if (Objects.equals(s, word)) {
                    System.out.println("You guessed the word - " + word);
                    break;
                }
                if (s.length() != 1) {
                    System.out.println("Invalid input");
                    continue;
                }



                char ch = s.charAt(0);

                doGuess(ch);
            }
        }
    }
}
