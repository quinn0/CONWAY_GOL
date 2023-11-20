import java.awt.*;

public class LifeForm extends Square{
    
    private boolean living;
    public LifeForm(int cellSize, int x, int y, boolean l)
    {
        super(cellSize, x, y, Color.BLACK);
        living = l;
    } 
    
    public boolean isAlive(){

           return living;
    }

    public void setLife(boolean state)
    {
       living = state;
    }

    public void drawMe(Graphics g)
    {   if(isAlive())
        {
            setColor(Color.BLACK);
            super.drawMe(g);
        }
        else
        {
            setColor(Color.WHITE);
            super.drawMe(g);
        }
    }

}

    
