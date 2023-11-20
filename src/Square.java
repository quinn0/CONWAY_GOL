import java.awt.*;

public class Square
{
   //fields
   private int side;
   private int x;  //x coordinate of top left corner
   private int y;  //y coordinate of top left corner
   private Color c;
   
   //constructors
   public Square()
   {
      side = 10;
      x = 10;
      y = 10;
      c = Color.WHITE;
   }
   // public Square(int sideValue, int xValue, int yValue, Color cValue)
   // {
   //    side = sideValue;
   //    x = xValue;
   //    y = yValue;
   //    c = cValue;
   // }

   public Square(int size, int xv, int yv, Color col)
   {
      side = size;
      x = xv;
      y = yv;
      c = col;
   }
   
   //accessors
   public int getSide()
   {
      return side;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Color getColor()
   {
      return c;
   }
   
   //modifiers
   public void setSide(int sideValue)
   {
      side = sideValue;
   }
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setColor(Color cValue)
   {
      c = cValue;
   }
   
   //instance methods
   public void drawMe(Graphics g)
   {
      g.setColor(c);
      g.fillRect(x, y, side, side);
   }
   
   //other useful Java methods
   
   //(leave this commented out until the assignment tells you to use it)
   
   public String toString()
   {
      return "Square at " + x + ", " + y + " with side length " + side + " and color set to " + c;
   }
   
   
}