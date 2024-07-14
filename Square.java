
public class Square
{
    private int row;
    private int col;
    private int type;
    private char status;

    public Square(int r, int c, int t)
    {
        row = r;
        col = c;
        type = t;
    }

    public String toString()
    {
        if(type == 0)
        {
           return "Empty space";
        }
        else if(type == 1)
        {
            return "Wall";
        }
        else if(type == 2)
        {
            return "Start";
        }
        else if(type == 3)
        {
            return "Exit";
        }
        
        return "Type out of bound";
    }

    public int getRow()
    {
        return row;   
    }

    public int getCol()
    {
        return col;   
    }

    public int getType()
    {
        return type;   
    }

    public char getStatus()
    {
        return status;   
    }

    public boolean equals(Object obj)
    {
        Square newObj = (Square) obj;

        return newObj.getRow() == row && newObj.getCol() == col;
    }
}



