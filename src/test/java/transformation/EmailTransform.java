package transformation;

import cucumber.api.Transformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Thomas on 12/24/2016.
 */
public class EmailTransform extends Transformer<String> {
    // In my experience, this doesn't work with java8

    @Override
    public String transform(String email) {
        Pattern r = Pattern.compile("[@]");
        Matcher m = r.matcher(email);
        if (!m.find()) {
            email = email.concat("@hotmail.com");
        }
        return email;
    }
}
