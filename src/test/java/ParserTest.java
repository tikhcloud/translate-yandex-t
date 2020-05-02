import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class ParserTest {

    @Test
    public void shouldParseJsonIntoWrapper() {
        TranslateWrapper translateWrapper = new TranslateWrapper();
        translateWrapper.setCode(200);
        translateWrapper.setLang("en-ru");
        translateWrapper.setText(Collections.singletonList("Test String"));

        String JSON = "{\n" +
                "    \"code\": 200,\n" +
                "    \"lang\": \"en-ru\",\n" +
                "    \"text\": [\n" +
                "        \"Test String\"\n" +
                "    ]\n" +
                "}";

        Assert.assertEquals(translateWrapper, Parser.parseJSON(JSON));
    }
}