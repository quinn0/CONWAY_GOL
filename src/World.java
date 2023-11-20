import java.awt.*;
// import java.swing.*;
import java.lang.Math;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

public class World implements Evolution {
    private LifeForm[][] lifeForms;
    private int row;
    private int col;
    
    public World(int x, int y, int cellSize)
    { 

        row = y/cellSize;
        col = x/cellSize;
        lifeForms  = new LifeForm[row][col]; 

        for (int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
            
                lifeForms[i][j] = new LifeForm(cellSize, (i+1)*cellSize, (j+1)*cellSize, randomState());
            }

        }
        System.out.println(""+lifeForms.length+"\t" +lifeForms[0].length);

        //temporary to make seed
        // try
        // {
        // PrintWriter seedMaker = new PrintWriter(new FileWriter(new File("seed.txt")));
        // }
        // catch(Exception ex)
        // {
        //     System.out.println("Where's your seed?" + ex);
        // }

    }

    //set initial seed with 0/1 dead/living supplied by user
    // 
    // public World(int[][] seed, int x, int y, int cellSize)
    // {
    //     row = y/cellSize;
    //     col = x/cellSize;
    //     if(seed[0].length != col || seed.length != row)
    //     {
    //         System.out.println("You are restricted to a " + (row-1) + " by " + (col-1) + " population.");
    //     }
    //     else
    //     {
    //         lifeForms = new LifeForm[seed.length][seed[0].length]
    //         for(int i = 0; i < seed.length; i++)
    //         {
    //             for(int j = 0; j<seed[0].length; j++)
    //             {
    //                 if(seed[i][j] == 0)
    //                 {
    //                     lifeForms[i][j] = new LifeForm(cellSize, x, y, false);
    //                 } 
    //                 else
    //                 {
    //                     lifeForms[i][j] = new LifeForm(cellSize, x, y, true);

    //                 }
    //             }
    //         }
    //     }

    // }


    


// assigns initial state as random grid
    public boolean randomState()
    {
        double randomLife = Math.random();
        if(randomLife > .12){return false;}
        else{return true;}

    }

    public void evolve()
    {
        for(int i = 0; i<lifeForms.length; i++){
            for(int j = 0; j < lifeForms[0].length; j++)
            {
            int n = checkNeighbors(i,j);
            //living cells
            if(lifeForms[i][j].isAlive())
            {
                if (n < 2 || n > 3){ //dies
                    lifeForms[i][j].setLife(false);
                }
                else if(n <= 3){
                    continue;} // stays alive
            }
            // dead cells
            if (n == 3)
            {
                lifeForms[i][j].setLife(true);
                
            }
        }
    }
     } 
     
 
    //nieghboring cells
    public LifeForm[] getNeighbors(int i, int j) 
    {
       LifeForm[] neighbors= null;
       //top/bottom cases
        if(i == 0)
        {
            //top right 3 neighbors
            if(j == col-1)
            {
                neighbors = new LifeForm[]{lifeForms[i][j-1], lifeForms[i+1][j], lifeForms[i+1][j-1]};
            }
        //top left 3 neighbors
            else if (j == 0)
            {
                neighbors = new LifeForm[]{lifeForms[i][j+1], lifeForms[i+1][j], lifeForms[i+1][j+1]};
            }
            else //top edge, 5 neighbors
            {
                neighbors = new LifeForm[]{lifeForms[i][j+1], lifeForms[i+1][j], lifeForms[i][j-1],
                                                         lifeForms[i+1][j+1], lifeForms[i][j-1]};
            }
        }
        else if(i == row-1)
        {
            //bottom right 3 neighbors
            if(j == col-1)
            {
               neighbors = new LifeForm[]{lifeForms[i][j-1], lifeForms[i-1][j], lifeForms[i-1][j-1]};
            }
            //bottom left 3 neighbors
            else if (j == 0)
            {
                neighbors = new LifeForm[]{lifeForms[i][j+1], lifeForms[i-1][j], lifeForms[i-1][j+1]};
            }
            // bottom edge, 5 neighbors
            else
            {
                neighbors = new LifeForm[]{lifeForms[i][j+1], lifeForms[i-1][j], lifeForms[i-1][j-1],
                    lifeForms[i-1][j+1], lifeForms[i][j-1]};

            }
        }
        //left/right edge cases (corners accounted for above) 5 neighbors
        else if(j == 0)
        {
            neighbors = new LifeForm[]{lifeForms[i+1][j], lifeForms[i-1][j], lifeForms[i+1][j+1],
                                        lifeForms[i-1][j+1], lifeForms[i][j+1]};
        }
        else if (j==col-1)
        {
            neighbors = new LifeForm[]{lifeForms[i+1][j], lifeForms[i-1][j], lifeForms[i+1][j-1],
                lifeForms[i-1][j-1], lifeForms[i][j-1]};

        }
        //remaining cells
        else
        {
            neighbors = new LifeForm[]{lifeForms[i-1][j-1], lifeForms[i][j-1],  
                                       lifeForms[i+1][j-1], lifeForms[i-1][j+1], 
                                       lifeForms[i][j+1], lifeForms[i+1][j+1], 
                                       lifeForms[i-1][j], lifeForms[i+1][j]};
        }

    return neighbors;
    }

    public int checkNeighbors(int i, int j)
    {
        int ncount = 0;        
       for(LifeForm cell : getNeighbors(i, j))
       {
          if(cell.isAlive())
          {
             ncount++;
          }         
       }
       return ncount;
    }


    public LifeForm[][] getLifeForms() {
        return lifeForms;
    }

    public void drawMe(Graphics g)
    {
        for(int i = 0; i < lifeForms.length; i++ )
        {
            for(LifeForm cell : lifeForms[i])
            {
                cell.drawMe(g);
            }
        }
    }
}


//todo