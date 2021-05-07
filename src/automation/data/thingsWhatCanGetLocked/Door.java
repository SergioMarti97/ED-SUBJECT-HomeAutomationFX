package automation.data.thingsWhatCanGetLocked;

import automation.data.AutomationElement;

/**
 * This class represents a door
 * extends from the AutomationElement and implements
 * the interface for lock or unlock the element
 */
public class Door extends AutomationElement implements LockOrUnlock {

    /**
     * a flag to store if the door is locked or not
     */
    private boolean isLocked;

    /**
     * Constructor
     * @param name the name of the door
     * @param isLocked if the door is locked or not
     */
    public Door(String name, boolean isLocked) {
        super(name);
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public void lock() {
        isLocked = true;
    }

    @Override
    public void unlock() {
        isLocked = false;
    }

    @Override
    public String toString() {
        //return super.toString() + (isLocked ? "locked" : "unlocked");
        return super.toString() + ";" + (isLocked ? "locked" : "unlocked");
    }

}
