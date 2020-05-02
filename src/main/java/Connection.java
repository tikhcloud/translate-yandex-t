import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Connection {

    public static void sendRequest(String key, String text) throws IOException {
        URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //create params for connection
        Map<String, String> parameters = new HashMap<>();
        parameters.put("key", key);
        parameters.put("text", text);
        parameters.put("lang", "en-ru");
        parameters.put("format", "plain");

        //set params for connection
        connection.setDoOutput(true);
        try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
        }

        //set timeout for connection and for reading, for 5 seconds
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(Parser.parseJSON(stringBuilder.toString()).getText().get(0));
        }
        connection.disconnect();
    }
}
