package automation.data;

/**
 * This abstract class is the generalization of all kinds of elements
 * from a home automation system
 */
public abstract class AutomationElement {

    /**
     * The name of the element
     */
    private String name;

    /**
     * Constructor
     * @param name the name of the automation element
     */
    public AutomationElement(String name) {
        this.name = name;
    }

    /**
     * Setter for the field name
     * @param name the new name of the element
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the field name
     * @return the name of the automatic element
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        //return name + ": ";
        return name;
    }

}
