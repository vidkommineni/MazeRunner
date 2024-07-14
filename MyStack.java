
public class MyStack implements StackADT
{
    private Square[] stack;
    private int size;
    private int initialCap;

    public MyStack()
    {
        this(10);
    }

    public MyStack(int initCap)
    {
        stack = new Square[initCap];
        size = 0;
        initialCap = initCap;
    }


    public Square peek()
    {
        Square val= new Square(0,0,0);
        try
        {
            val = stack[size-1];
        }
        catch(Exception e){
            System.out.println("EmptyStackException");
        }
        return val;
    }

    public Square pop()
    {
        Square val= new Square (0,0,0);
        try
        {
            val = stack[size-1];
            Square[] arr = new Square [stack.length-1];

            for(int i = 0; i < arr.length; i++)
            {
                arr[i] = stack[i];
            }

            stack = arr;
            size--;
        }
        catch(Exception e){
            System.out.println("EmptyStackException");
        }
        return val;
    }

    public void push(Square item)
    {
        if(stack.length == size)
        {
            doubleCapacity();
            stack[size] = item;
            size++;
        }
        else
        {
            stack[size] = item;
            size++;
        }
    }

    private void doubleCapacity()
    {
        Square[] arr = new Square [stack.length*2];

        for(int i = 0; i < stack.length; i++)
        {
            arr[i] = stack[i];
        }

        stack = arr;
    }
    
    @Override
    public void clear() {
        stack = new Square[initialCap];
        size = 0;
    }  
    
    public int size()
    {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public String toString()
    {
        String word = "";
        for(int  i = stack.length-1; i > 0; i--)
        {
            word = word + stack[i];
        }
        return word;
    }
}