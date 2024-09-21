/**
 * Name: Instructions.java
 * @author: Evan Grawey, Yi Jia Huang, and user ggleblanc2 on GitHub
 * @since: 2023-01-19
 * This class creates a dialog popup that tells
 * the player about rules of PokeWordle and what the colours
 * of the letters mean.
 */
/* 
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.io.IOException;
 import java.net.URL;
 import javax.swing.BorderFactory;
 import javax.swing.JEditorPane;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 
 public class InstructionsDialog extends DialogPopup {
 
   private JEditorPane editorPane;
 
   /**
    * An InstructionsDialog constructor that creates the
    * InstructionsDialog frame by creating the mainpanel and cancel button. 
    * Postcondition: the InstructionsDialog frame appears. 
    * @param Game view an instance of a Game class in which the InstructionsDialog appears on.
    */
    /*
   public InstructionsDialog(Game view) {
     super(view, "Instructions");
   }
 
   @Override
   public JPanel createMainPanel() {
     JPanel panel = new JPanel(new BorderLayout()); //arranges components to fit in five regions: north, south, east, west, and center
     panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5)); //creates 5 px border around bottom, left, right sides of panel
 
     URL url = InstructionsDialog.class.getResource("/resources/instructions.htm"); //turns instructions file into url object
 
     editorPane = new JEditorPane();
     editorPane.setEditable(false);
     editorPane.setContentType("text/html");  
     try {
       editorPane.setPage(url); //load contets of instructions.htm onto editorPage
     } catch (IOException e) {
       e.printStackTrace();
     }
 
     JScrollPane scrollPane = new JScrollPane(editorPane); //make screen scrollable
     scrollPane.setPreferredSize(new Dimension(600, 480));
     panel.add(scrollPane, BorderLayout.CENTER);
 
     return panel;
   }
 
 }*/