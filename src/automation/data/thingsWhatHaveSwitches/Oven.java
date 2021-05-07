package automation.data.thingsWhatHaveSwitches;

/**
 * This class represents a oven
 * A oven extends from a heating machine
 */
public class Oven extends Heating {

    /**
     * Full parametrized constructor
     * @param name the name of the oven
     * @param temperature the temperature of the oven
     * @param isRunning if the oven is running
     */
    public Oven(String name, int temperature, boolean isRunning) {
        super(name, temperature, isRunning);
    }

    /**
     * Constructor
     * @param name the name of the oven
     * @param temperature the temperature of the oven
     */
    public Oven(String name, int temperature) {
        super(name, temperature);
    }

}
