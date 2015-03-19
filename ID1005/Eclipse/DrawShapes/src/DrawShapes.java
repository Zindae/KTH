// DrawShapes.java

import javax.swing.*;


public class DrawShapes {

  // Huvudprogram för DrawShapes.
  public static void main (String [] args) {

    // Skapa ett fönster med namnet på programmet.
    JFrame frame = new JFrame ("DrawShapes");

    // Om man stänger fönstret så avslutas programmet.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Skapa en JPanel som innehåller det som visas i fönstret.
    JPanel panel = new ShapesPanel();

    // Stoppa in panelen i fönstret.
    frame.getContentPane().add(panel);

    // Se till att det som är i fönstret får plats
    frame.pack();

    // Gör fönster och innehåll synligt för användaren.
    frame.setVisible(true);
  }
} // slut på DrawShapes.
