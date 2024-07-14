
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Maze
{
    private Square[][] squares;
    private int numRows;
    private int numCol;
    private Square start;
    private Square exit;
    private File file;
    public Maze()
    {
        loadMaze("maze-2");
    }

    public boolean loadMaze(String fileName)
    {
        try{    
            file = new File(fileName);
            Scanner input = new Scanner(new File(fileName));

            numRows = input.nextInt();
            numCol = input.nextInt();

            squares = new Square[numRows][numCol];
            for(int r = 0; r < numRows; r++)
            {
                for(int c = 0; c < numCol; c++)
                {
                    squares[r][c] = new Square(r, c, input.nextInt());
                    if (squares[r][c].getType() == 2) {
                        start = squares[r][c];
                    } else if (squares[r][c].getType() == 3) {
                        exit = squares[r][c];
                    }
                }
            }
            return true;
        }
        catch(FileNotFoundException f)
        {
            return false;   
        }

    }

    public int getNumRows()
    {
        return numRows;
    }
    
    public int getNumCol()
    {
        return numCol;
    }
    
    public ArrayList<Square> getNeighbours(Square s)
    {
        ArrayList<Square> neighbours = new ArrayList<Square>();

        for(int r = 0; r < squares.length; r++)
        {
            for(int c = 0; c < squares[r].length; c++)
            {
                if(r < squares.length - 1)
                {
                    neighbours.add(squares[r+1][c]);
                }
                if(c < squares.length - 1)
                {
                    neighbours.add(squares[r][c+1]);
                }
                if(r > 0 )
                {
                    neighbours.add(squares[r-1][c]);
                }
                if(c > 0 )
                {
                    neighbours.add(squares[r][c-1]);
                }
            }
        }

        return neighbours;
    }

    public Square getStart()
    {
        
        return start;
    }

    public Square getExit()
    {
        
        return exit;
    }

    public void reset()
    {   
        loadMaze(file.getName());
    }

    public String toString()
    {
        String word = "";
        for(int r = 0; r < squares.length; r++)
        {
            for(int c = 0; c < squares[0].length; c++)
            {
                word += squares[r][c].toString() + " ";
            }
            word += "\n";
        }
        
        return word;
    }

    
}