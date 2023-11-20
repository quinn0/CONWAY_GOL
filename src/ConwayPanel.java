import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
// import java.util.ArrayList;

class ConwayPanel extends JPanel
{
   // private static final int FRAMEX;
   // private static final int FRAMEY;

   private static final Color BACKGROUND = Color.WHITE;
   private int frameX;
   private int frameY;

   private BufferedImage myImage;  
   private Graphics myBuffer;
   private Timer t;
   private World earth;
   private int cellSize;

   
   public ConwayPanel(int x, int y, int size)// # of life forms = framex*framey/100
   {
      frameX = x;
      frameY= y;
      cellSize = size;
   
      myImage =  new BufferedImage(frameX, frameY, BufferedImage.TYPE_INT_RGB); //Make the image that will store each frame
      myBuffer = myImage.getGraphics(); //Get the Graphics object we can use to manipulate the image
      myBuffer.setColor(BACKGROUND);    //The next two lines draw the background rectangle for the first time
      myBuffer.fillRect(0,0,frameX,frameY);
      earth = new World(x,y, cellSize);  //initial (random) population
      ///NOTE: Find seed for 3-arg
      // earth = new World(null, x, y)
   
      t = new Timer(100, new AnimationListener());  
      t.start();  //Starts the timer
   }
   
   
   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
      
   public void animate()
   {  
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,frameX,frameY);
      earth.evolve();
      earth.drawMe(myBuffer);
      //Call built-in JFrame method repaint(), which calls paintComponent, which puts the next frame on screen
      repaint();
   }
   
   //private classes
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
}
