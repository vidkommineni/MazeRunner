
import java.util.*;
public class MazeSolverStack extends MazeSolver
{
    private MyStack workList;
    public MazeSolverStack(Maze maze)
    {
        super(maze);
        Square start = maze.getStart();
        add(start);
    }

    public void makeEmpty()
    {
        workList = new MyStack();
    }

    public boolean isEmpty()
    {
        return workList.isEmpty();
    }

    @Override
    public void add(Square s)
    {
        workList.push(s);
    }

    public Square next()
    {
        return workList.pop();
    }

    
}
