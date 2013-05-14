package com.google.typography.font.sfntly.sample.sfview;

import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class SFView {
  public static void main(String[] args) throws IOException {

    for (String fontName : args) {
      Font[] fonts = loadFont(new File(fontName));
      System.out.println("Displaying font: " + fontName);
      JFrame jf = new JFrame("Sfntly Table Viewer");
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SFFontView view = new SFFontView(fonts[0]);
      JScrollPane sp = new JScrollPane(view);
      jf.add(sp);
      jf.pack();
      jf.setVisible(true);
    }
  }

  public static Font[] loadFont(File file) throws IOException {
    FontFactory fontFactory = FontFactory.getInstance();
    fontFactory.fingerprintFont(true);
    FileInputStream is = null;
    try {
      is = new FileInputStream(file);
      return fontFactory.loadFonts(is);
    } finally {
      if (is != null) {
        is.close();
      }
    }
  }
}
