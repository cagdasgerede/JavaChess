package pl.nogacz.chess.application;

import java.net.URL;

/**
 * @author Dawid Nogacz on 05.05.2019
 */
public class Resources {
    public static String getPath(String fileName) {
        ClassLoader classLoader = Resources.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);

        return resource.getProtocol() + ":" + resource.getPath();
    }
}