package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * #Author :Sino
 * #Date   :2021/11/13 11:24
 * #Describe:
 */
public class ConfUtils {

    private ConfUtils() {}

    private static Properties getConfProperties() throws IOException {
        Properties properties = new Properties();
        FileReader reader = new FileReader("E:\\Information\\project-2022\\FashionAnalysis\\src\\main\\resources\\core-conf.properties");
        properties.load(reader);

        return properties;
    }

    public static String getCoreConf(String confParam) throws IOException {
        Properties properties = getConfProperties();

        return properties.getProperty(confParam);
    }

    public static List<String> getCoreConf(List<String> confParams) throws IOException {
        List<String> confList = new ArrayList<>();
        Properties properties = getConfProperties();
        for (String confParam : confParams) {
            String confValue = properties.getProperty(confParam);
            confList.add(confValue);
        }

        return confList;
    }
}
