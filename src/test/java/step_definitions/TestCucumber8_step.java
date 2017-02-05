package step_definitions;

import com.thomas.utilities.CucumberUtil;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

/**
 * Created by Thomas on 12/24/2016.
 */
public class TestCucumber8_step implements En {
    public TestCucumber8_step() {
        Given("^user tests lambda expression \\(using \"([^\"]*)\"\\)$", (String javaVersion) -> {
            System.out.println("user tests cucumber using " + javaVersion);
        });
        And("^user enters the following info \\(lambda way\\)$", (DataTable table) -> {
            CucumberUtil.set(table);
            System.out.println("##"+ CucumberUtil.get("password") +"##");
        });
    }
}
