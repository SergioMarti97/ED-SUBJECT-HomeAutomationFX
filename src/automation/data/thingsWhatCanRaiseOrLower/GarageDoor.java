package automation.data.thingsWhatCanRaiseOrLower;

import automation.data.thingsWhatCanGetLocked.Door;

/**
 * This class represents a garage door
 * extends from the AutomationElement and implements
 * the interface raise or lower the element
 */
public class GarageDoor extends Door implements RaiseOrLower {

    /**
     * The percent of the garage door is open
     */
    private int percent;

    /**
     * Constructor
     * @param name the name of the garage door
     * @param isLocked a flag to store if the garage door is locked
     * @param percent the percent of the garage door
     */
    public GarageDoor(String name, boolean isLocked, int percent) {
        super(name, isLocked);
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public void raise() {
        percent = 100;
    }

    @Override
    public void raise(int percent) {
        this.percent = percent;
    }

    @Override
    public void lower() {
        percent = 0;
    }

    @Override
    public void lower(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        //return super.toString() + ", " + percent + "%";
        return super.toString() + ";" + percent;
    }

}
