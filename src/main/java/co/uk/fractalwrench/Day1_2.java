package co.uk.fractalwrench;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day1_2 {

    public static void main(String[] args) {
        List<Integer> depths = loadInput();
        int count = 0;

        for (int k = 3; k < depths.size(); k++) {
            int a = calculateSlidingWindow(depths, k - 1);
            int b = calculateSlidingWindow(depths, k);
            if (a < b) {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }

    private static int calculateSlidingWindow(List<Integer> depths, int lastIndex) {
        if (lastIndex < 2) {
            throw new IllegalArgumentException();
        }
        return depths.get(lastIndex) + depths.get(lastIndex - 1) + depths.get(lastIndex - 2);
    }

    private static List<Integer> loadInput() {
        List<Integer> list = new ArrayList<>();
        ClassLoader classLoader = Day1_2.class.getClassLoader();

        try (InputStream is = classLoader.getResourceAsStream("day1.input")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null) {
                Integer value = Integer.parseInt(line);
                list.add(value);
            }
        } catch (IOException exc) {
            throw new IllegalStateException("couldn't find input", exc);
        }
        return list;
    }
}
