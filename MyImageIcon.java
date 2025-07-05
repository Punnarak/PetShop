import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;

class MyImageIcon extends ImageIcon {
  public MyImageIcon(String fname) {
    super(fname);
  }

  public MyImageIcon(Image image) {
    super(image);
  }

  public MyImageIcon resize(int width, int height) {
    Image oldimg = this.getImage();
    Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new MyImageIcon(newimg);
  }
};