package co.uk.fractalwrench;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        List<Integer> depths = loadInput();
        int count = 0;

        for (int k = 1; k < depths.size(); k++) {
            if (depths.get(k - 1) < depths.get(k)) {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }

    private static List<Integer> loadInput() {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new ResourceReader().getReader("day1.input")) {
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
