
public interface QueueADT<T>
{
    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */public void offer(T item);

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     */
    public abstract T poll();
    
    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     */
    public abstract T peek();

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public abstract int size();

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * Clear out the data structure
     */
    public abstract void clear();
    
}