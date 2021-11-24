package WorkingWithAbstractionExercise.jediGalaxy;

import java.util.Arrays;

public class InputParser {

    public static int[] parseIntegerArray(String readLine) {
        return Arrays.stream(readLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
