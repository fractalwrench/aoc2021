package co.uk.fractalwrench;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceReader {

    public InputStream getResourceStream(String name) {
        ClassLoader classLoader = ResourceReader.class.getClassLoader();
        return classLoader.getResourceAsStream(name);
    }

    public BufferedReader getReader(String name) {
        return new BufferedReader(new InputStreamReader(getResourceStream(name)));
    }
}
