package Assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel wordPanel;
    private JPanel keyboardPanel;
    private JButton restartButton;
    private JLabel wordLabel;
    private List<String> words;
    private String selectedWord;
    private StringBuilder guessedWord;
    private int remainingGuesses;
    private List<JButton> letterButtons;

    public GUI() {
        initializeComponents();
        loadWords();
        startNewGame();
    }

    private void initializeComponents() {
        frame = new JFrame("Word Guessing Game");
        mainPanel = new JPanel();
        wordPanel = new JPanel();
        keyboardPanel = new JPanel();
        restartButton = new JButton("Restart");
        wordLabel = new JLabel();

        Font font = new Font("Arial", Font.PLAIN, 24);
        wordLabel.setFont(font);
        restartButton.setFont(font);

        restartButton.addActionListener(e -> startNewGame());

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        wordPanel.setLayout(new FlowLayout());
        wordPanel.add(wordLabel);

        keyboardPanel.setLayout(new GridLayout(4, 7, 5, 5));
        letterButtons = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton letterButton = new JButton(String.valueOf(c));
            letterButton.setFont(font);
            letterButton.addActionListener(this);
            letterButtons.add(letterButton);
            keyboardPanel.add(letterButton);
        }

        mainPanel.add(wordPanel, BorderLayout.NORTH);
        mainPanel.add(keyboardPanel, BorderLayout.CENTER);
        mainPanel.add(restartButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private void loadWords() {
        File csvFile = new File("D:\\2nd Year files\\2nd Semester Files\\4. Object Oriented Programming\\HELLOWORLD\\src\\Assignments\\words.csv");
        words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startNewGame() {
        selectRandomWord();
        updateWordLabel();
        enableAllLetterButtons();
        wordLabel.setText(guessedWord.toString() + " | Remaining guesses: " + remainingGuesses);
    }

    private void selectRandomWord() {
        Random rand = new Random();
        selectedWord = words.get(rand.nextInt(words.size()));
        guessedWord = new StringBuilder("_".repeat(selectedWord.length()));
        remainingGuesses = selectedWord.length();
    }

    private void updateWordLabel() {
        wordLabel.setText(guessedWord.toString() + " | Remaining guesses: " + remainingGuesses);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        char guessedChar = source.getText().toLowerCase().charAt(0);
        source.setEnabled(false);

        processGuess(guessedChar);
        updateWordLabel();
        checkGameStatus();
    }

    private void processGuess(char guessedChar) {
        boolean found = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (Character.toLowerCase(selectedWord.charAt(i)) == guessedChar) {
                guessedWord.setCharAt(i, selectedWord.charAt(i));
                found = true;
            }
        }

        if (!found) {
            remainingGuesses--;
        }
    }

    private void checkGameStatus() {
        if (guessedWord.toString().equals(selectedWord)) {
            wordLabel.setText("Congratulations! You've guessed the word: " + selectedWord);
            disableAllLetterButtons();
        } else if (remainingGuesses <= 0) {
            wordLabel.setText("Game over! The word was: " + selectedWord);
            disableAllLetterButtons();
        }
    }

    private void enableAllLetterButtons() {
        for (JButton button : letterButtons) {
            button.setEnabled(true);
        }
    }

    private void disableAllLetterButtons() {
        for (JButton button : letterButtons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
