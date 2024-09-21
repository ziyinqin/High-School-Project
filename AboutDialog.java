/**
 * Name: AboutDialog.java
 * @author: Evan Grawey and user ggleblanc2 on GitHub, Yi Jia Huang
 * @since: 2023-01-19
 * This class creates a dialog popup that tells
 * the player about the history of Wordle.
 */
/*
 import java.awt.Color;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.Insets;
 import javax.swing.BorderFactory;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JTextArea;
 
 public class AboutDialog extends DialogPopup {
     

       public AboutDialog(Game view) {
           super(view, "About");
       }
     
  
   @Override
   public JPanel createMainPanel() {
         JPanel panel = new JPanel(new GridBagLayout()); //arrange components into a grid
         panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5)); //creates 5 px border around bottom, left, right sides of panel
 
     GridBagConstraints gbc = new GridBagConstraints();
         gbc.anchor = GridBagConstraints.CENTER;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.insets = new Insets(0, 5, 5, 30); //add padding to bottom, left, right, top
 
         gbc.gridwidth = 2; //number of rows
         gbc.gridx = 0; 
         gbc.gridy = 0; 
         JLabel label = new JLabel("About Wordle"); //names window
         label.setHorizontalAlignment(JLabel.CENTER); 
         Color backgroundColor = label.getBackground(); 
         panel.add(label, gbc);
         
         gbc.gridy++; //move a row down
         String text = "Wordle was created by software engineer "
                 + "and former Reddit employee, Josh Wardle, and "
                 + "was launched in October 2021.";
         JTextArea textArea = new JTextArea(4, 25);
         textArea.setBackground(backgroundColor);
         textArea.setEditable(false);
         textArea.setLineWrap(true);
         textArea.setText(text);
         textArea.setWrapStyleWord(true);
         panel.add(textArea, gbc);
         
         gbc.gridwidth = 1;
         gbc.gridy++;
         label = new JLabel("Author:");
         panel.add(label, gbc);
         
         gbc.gridx++;
         label = new JLabel("Jia, Ziyin, and Evan");
         panel.add(label, gbc);
         
         gbc.gridx = 0;
         gbc.gridy++;
         label = new JLabel("Date Created:");
         panel.add(label, gbc);
         
         gbc.gridx++;
         label = new JLabel("January 20, 2023");
         panel.add(label, gbc);
         
         gbc.gridx = 0;
         gbc.gridy++;
         label = new JLabel("Version:");
         panel.add(label, gbc);
         
         gbc.gridx++;
         label = new JLabel("1.0");
         panel.add(label, gbc);
         
         return panel;
     }
 }*/