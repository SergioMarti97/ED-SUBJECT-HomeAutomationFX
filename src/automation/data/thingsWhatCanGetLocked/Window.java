package automation.data.thingsWhatCanGetLocked;

import automation.data.AutomationElement;
import automation.data.thingsWhatCanRaiseOrLower.Blind;

/**
 * This class represents a Window
 * extends from the AutomationElement and implements
 * the interface for lock or unlock the element
 */
public class Window extends AutomationElement implements LockOrUnlock {

    /**
     * The blind of the window
     */
    private Blind blind;

    /**
     * a flag to store if the door is locked or not
     */
    private boolean isLocked;

    /**
     * Constructor
     * @param name the name of the window
     * @param blind the blind of the window
     */
    public Window(String name, Blind blind) {
        super(name);
        this.blind = blind;
        isLocked = false;
    }

    public Window(String name, boolean isLocked, int percent) {
        super(name);
        this.isLocked = isLocked;
        this.blind = new Blind(name  + " Blind", percent);
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public void lock() {
        isLocked = true;
    }

    @Override
    public void unlock() {
        isLocked = false;
    }

    /**
     * Getter for the status of the window. It can be locked or unlocked
     * @return if the window is locked or not
     */
    public boolean getStatus() {
        return isLocked;
    }

    /**
     * Getter for the blind of the window
     * @return the blind of the window
     */
    public Blind getBlind() {
        return blind;
    }

    @Override
    public String toString() {
        //return super.toString() + (isLocked ? "locked" : "unlocked") + ", " + blind.getPercent() + "%";
        return super.toString() + ";" + (isLocked ? "locked" : "unlocked") + ";" + blind.getPercent();
    }

}
