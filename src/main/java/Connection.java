import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Connection {

    public static boolean testConnection(String key) {
        try {
            sendRequest(key, "test", false);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void sendRequest(String key, String text, boolean printToConsole) throws IOException {
        URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("key", key);
        parameters.put("text", text);
        parameters.put("lang", "en-ru");
        parameters.put("format", "plain");

        connection.setDoOutput(true);
        try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
        }

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String result = Parser.parseJSON(stringBuilder.toString()).getText().get(0);
            if (printToConsole) System.out.println(result);
        } finally {
            connection.disconnect();
        }
    }
}
