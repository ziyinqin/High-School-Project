class Main
{
  
  public static void main(String[] args)
  {
    String filePath = "p.wav";
    PlayMusic.playMusic(filePath);
    int numGuesses = Difficulty.setUp();
    new Game(numGuesses);   
  }

}
