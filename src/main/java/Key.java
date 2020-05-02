import java.util.Properties;

public class Key {
    private static String API_KEY;

    Properties properties = new Properties();

    public static String getApiKey() {
        return API_KEY;
    }

    public static void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }
}
