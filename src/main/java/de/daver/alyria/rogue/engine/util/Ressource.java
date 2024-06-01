package de.daver.alyria.rogue.engine.util;

import java.io.InputStream;
import java.net.URL;

public class Ressource {

    private Ressource() {}

    private static ClassLoader getClassLoader() {
        return Ressource.class.getClassLoader();
    }

    public static InputStream asStream(String path) {
        return getClassLoader().getResourceAsStream(path);
    }

    public static URL asURL(String path) {
        return getClassLoader().getResource(path);
    }

}
