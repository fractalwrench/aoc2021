package co.uk.fractalwrench;

import java.io.BufferedReader;
import java.io.IOException;

public class Day2_2 {

    private static final String DIRECTION_FORWARD = "forward";
    private static final String DIRECTION_UP = "up";
    private static final String DIRECTION_DOWN = "down";

    private static class Position {
        int forward;
        int depth;
        int aim;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new ResourceReader().getReader("day2.input")) {
            Position position = new Position();
            String line;

            while ((line = reader.readLine()) != null) {
                alterSubPosition(position, line);
            }

            int result = position.forward * position.depth;
            System.out.println("Result: " + result);
        } catch (IOException exc) {
            throw new IllegalStateException("Expected input for day2", exc);
        }
    }

    private static void alterSubPosition(Position p, String line) {
        String[] tokens = line.split(" ");

        if (tokens.length != 2) {
            throw new IllegalStateException("Expected two tokens for line " + line);
        }

        String direction = tokens[0];
        int change = Integer.parseInt(tokens[1]);

        if (DIRECTION_FORWARD.equals(direction)) {
            p.forward += change;
            p.depth += (p.aim * change);
        } else if (DIRECTION_UP.equals(direction)) {
            p.aim -= change;
        } else if (DIRECTION_DOWN.equals(direction)) {
            p.aim += change;
        }
    }
}
