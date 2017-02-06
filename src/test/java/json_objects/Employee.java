package json_objects;

/**
 * Created by Thomas on 02/05/2017.
 */
public class Employee {
    // Create more subclasses if needed.
    // If you need an array: employee.set( new Engineer[]{eng1, eng2} );
    private String id = "";
    private String name = "";
    private String salary = "";

    /* -----------------------------------------------------
    Getters
    ----------------------------------------------------- */

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    /* -----------------------------------------------------
    Setters
    ----------------------------------------------------- */

    public void setId(int id) {
        this.id = String.valueOf(id);
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = String.valueOf(salary);
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
}
