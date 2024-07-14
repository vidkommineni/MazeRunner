
public class MazeSolverQueue extends MazeSolver
{
    private MyQueue <Square> workList;

    public MazeSolverQueue(Maze maze)
    {
        super(maze);
        Square start = maze.getStart();
        add(start);
    }

    public void makeEmpty()
    {
        workList = new MyQueue<Square>();
    }

    public boolean isEmpty()
    {
        return workList.isEmpty();
    }

    @Override
    public void add(Square s)
    {
        workList.offer(s);
    }

    public Square next()
    {
        return workList.poll();
    }

}