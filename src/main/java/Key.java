import java.io.*;
import java.util.Properties;

public class Key {
    private static final String PROPERTY_PATH = "key.properties";
    Properties properties = new Properties();

    public String getApi_key() {
        try {
            File file = new File(PROPERTY_PATH);
            if (file.createNewFile()) System.out.println("Properties file was created");
            try(FileInputStream fileInputStream = new FileInputStream(PROPERTY_PATH)) {
                properties.load(fileInputStream);
                return properties.getProperty("key");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setApi_key(String api_key) {
        try {
            try(FileOutputStream fileOutputStream = new FileOutputStream(PROPERTY_PATH)) {
                properties.setProperty("key", api_key);
                properties.store(fileOutputStream, "api_key");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileExists(String path) {
        return new File(path).exists();
    }
}
