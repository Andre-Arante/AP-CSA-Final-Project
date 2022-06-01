import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private String progress = "_____";
    private String word;
    private int guesses = 0;
    private final int MAX_GUESSES = 6;
    private final ArrayList<String> entries = new ArrayList<String>();
    private int correct = 0;

    public void startGame() throws FileNotFoundException {
        word = getWord();
    }

    public void reveal(String letter, int idx) {
        if (word.substring(idx, idx+1).equalsIgnoreCase(letter)) {
            StringBuilder update = new StringBuilder();
            update.append(progress);
            correct++;
            update.setCharAt(idx, letter.charAt(0));
            progress = update.toString();
        }
    }
    public String mark(String guess) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < guess.length(); i++) {

            String temp = guess.substring(i, i+1);
            String surround = " ";

            if (word.contains(temp)) {
                surround = "__";
                if(word.indexOf(temp) == guess.indexOf(temp)) {
                    reveal(temp, i);
                    surround = "**";
                }
            }
            s.append(surround).append(temp).append(surround).append(" ");
        }
        return s.toString();
    }
    public void guess(String guess) {
        entries.add(mark(guess));
        guesses++;
    }
    public String formatGuesses() {
        StringBuilder s = new StringBuilder();
        for (String entry : entries) {
            s.append(entry).append("\n");
        }
        return s.toString();
    }
    public int getRemaining() {
        return MAX_GUESSES - guesses;
    }
    public String getWord() throws FileNotFoundException {
        String[] words;
        String line = "";
        // File file = new File("C:/Users/andre/Github/bots/bot3/src/main/java/words.txt");
        File file = new File("C:/Users/16693/Git_Repositories/bots/bot3/src/main/java/txt/words.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            line += sc.nextLine();

        words = line.split(" ");
        return words[(int) (Math.random() * words.length)];
    }
    public boolean isValidWord(String guess) throws FileNotFoundException {
        if (guess.length() != 5) return false;

        String[] words;
        String line = "";
        // File file = new File("C:/Users/andre/Github/bots/bot3/src/main/java/words.txt");
        File file = new File("C:/Users/16693/Git_Repositories/bots/bot3/src/main/java/txt/words.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            line += sc.nextLine();

        words = line.split(" ");

        for (String word : words) {
            if (word.equals(guess)) return true;
        }
        return false;
    }
    public String toString() {
        return word;
    }
    public boolean wordGuessed() { return correct == 5; }
}

