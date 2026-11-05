public class GuitarPlayer {
    public void main (String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double frequency = 440 * Math.pow(1.05956,i-24);
            strings[i] = new GuitarString(frequency);
        }

        strings[keyboard.indexOf("n")].pluck();
        playSample(strings);
        strings[keyboard.indexOf("n")].pluck();
        playSample(strings);
        strings[keyboard.indexOf("/")].pluck();
        playSample(strings);
        strings[keyboard.indexOf("/")].pluck();
        playSample(strings);
    }

    private void playSample(GuitarString[] strings) {
        double sample = 0;
        for (int i = 0; i < strings.length; i++) {
            sample += strings[i].sample();
            strings[i].tic();
        }
        StdAudio.play(sample);
    }
}
