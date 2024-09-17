package megogo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Utilities {

    public static String getConfigValue(String parameterName)  {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "configuration.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  properties.getProperty(parameterName);
    }
}
