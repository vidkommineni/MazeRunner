
import java.util.Stack;
import java.util.ArrayList;

public abstract class MazeSolver 
{
    protected Maze maze;
    private boolean solved;
    private boolean solvable;
    // private boolean notSolvable;

    //MazeSolverStack stack = new MazeSolverStack(maze);
    public MazeSolver(Maze maze)
    {
        maze.toString();
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());

        solved = false;
        solvable = true;
    }

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add (Square s);

    public abstract Square next();

    public boolean isSolved()
    {
        return solved;
    }

    public String getPath()
    {
        String status = "";
        //first check if the maze is solved
        //check if the maze is solvable
        
        if (solved) {
            return "The maze has been solved";
        } else if (solvable) {
            return "The maze is currently being solved";
        } else {
            return "This maze is not solvable";
        }

  
    }

    public void step()
    {
        if(isEmpty())
        {
            System.out.println("maze unreachable");  
            return;
        }

        //while(!workList.isEmpty())
        //{
        Square temp = next();
        //temp.setStatus('.');
        ArrayList <Square> nbrs = maze.getNeighbours(temp);

        for(int i = 0; i < nbrs.size(); i++)
        {
            if(nbrs.get(i).getType() == 3)
            {
                solved = true;
                return;
            }

            if(nbrs.get(i).getType() != 1 && nbrs.get(i).getStatus() != Square.EXPLORED)
            {
                add(nbrs.get(i));
                Square temp1 = nbrs.get(i);
                temp1.setStatus(Square.WORKLIST);
                //int r = temp1.getRow();
                //int c = temp1.getCol();

                //maze.squares[r][c] = temp1;           
            }

        }

    }

    //need to do getPath()

    public void solve()
    {

        while(!solved && solvable)
        {
            step();
        }
    }

}