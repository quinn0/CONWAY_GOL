import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.lang.Integer;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.lang.Math;

public class GameOLife
{
   public static void main(String[] args) throws Exception
   {
      JFrame frame = new JFrame(" Game O' Life ");
      //User sets Gen 0. Must be 
    /*   String usrInit = JOptionPane.showInputDialog("Would you like to set initial generation? (y/n)");
      if(usrInit.equals("y"))
      {
         Scanner seedRead = new Scanner(new File("seed.txt"));
         
      } */
      String dims = JOptionPane.showInputDialog("Specify dimensions x, y, and cell size \n separated by space");
      //Appropriate Laptop dims
      int row = Integer.parseInt(dims.split(" ")[0]); // 800
      int col = Integer.parseInt(dims.split(" ")[1]); // 1000
      int size = Integer.parseInt(dims.split(" ")[2]);// 5... not affecting pixel size?
      frame.setSize(row, col);      //In Windows, the menu bar at the top is 25 pixels tall...
      
      frame.setLocation(300, 15);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      System.out.print("" + row + ", " + col);
      frame.getContentPane().setPreferredSize(new Dimension(row,col));  
      frame.setContentPane(new ConwayPanel(row, col, size));    
      frame.setVisible(true);

   }


   /*
      //writing some code for seed here before making class

      String dims = JOptionPane.showInputDialog("Specify dimensions x, y, and cell size \n separated by space");
      //Appropriate Laptop dims
      int size = Integer.parseInt(dims.split(" ")[2]); 
      int row = Integer.parseInt(dims.split(" ")[0])/size; 
      int col = Integer.parseInt(dims.split(" ")[1])/size; 
      String[][] cells = new String[row][col]; 
      
      int cell; 

      PrintWriter p = new PrintWriter(new FileWriter("seed.txt"));


      //RandomSeed For initial state. other states TBA manually
      for(int i = 0; i < row; i++)
      {
         for(int j = 0; j < col; j++)
      {
         cell = (int) Math.round(Math.random());
         cells[i][j] = Integer.toString(cell); 
      }
      }

      for(String[] item:cells)
      {
         for (String value:item)
         {
            p.write(value);
         }
         p.println("");
      }
      p.close();

      }
      */
   
}
