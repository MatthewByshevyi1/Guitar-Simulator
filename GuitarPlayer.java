

public class GuitarPlayer {
    public static void main (String[] args) throws InterruptedException {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double frequency = 440 * Math.pow(1.05956,i-24);
            strings[i] = new GuitarString(frequency);
        }

        for (int i = 0; i < 10; i++) {
            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(" ")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(" ")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);

            Thread.sleep(500);

            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);

            Thread.sleep(500);

            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);

            Thread.sleep(500);

            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);

            Thread.sleep(500);

            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(" ")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(" ")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("/")].pluck();
            playSample(strings);

            Thread.sleep(500);

            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(".")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf(",")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("m")].pluck();
            playSample(strings);
            strings[keyboard.indexOf("n")].pluck();
            playSample(strings);

            Thread.sleep(500);
        }
    }

    private static void playSample(GuitarString[] strings) {
        for (int j = 0; j < 22050; j++) {
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
                strings[i].tic();
            }
            StdAudio.play(sample);
        }
    }
}
