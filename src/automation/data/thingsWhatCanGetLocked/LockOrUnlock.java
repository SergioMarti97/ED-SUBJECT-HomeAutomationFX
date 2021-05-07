package automation.data.thingsWhatCanGetLocked;

/**
 * This interface generalizes the two methods for the elements
 * what can be locked or unlocked, as windows, doors or garage doors
 */
public interface LockOrUnlock {

    /**
     * This method locks the element
     */
    void lock();

    /**
     * This methods unlocks the element
     */
    void unlock();

}
