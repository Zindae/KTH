// ShapesPanel.java

import java.awt.*;
import javax.swing.*;

public class ShapesPanel extends JPanel {

  // Skapa en rektangel och en triangel.
  Rectangle rect = new Rectangle();
  Triangle tri = new Triangle();

  public ShapesPanel() {
    // Tala om vilken f�rsta storlek vi �nskar ha.
    setPreferredSize (new Dimension (400,400));
  }

  // Denna metod anropas fr�n paintComponent och dess uppgift �r att
  // rita den Shape som bifogats p� ett slumpm�ssigt valt st�lle p�
  // sk�rmen, och med en storlek mellan 1 och 60.
  protected void drawShapeSomewhere(Graphics g, Dimension panelSize, Shape sh)
  {
    // Slumpa fram var p� ritytan
    int shapeX = (int) (Math.random() * panelSize.getWidth());
    int shapeY = (int) (Math.random() * panelSize.getHeight());

    // Slumpa fram bredd och h�jd.
    int shapeWidth  = 1 + (int) (Math.random() * 60);
    int shapeHeight = 1 + (int) (Math.random() * 60);

    // Rita denna Shape.
    sh.draw (g, shapeX, shapeY, shapeWidth, shapeHeight);
  }

  // Metoden paintComponent anropas varje g�ng denna JPanel beh�ver
  // ritas om. Det sker automatiskt, t ex om storleken har �ndrats.
  public void paintComponent (Graphics g) {
    super.paintComponent(g);

    Dimension panelSize = getSize(); // Hur stor ritytan �r just nu.

    // Femtio g�nger, rita en rektangel och en triangel.
    for (int i = 0; i < 50; i++) {
      drawShapeSomewhere(g, panelSize, rect);
      drawShapeSomewhere(g, panelSize, tri);
    }

  }

} // slut p� ShapesPanel.
