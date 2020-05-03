import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Translator {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Key key = new Key();
            if (key.getApi_key() == null) {
                System.out.print("Type here your API key: ");
                String api_key = reader.readLine();
                if (Connection.testConnection(api_key)) {
                    key.setApi_key(api_key);
                } else {
                    System.out.println("Wrong key");
                    return;
                }
            }
            System.out.print("Text to be translated: ");
            Connection.sendRequest(key.getApi_key(), reader.readLine(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
