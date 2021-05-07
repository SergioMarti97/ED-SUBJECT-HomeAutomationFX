package automation.data.thingsWhatHaveSwitches;

import automation.data.AutomationElement;

/**
 * This class represents a machine which can heat
 * extends from the automation element and implements
 * the interface switcher
 */
public class Heating extends AutomationElement implements Switcher {

    /**
     * The temperature of the heating machine
     */
    private int temperature;

    /**
     * A flag to store if the machine is running or not
     */
    private boolean isRunning;

    /**
     * Full parametrized constructor
     * @param name the name of the heating
     * @param temperature the temperature of the heater
     * @param isRunning a flag to store if the machine is running or not
     */
    public Heating(String name, int temperature, boolean isRunning) {
        super(name);
        this.temperature = temperature;
        this.isRunning = isRunning;
    }

    /**
     * Constructor
     * @param name the name of the machine
     * @param temperature the temperature of the heater
     */
    public Heating(String name, int temperature) {
        super(name);
        this.temperature = temperature;
        isRunning = false;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void switchOn() {
        isRunning = true;
    }

    @Override
    public void switchOff() {
        isRunning = false;
    }

    /**
     * Getter for the temperature
     * @return the temperature of the heater
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature
     * @param temperature the new temperature of the heater
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public String toString() {
        //return super.toString() + "switched " + ( isRunning ? "on" : "off" ) + ", " + temperature + "°C";
        return super.toString() + ";" + ( isRunning ? "on" : "off" ) + ";" + temperature;
    }
}
