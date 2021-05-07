package automation.data.thingsWhatHaveSwitches;

import automation.data.AutomationElement;

/**
 * This class represents a light
 * extends from the automation element and implements
 * the interface switcher
 */
public class Light extends AutomationElement implements Switcher {

    /**
     * A flag for the running of the light
     */
    private boolean isRunning;

    /**
     * Constructor
     * @param name the name of the light
     */
    public Light(String name) {
        super(name);
    }

    public Light(String name, boolean isRunning) {
        super(name);
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
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
     * Getter for the status of the light
     * @return true if the light is running or false if the light is not running
     */
    public boolean getStatus() {
        return isRunning;
    }

    @Override
    public String toString() {
        //return super.toString() + "switched " + ( isRunning ? "on" : "off" );
        return super.toString() + ";" + ( isRunning ? "on" : "off" );
    }

}
