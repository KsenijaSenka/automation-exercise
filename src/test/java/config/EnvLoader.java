package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvLoader {
    private static Properties properties = new Properties();

    public static void load(String environment) throws IOException {
        String fileName = environment + ".properties";
        FileInputStream inputStream = new FileInputStream("src/test/resources/" + fileName);
        properties.load(inputStream);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

