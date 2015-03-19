// ShapesPanel.java

import java.awt.*;
import javax.swing.*;

public class ShapesPanel extends JPanel {

  // Skapa en rektangel och en triangel.
  Rectangle rect = new Rectangle();
  Triangle tri = new Triangle();

  public ShapesPanel() {
    // Tala om vilken första storlek vi önskar ha.
    setPreferredSize (new Dimension (400,400));
  }

  // Denna metod anropas från paintComponent och dess uppgift är att
  // rita den Shape som bifogats på ett slumpmässigt valt ställe på
  // skärmen, och med en storlek mellan 1 och 60.
  protected void drawShapeSomewhere(Graphics g, Dimension panelSize, Shape sh)
  {
    // Slumpa fram var på ritytan
    int shapeX = (int) (Math.random() * panelSize.getWidth());
    int shapeY = (int) (Math.random() * panelSize.getHeight());

    // Slumpa fram bredd och höjd.
    int shapeWidth  = 1 + (int) (Math.random() * 60);
    int shapeHeight = 1 + (int) (Math.random() * 60);

    // Rita denna Shape.
    sh.draw (g, shapeX, shapeY, shapeWidth, shapeHeight);
  }

  // Metoden paintComponent anropas varje gång denna JPanel behöver
  // ritas om. Det sker automatiskt, t ex om storleken har ändrats.
  public void paintComponent (Graphics g) {
    super.paintComponent(g);

    Dimension panelSize = getSize(); // Hur stor ritytan är just nu.

    // Femtio gånger, rita en rektangel och en triangel.
    for (int i = 0; i < 50; i++) {
      drawShapeSomewhere(g, panelSize, rect);
      drawShapeSomewhere(g, panelSize, tri);
    }

  }

} // slut på ShapesPanel.
