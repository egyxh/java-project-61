package hexlet.code;
import java.util.Random;
public class Utils {
    private static final Random RANDOM = new Random();
    public static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
