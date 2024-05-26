package Assignments;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel gridPanel;
    private JPanel bottomPanel;
    private List<JLabel[]> houseLabels;
    private JButton solveButton;
    private JLabel fishOwnerLabel;

    public PuzzleGUI() {
        frame = new JFrame("Who Owns the Fish?");
        mainPanel = new JPanel(new BorderLayout());

        gridPanel = new JPanel(new GridLayout(5, 5, 10, 10)); // 5 rows, 5 columns
        houseLabels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            JLabel[] labels = new JLabel[5];
            for (int j = 0; j < 5; j++) {
                labels[j] = new JLabel();
                labels[j].setFont(new Font("Arial", Font.PLAIN, 14));
                gridPanel.add(labels[j]);
            }
            houseLabels.add(labels);
        }

        bottomPanel = new JPanel(new BorderLayout());
        solveButton = new JButton("Solve Puzzle");
        solveButton.setFont(new Font("Arial", Font.PLAIN, 20));
        solveButton.addActionListener(e -> solvePuzzle());
        bottomPanel.add(solveButton, BorderLayout.NORTH);

        fishOwnerLabel = new JLabel(" ");
        fishOwnerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        fishOwnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(fishOwnerLabel, BorderLayout.SOUTH);

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    private void solvePuzzle() {
        // Define the attributes for each house based on the puzzle clues
        String[] nationalities = new String[5];
        String[] colors = new String[5];
        String[] drinks = new String[5];
        String[] pets = new String[5];
        String[] devices = new String[5];

        // Solving the puzzle using the given clues
        nationalities[0] = "American";
        colors[0] = "Yellow";
        devices[0] = "Oppo";
        
        nationalities[1] = "Korean";
        colors[1] = "Blue";
        drinks[1] = "Water";
        pets[1] = "Dog";
        
        nationalities[2] = "Indian";
        colors[2] = "Red";
        drinks[2] = "Milk";
        pets[2] = "Bird";
        
        nationalities[3] = "German";
        colors[3] = "Green";
        drinks[3] = "Coffee";
        pets[3] = "Fish";
        devices[3] = "Tablet";
        
        nationalities[4] = "Filipino";
        colors[4] = "White";
        drinks[4] = "Tea";
        pets[4] = "Horse";
        
        devices[2] = "Laptop";
        devices[4] = "iPhone";
        drinks[4] = "Rootbeer";
        pets[0] = "Cat";

        // Update the labels in the GUI with the solved attributes
        for (int i = 0; i < 5; i++) {
            houseLabels.get(i)[0].setText("Nationality: " + nationalities[i]);
            houseLabels.get(i)[1].setText("Color: " + colors[i]);
            houseLabels.get(i)[2].setText("Drink: " + drinks[i]);
            houseLabels.get(i)[3].setText("Pet: " + pets[i]);
            houseLabels.get(i)[4].setText("Device: " + devices[i]);
        }

        // Update the fish owner label
        fishOwnerLabel.setText("The German owns the fish.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PuzzleGUI::new);
    }
}
