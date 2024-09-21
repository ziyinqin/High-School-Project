import java.io.File;
import javax.sound.sampled.*;
// import javax.swing.JOptionPane;

public class PlayMusic {
  
  public void main(String[] args) {
    

  }
  
  public static void playMusic(String musicLocation) {
    
    try{
      
      File musicPath = new File(musicLocation);
      
      if(musicPath.exists()){
        System.out.println("yes");
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
      } else{
        System.out.println("can't find file");
      }
      
    }
      
    catch(Exception ex) {
        System.out.println("no");
        ex.printStackTrace();
    }
  }
}