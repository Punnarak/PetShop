import javax.sound.sampled.*; // for sounds
class MySoundEffect {
  private Clip clip;
  private FloatControl gainControl;
  boolean mute = false;
  float previousVolume = 0;
  float currentVolume = 50;
  
  public MySoundEffect(String filename) {
    try {
        
      java.io.File file = new java.io.File(filename);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
      clip = AudioSystem.getClip();
      clip.open(audioStream);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void set() {
     
     
  }
  public void playOnce() {
    clip.setMicrosecondPosition(0);
    clip.start();
  }

  public void playLoop() {

    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void stop() {
    clip.stop();
  }
}