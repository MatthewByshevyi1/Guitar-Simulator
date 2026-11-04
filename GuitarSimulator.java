/**
 * This GuitarSimulator object . . .
 * 
 * @author  
 * @version 
 * 
 * Black keys: 2,4,5,7,8,9,-,=  d,f,g,j,k,;,'
 * White keys: q,w,e,r,t,y,u,i,o,p,[  z x c v b n m,,,.,/,
 */
public class GuitarSimulator
{
    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double frequency = 440 * Math.pow(1.05956,i-24);
            strings[i] = new GuitarString(frequency);
        }

        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                int index = keyboard.indexOf(key);

                if (index != -1) {
                    strings[index].pluck();
                }
            }

            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
                strings[i].tic();
            }

            // send the result to standard audio
            StdAudio.play(sample);
        }
    }
}
