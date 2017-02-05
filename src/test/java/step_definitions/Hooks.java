package step_definitions;

import com.thomas.config.Settings;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

//public class Hooks extends FrameworkInitialize {
public class Hooks {
    @Before
    public void Initialize() throws IOException {
        Settings.populateSettings();
    }

    @After
    public void closing() {}
}
