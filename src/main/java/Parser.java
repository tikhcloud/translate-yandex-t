import com.google.gson.Gson;

public class Parser {
    public static TranslateWrapper parseJSON(String json) {
        return new Gson().fromJson(json, TranslateWrapper.class);
    }
}
