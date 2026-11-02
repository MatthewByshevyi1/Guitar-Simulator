/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private int front;
    private int back;
    private int size;
    private double[] buffer;

    private int next(int index) {
        if (index == buffer.length-1) {
            return 0;
        }
        return index + 1;
    }

    public RingBuffer(int capacity)
    {
        front = -1;
        back = 0;
        size = 0;
        buffer = new double[capacity];
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean isFull()
    {
        return size == buffer.length;
    }
    
    public void add(double value) throws InvalidActionException
    {
        if (isFull()) {
            throw new InvalidActionException("RingBuffer is full.");
        }

        buffer[back] = value;
        
        if (size == 0) {
            front = back;
        }
        back = next(back);
        size++;
    }
    
    public double peek()
    {
        if (isEmpty()) {
            throw new InvalidActionException("RingBuffer is empty.");
        }

        return buffer[front];
    }
    
    public double remove() throws InvalidActionException
    {
        if (isEmpty()) {
            throw new InvalidActionException("RingBuffer is empty.");
        }

        double retrn = buffer[front];
        buffer[front] = 0;
        front = next(front);
        size--;

        return retrn;
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
