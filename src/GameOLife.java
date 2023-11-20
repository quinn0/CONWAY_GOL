import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.lang.Integer;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class GameOLife
{
   public static void main(String[] args) throws Exception
   {
      JFrame frame = new JFrame(" Game O' Life ");
      //User sets Gen 0. Must be 
      String usrInit = JOptionPane.showInputDialog("Would you like to set initial generation? (y/n)");
      if(usrInit.equals("y"))
      {
         Scanner seedRead = new Scanner(new File("seed.txt"));
         
      }
      String dims = JOptionPane.showInputDialog("Specify dimensions x, y, and cell size \n separated by space");
      //Appropriate Laptop dims
      int x = Integer.parseInt(dims.split(" ")[0]); // 1000
      int y = Integer.parseInt(dims.split(" ")[1]); // 800
      int size = Integer.parseInt(dims.split(" ")[2]);// 5... not affecting pixel size?
      frame.setSize(x, y);      //In Windows, the menu bar at the top is 25 pixels tall...
      
      frame.setLocation(300, 15);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      System.out.print("" + x + ", " + y);
      frame.getContentPane().setPreferredSize(new Dimension(x,y));  
      frame.setContentPane(new ConwayPanel(x, y, size));    
      frame.setVisible(true);
   }
}