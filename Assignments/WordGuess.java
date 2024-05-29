package Assignments;


import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class WordGuess {

	private JFrame frame;
	private ArrayList<String>[] listOfWords = new ArrayList[3];
	private int level = 1;
	private String pickedWord = "";
	private String completeAnswer = "";
	private String displayedWord = "";
	private int mistakes = 0;
	private int givenLetterIndex1 = 0;
	private int givenLetterIndex2 = 0;
	JLabel lblLblword;
	private JPanel panel, panel_1;
	private JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordGuess window = new WordGuess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WordGuess() {
		initialize();

		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(125, 36, 565, 391);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JLabel lblWordguess = new JLabel("WordGuess 1.0");
		lblWordguess.setForeground(Color.ORANGE);
		lblWordguess.setFont(new Font("Comic Sans MS", Font.BOLD, 37));
		lblWordguess.setBounds(10, 11, 301, 52);
		panel_1.add(lblWordguess);

		JLabel lblAuthorFFF = new JLabel("Author: FFF");
		lblAuthorFFF.setBounds(20, 58, 150, 14);
		panel_1.add(lblAuthorFFF);

		JLabel label = new JLabel("2024");
		label.setBounds(20, 74, 46, 14);
		panel_1.add(label);

		JTextPane txtpnTextareasettextthisIsMy = new JTextPane();
		txtpnTextareasettextthisIsMy.setRequestFocusEnabled(false);
		txtpnTextareasettextthisIsMy.setEditable(false);
		txtpnTextareasettextthisIsMy.setText("This is my version of Hangman. Guess the word using the keyboard. There are no limitations on how many tries you can have. There are three levels and you can choose the level you want after you guessed the word correctly. Have fun!");
		txtpnTextareasettextthisIsMy.setBounds(20, 104, 521, 211);
		panel_1.add(txtpnTextareasettextthisIsMy);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(251, 326, 89, 23);
		panel_1.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setEnabled(true);
				setKeyboardVisibility(true);
			}
		});

		lblLblword = new JLabel(pickWord());
		lblLblword.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		lblLblword.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblword.setBounds(10, 23, 764, 102);
		lblLblword.setFocusable(true);
		frame.getContentPane().add(lblLblword);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Keyboard", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(125, 220, 565, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// *********************keyboard***********************************
		initializeKeyboard();
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem1 = new JMenuItem("About");
		mntmNewMenuItem1.setSize(50, 50);
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setEnabled(false);
				setKeyboardVisibility(false);
			}
		});
		menuBar.add(mntmNewMenuItem1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 500);
		frame.setTitle("WordGuess 1.0");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		for (int i = 0; i < 3; i++) {
			listOfWords[i] = new ArrayList<>();
		}
		
		loadWordsFromCSV("D:\\\\2nd Year files\\\\2nd Semester Files\\\\4. Object Oriented Programming\\\\HELLOWORLD\\\\src\\\\Assignments\\\\words.csv");
	}

	/**
	 * This will pick and display the word to be guessed.
	 */
	private String pickWord() {
		Random randomizer = new Random();
		int index = randomizer.nextInt(listOfWords[level - 1].size());

		pickedWord = listOfWords[level - 1].get(index).toUpperCase();

		givenLetterIndex1 = randomizer.nextInt(pickedWord.length());
		do {
			givenLetterIndex2 = randomizer.nextInt(pickedWord.length());
		} while (givenLetterIndex1 == givenLetterIndex2);

		completeAnswer = "";
		displayedWord = "";

		for (int ctr = 0; ctr < pickedWord.length(); ctr++) {
			completeAnswer = completeAnswer + " " + pickedWord.charAt(ctr);
			if (givenLetterIndex1 == ctr || givenLetterIndex2 == ctr) {
				displayedWord = displayedWord + " " + pickedWord.charAt(ctr);
			} else {
				displayedWord = displayedWord + " _";
			}
		}

		return displayedWord;
	}

	@SuppressWarnings("static-access")
	private void validateGuess(char letter) {
		boolean correct = false;
		char[] charWord = displayedWord.toCharArray();
		for (int ctr = 0; ctr < pickedWord.length(); ctr++) {
			if (givenLetterIndex1 == ctr || givenLetterIndex2 == ctr) {
				continue;
			}
			if (pickedWord.charAt(ctr) == letter) {
				charWord[ctr * 2 + 1] = pickedWord.charAt(ctr);
				correct = true;
			}
		}
		if (!correct) {
			mistakes++;
			JOptionPane.showMessageDialog(frame, "Wrong guess!", "Incorrect", JOptionPane.ERROR_MESSAGE);
		} else {
			displayedWord = displayedWord.copyValueOf(charWord);
			lblLblword.setText(displayedWord);
			if (displayedWord.equals(completeAnswer)) {
				String[] options = { "Four-Letter Word", "Five-Letter Word", "Six-Letter Word", "Exit" };
				int chosenOption = JOptionPane.showOptionDialog(frame, "CONGRATULATIONS! Please choose level", "Word guessed!", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
				level = chosenOption + 1;

				if (chosenOption == 3) {
					System.exit(0);
				}
				
				displayedWord = "";
				completeAnswer = "";
				lblLblword.setText(pickWord());
			}
		}
	}

	private void loadWordsFromCSV(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (values.length == 2) {
					int wordLevel = Integer.parseInt(values[0].trim()) - 1;
					if (wordLevel >= 0 && wordLevel < listOfWords.length) {
						listOfWords[wordLevel].add(values[1].trim());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the keyboard buttons.
	 */
	private void initializeKeyboard() {
		btnA = createKeyboardButton('A', 10, 26);
		btnB = createKeyboardButton('B', 65, 26);
		btnC = createKeyboardButton('C', 120, 26);
		btnD = createKeyboardButton('D', 175, 26);
		btnE = createKeyboardButton('E', 230, 26);
		btnF = createKeyboardButton('F', 285, 26);
		btnG = createKeyboardButton('G', 340, 26);
		btnH = createKeyboardButton('H', 395, 26);
		btnI = createKeyboardButton('I', 450, 26);
		btnJ = createKeyboardButton('J', 505, 26);
		btnK = createKeyboardButton('K', 10, 72);
		btnL = createKeyboardButton('L', 65, 72);
		btnM = createKeyboardButton('M', 120, 72);
		btnN = createKeyboardButton('N', 175, 72);
		btnO = createKeyboardButton('O', 230, 72);
		btnP = createKeyboardButton('P', 285, 72);
		btnQ = createKeyboardButton('Q', 340, 72);
		btnR = createKeyboardButton('R', 395, 72);
		btnS = createKeyboardButton('S', 450, 72);
		btnT = createKeyboardButton('T', 505, 72);
		btnU = createKeyboardButton('U', 120, 118);
		btnV = createKeyboardButton('V', 175, 118);
		btnW = createKeyboardButton('W', 230, 118);
		btnX = createKeyboardButton('X', 285, 118);
		btnY = createKeyboardButton('Y', 340, 118);
		btnZ = createKeyboardButton('Z', 395, 118);
	}

	private JButton createKeyboardButton(char letter, int x, int y) {
	    JButton button = new JButton(String.valueOf(letter));
	    button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	    button.setBounds(x, y, 50, 35);
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            validateGuess(letter);
	            // button.setEnabled(false); // Remove this line
	        }
	    });
	    panel.add(button);
	    return button;
	}


	private void setKeyboardVisibility(boolean visible) {
		btnA.setVisible(visible);
		btnB.setVisible(visible);
		btnC.setVisible(visible);
		btnD.setVisible(visible);
		btnE.setVisible(visible);
		btnF.setVisible(visible);
		btnG.setVisible(visible);
		btnH.setVisible(visible);
		btnI.setVisible(visible);
		btnJ.setVisible(visible);
		btnK.setVisible(visible);
		btnL.setVisible(visible);
		btnM.setVisible(visible);
		btnN.setVisible(visible);
		btnO.setVisible(visible);
		btnP.setVisible(visible);
		btnQ.setVisible(visible);
		btnR.setVisible(visible);
		btnS.setVisible(visible);
		btnT.setVisible(visible);
		btnU.setVisible(visible);
		btnV.setVisible(visible);
		btnW.setVisible(visible);
		btnX.setVisible(visible);
		btnY.setVisible(visible);
		btnZ.setVisible(visible);
	}
}