import java.util.List;
import java.util.Objects;

public class TranslateWrapper {
    private int code;
    private String lang;
    private List<String> text;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslateWrapper that = (TranslateWrapper) o;
        return code == that.code &&
                Objects.equals(lang, that.lang) &&
                Objects.equals(text, that.text) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, lang, text, message);
    }
}
