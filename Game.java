/**
 * Name: AboutDialog.java
 * @author: Yi Jia Huang, Ziyin Qin and Simon on GitHub
 * @since: 2023-01-19
 * This class creates the logic of entire game and 
 * controls the operation of GUI.
 */

 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JTextField;
 import javax.swing.JOptionPane;
 import javax.swing.event.*;
 import java.awt.*;  
 import javax.swing.*;
 import java.awt.event.*;  
 import javax.swing.SwingUtilities;
 
 public class Game extends JFrame implements ActionListener {
 
   private  JFrame frame;
 
   private  JLabel Title;
   private  JLabel stats;
   private  JTextField userText1;
   private  JLabel[] labels;
 
   private  final String ANSI_RESET = "\u001B[0m";
   private  final String ANSI_YELLOW = "\u001B[33m";
   private  final String ANSI_GREEN = "\u001B[32m";
 
   private int totalTries;
   private char[] input;
   private long startTime;
   private char[] answer;
   private boolean done;
   private int tries;
 
   private String[] correct = Pokedex.choosePokemon();
   private String correctPokemonName = correct[2].toLowerCase();
   private int PLength = correctPokemonName.length();
   private String dashes = "-";
 
   /**
    * A Game constructor that creates the Game frame by creating the main
    * panel and enter button. 
    * Postcondition: the Game frame and the correct
    * number of dashes appears. 
    * @param int numGuesses the number of guesses the user will get.
    */
   public Game(int numGuesses) {
     totalTries = numGuesses;
 
     // Create the frame and set the icon of the frame
     frame = new JFrame();
     frame.setSize(300, 400);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setTitle("PokeWordle");
     ImageIcon img = new ImageIcon("resources/Icon.png");
     frame.setIconImage(img.getImage());
     frame.setLocationRelativeTo(null);
 
     // Create the background of the game
     ImageIcon img2 = new ImageIcon(new ImageIcon("resources/background.png").getImage().getScaledInstance(300, 375, Image.SCALE_DEFAULT));
     JLabel myLabel = new JLabel(img2);
     myLabel.setSize(220+(PLength-5)*15, 400);
     frame.add(myLabel);
 
     // Set the title
     myLabel.setLayout(null);
     Title = new JLabel("Wordle: ");
     Title.setBounds(30, 20, 80, 25);
     myLabel.add(Title);
 
     // Tell the user the length of the selected word
     myLabel.setLayout(null);
     stats = new JLabel("Type a " + PLength + " letter word");
     stats.setBounds(30, 50, 180, 25);
     myLabel.add(stats);
 
     // Set the textbox for the user
     userText1 = new JTextField();
     userText1.addActionListener(this);
     userText1.setBounds(30, 90 + (0 * 25), 80+(PLength-5)*15, 25);
     myLabel.add(userText1);
 
     // Add the button Enter
     JButton button = new JButton("Enter");
     button.setBounds(175, 20, 80, 25);
     button.addActionListener(this);
     myLabel.add(button);
 
     // Create the correct number of dashes
     for (int i = 0; i < PLength-1; i++) {
       dashes += "-";
     }
 
     // print out the dashes and the menubar
     labels = new JLabel[totalTries];
     String inp = "<html><font size='5' color=blue> " + dashes + " </font> <font";
     for (int i = 0; i < totalTries; i++) {
         labels[i] = new JLabel(inp);
         labels[i].setBounds(40, 90 + (i * 25), PLength*30, 25);
         myLabel.add(labels[i]);
     }
     frame.setJMenuBar(createMenuBar());
     frame.setVisible(true);
 
     StartWordle(); 
   }
 
   /**
    * Set up the initial value for the game
    * Postcondition: the Game frame and the correct
    * number of dashes appears. 
    * @param int numGuesses the number of guesses the user will get.
    */
   private void StartWordle() {
 
     // Put each letter of input into an array and start the timer
     startTime = System.currentTimeMillis();
     tries = 0;
     answer = new char[PLength];
     for (int i = 0; i < PLength; i++ ) answer[i] = correctPokemonName.charAt(i);
 
     input = new char[PLength];
   }
 
   /**
    * Tell the user result and give them two choices, restart or quit
    * Postcondition: the game will either restart or quit
    */
   private void EndWordle() {
     // create the buttons for restart and quit
     JButton restart = new JButton("Restart");
     JButton quit = new JButton("Quit");
 
     // let the game stop when quit button is clicked
     quit.addMouseListener(new MouseInputAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
           System.exit(ABORT);
       }
     });
 
     // Close the previous frame and create a new one when restart is clicked
     restart.addMouseListener(new MouseInputAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
           frame.dispose();
           new Game(totalTries);
           Window w = SwingUtilities.getWindowAncestor(restart);
           w.setVisible(false);
       }
     });
 
     // Create a pop up window with the two buttons and the results
     Object[] options = {restart, quit};
     String endMessage =  new String();
     String message2 = new String();
     if (!done) {
         endMessage = "<html><font size='1' color=red> " + "The Answer Was: " + new String(correctPokemonName) + ". You wasted " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds (:" + "</font> <font";
         message2 = "Too Bad";
     }
     else  {
         endMessage = "<html><font size='1' color=green> " + "You Found The Answer in " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds and " + tries + " tries." + "</font> <font";
         message2 = "Congrats";
     }
     JOptionPane.showOptionDialog(null, endMessage, message2,
     JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
     null, options, options[0]);
   }
 
   /**
    * Lead the system to ButtonPressed method when the button is clicked
    * @param ActionEvent event that program is detecting 
    */
   @Override
   public void actionPerformed(ActionEvent e) {
       ButtonPressed();
   }
 
   /**
    * Take the user's input and check if the user can still 
    * play the game or not, and check the position of each letter.
    */
   private void ButtonPressed(){
     // get the user's input
     String userInput = userText1.getText();
 
     // Check input's length
     if (userInput.length() != PLength){
       JOptionPane.showMessageDialog(frame, "Please Enter The Correct Length");
     } else{
       userText1.setBounds(30, 90 + ((tries + 1) * 25), 80+(PLength-5)*15, 25);
 
       int[] colorOfLetters = PlayWordle(userInput);
 
       // Check if each is letter is in the correct position
       done = true;
       for (int i : colorOfLetters) {
         if (i != 2) {
           done = false;
         }
       }
 
       // Check if the game should end or not
       if (done || tries > totalTries - 1) {
         EndWordle();
       }
 
       // set the color of each letter
       String[] numsToColors = new String[PLength];
       for (int i = 0; i < PLength; i++) {
         if (colorOfLetters[i] == 0) {
           numsToColors[i] = "black";
         }
         else if (colorOfLetters[i] == 1) {
           numsToColors[i] = "orange";
         }
         else if (colorOfLetters[i] == 2) {
           numsToColors[i] = "green";
         }
       }
 
       // create and print the colored input on the frame
       String finalString = new String("");
       for (int i = 0; i< PLength; i++){
         finalString = finalString+ "<html><font size='5' color=" + numsToColors[i] + "> " + userInput.charAt(i) + "</font> <font            ";
       }
 
       setNextLabel(finalString);
       
     } 
     //set the text box to "" after all the logic is done
     userText1.setText("");
   }
 
   /**
    * Provide the hint to the user and put the letter of answer to an array
    * return int[] PlayWordle return the array with each letter of input
    * @para String InputWordleWord the user's input
    */
   private int[] PlayWordle(String InputWordleWord) {
     done = false;
     tries++;
 
     // provide the hint at specific time
     if (tries > 2) {
       stats.setText("<html><font size='1' color=blue> " + "Primary Type: " + correct[4] + "</font> <font");
     } 
     
     if (tries > 4) {
         if(correct[5].equals("")) {
             stats.setText("<html><font size='1' color=blue> " + "Secondary Type of this Pokemon:\t" + "none"+ "</font> <font");
           } 
           else {
             stats.setText("<html><font size='1' color=blue> " + "Secondary Type of this Pokemon:\t" + correct[5]+ "</font> <font");
           }
     }
 
     // set the input into lower case
     String R1 = InputWordleWord.toLowerCase();
 
     for (int i = 0; i < R1.length(); i++ ) { 
       //puts the inputWord into a char[]
       input[i] = R1.charAt(i);
     }
     
     //reset answer every time
     for (int i = 0; i < R1.length(); i++ ) {
       answer[i] = correctPokemonName.charAt(i);
     }
     return ReturnColorOfLeters(input, answer);
   }
 
   /**
    * put the colored input to the on the frame
    * @para String string the colored input
    */
   private void setNextLabel(String string){
       labels[tries - 1].setText(string);
   }
 
   /**
    * Check the position and color code(0,1,2) all the letters
    * return int[] ReturnColorOfLeters the color code 
    * of letter for the input word
    * @para char[] inputWord the array of user's input
    * @param char[] correctWord the array of the correct Pokemon name
    */
   private int[] ReturnColorOfLeters(char[] inputWord, char[] correctWord) {
     char[] answerTemp = correctWord;
     int[] colorForLetter = new int[PLength]; 
 
     //0 is grey, yellow is 1, green is 2
     for (int i = 0; i < PLength; i++) { 
       //check for any correct position+letter (green)
       if (inputWord[i] == answerTemp[i]) {
         answerTemp[i] = '-';
         colorForLetter[i] = 2;
       }
     }
 
     for (int j = 0; j < PLength; j++) { 
       //check for any correct letter (yellow)
       for (int k = 0; k < PLength; k++){
         if (inputWord[j] == answerTemp[k] && colorForLetter[j] != 2) {
           //if that letter is not already green and matches some other letter
           colorForLetter[j] = 1;
           answerTemp[k] = '-';
         }
       }
     }
 
     // print it in the console for checking
     for (int m = 0; m < PLength; m++) {
       if (colorForLetter[m] == 0) {
         System.out.print(inputWord[m]);
       }
       if (colorForLetter[m] == 1) {
         System.out.print(ANSI_YELLOW + inputWord[m] + ANSI_RESET);
       }
       if (colorForLetter[m] == 2) {
         System.out.print(ANSI_GREEN + inputWord[m] + ANSI_RESET);
       }
     }
 
     System.out.println("");
     return colorForLetter;
   }
 
   /**
    * Creates a JMenuBar that has a drop-down menu to access Instructions and About
    * dialogs
    * @returns the JMenuBar that was created
    */
   private JMenuBar createMenuBar() {
     JMenuBar menuBar = new JMenuBar();
     
     JMenu helpMenu = new JMenu("Help"); //make a drop down menu labelled 'help'
     menuBar.add(helpMenu);
     
     JMenuItem instructionsItem = new JMenuItem("Instructions...");
     // instructionsItem.addActionListener(event -> new InstructionsDialog(this)); //constuct a InstructionsDialog if instrcutionsItem is pressed
     helpMenu.add(instructionsItem);
     
     JMenuItem aboutItem = new JMenuItem("About...");
     // aboutItem.addActionListener(event -> new AboutDialog(this)); //constuct a AboutDialog if AboutDialog is pressed
     helpMenu.add(aboutItem);
     
     return menuBar;
   }
   
    public JFrame getFrame() {
     return frame;
   }
 }
 
   