package step_definitions;

import com.thomas.utilities.CucumberUtil;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import transformation.EmailTransform;

/**
 * Created by Thomas on 12/23/2016.
 */
public class TestCucumber_step {
    @Given("^user tests classic expression \\(using \"([^\"]*)\"\\)$")
    public void userTestsClassicExpressionUsing(String javaVersion) throws Throwable {
        System.out.println("user tests cucumber using " + javaVersion);
    }


    @And("^user tests classic table$")
    public void userTestsClassicTable() throws Throwable {
    }

    @And("^user enters the following info \\(classic way\\)$")
    public void userEntersTheFollowingInfoClassicWay(DataTable table) throws Throwable {
        // Basic way to access the DataTable
        /*
        List<List<String>> data = table.raw();
        for (int i=0, size=data.size(); i<size; i++) {
            System.out.println(i +"___"+ data.get(i));
        }
        */

        // With Object Oriented
        /*
        List<User> users = new ArrayList<>();
        users = table.asList(User.class);
        for (User user : users) {
            System.out.println("username:" + user.getUsername());
            System.out.println("password:" + user.getPassword());
        }
        */

        // With map
        CucumberUtil.set(table);
        System.out.println("##"+ CucumberUtil.get("password") +"##");
    }

    @And("^user enters the email address as \"([^\"]*)\"$")
    public void userEnterTheEmailAddressAs(@Transform(EmailTransform.class) String email) throws Throwable {
        // @Transform will modify the parameters before using it
        System.out.println("Email: " + email);
    }
}
