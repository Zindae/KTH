// DrawShapes.java

import javax.swing.*;

public class DrawShapes {

  // Huvudprogram f�r DrawShapes.
  public static void main (String [] args) {

    // Skapa ett f�nster med namnet p� programmet.
    JFrame frame = new JFrame ("DrawShapes");

    // Om man st�nger f�nstret s� avslutas programmet.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Skapa en JPanel som inneh�ller det som visas i f�nstret.
    JPanel panel = new ShapesPanel();

    // Stoppa in panelen i f�nstret.
    frame.getContentPane().add(panel);

    // Se till att det som �r i f�nstret f�r plats
    frame.pack();

    // G�r f�nster och inneh�ll synligt f�r anv�ndaren.
    frame.setVisible(true);
  }
} // slut p� DrawShapes.
