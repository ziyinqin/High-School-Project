import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Difficulty extends JFrame implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel Title;
    private static JButton easyButton, mediumButton, hardButton, impossibleButton;
    private static int numGuesses;
    private static boolean buttonPressed = false;


    public static int setUp() {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Introduction");
        ImageIcon img = new ImageIcon("C:\\Users\\Nancy\\OneDrive\\Desktop\\G12 CS\\Garble\\Icon.png");
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.add(panel);

      // hi, sure, I think the icon works now, wowwwwwwww that is so good!!! it  is !!! okok, and I will send you the flowchart now, it's ok~~~ yes!!!! I send it to you through drive (:
//hiii! are you working on this now? i can record rn so you can work on it
      //niceee!!
      //ok i know i should do the reflection first but ksadjfhasdkfh customizing is so fun
      //i might add custom fonts later
      //yeah itll be really cool i think! 
      //alright imma go record + practice, ill send the audio files to you soon :)
      //thanks!
      //yay! were so close to being donnneee, last stretch
      //gotchaaa
      
        panel.setLayout(null);
        Title = new JLabel("Select difficulty: ");
        Title.setBounds(10, 10, 200, 25);
        panel.add(Title);

        easyButton = new JButton("Easy");
        easyButton.setBounds(100, 50, 200, 25);
        easyButton.addActionListener(new Difficulty());
        panel.add(easyButton);


        mediumButton = new JButton("Medium");
        mediumButton.setBounds(100, 100, 200, 25);
        mediumButton.addActionListener(new Difficulty());
        panel.add(mediumButton);

        hardButton = new JButton("Hard");
        hardButton.setBounds(100, 150, 200, 25);
        hardButton.addActionListener(new Difficulty());
        panel.add(hardButton);

        impossibleButton = new JButton("Literally Impossible");
        impossibleButton.setBounds(100, 200, 200, 25);
        impossibleButton.addActionListener(new Difficulty());
        panel.add(impossibleButton);

        frame.setVisible(true);
        while (true) {
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            if (buttonPressed) {
                frame.setVisible(false);
                return numGuesses; 
            }
        }

    }    

    public void actionPerformed(ActionEvent e) {
        System.out.println("diff changed");
        if (e.getSource() == easyButton) {
            numGuesses = 9; 
        } 

        if (e.getSource() == mediumButton) {
            numGuesses = 6; 
        } 

        if (e.getSource() == hardButton) {
            numGuesses = 3; 
        } 

        if (e.getSource() == impossibleButton) {
            numGuesses = 1; 
        } 

        buttonPressed = true;
        
    }

}

