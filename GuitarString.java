import java.util.concurrent.ThreadLocalRandom;

/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
    RingBuffer rb;
    int tics;

    public GuitarString(double frequency) 
    {
        rb = new RingBuffer((int)(44100/frequency)+1);
        tics = 0;
        pluck();
    }

    public GuitarString(double[] array) 
    {
        rb = new RingBuffer(array.length);

        for (double d : array) {
            rb.add(d);
        }
        tics = 0;
    }

    public void pluck() 
    {
        int size = rb.size();
        for (int i = 0; i < size; i++) {
            rb.remove();
            rb.add(ThreadLocalRandom.current().nextDouble(-0.5, Math.nextUp(0.5)));
        }
    }

    // advance the simulation one time step
    public void tic() 
    {
        double first = rb.remove();
        double second = rb.peek();

        double newVib = 0.994 * 0.5 * (first + second);
        rb.add(newVib);
        tics++;
    }

    // return the current sample
    public double sample() 
    {
        return rb.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return tics;
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
