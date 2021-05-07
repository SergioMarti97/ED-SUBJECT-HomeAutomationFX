package automation.data.thingsWhatCanRaiseOrLower;

import automation.data.AutomationElement;

/**
 * This class represents a blind
 * extends from the AutomationElement and implements
 * the interface raise or lower the element
 */
public class Blind extends AutomationElement implements RaiseOrLower {

    /**
     * The percentage the blind is raised
     */
    private int percent;

    /**
     * Constructor
     * @param name the name of the blind
     * @param percent the percent of the blind is raised
     */
    public Blind(String name, int percent) {
        super(name);
        this.percent = percent;
    }

    @Override
    public void raise() {
        percent = 100;
    }

    @Override
    public void lower() {
        percent = 0;
    }

    @Override
    public void raise(int percent) {
        this.percent = percent;
    }

    @Override
    public void lower(int percent) {
        this.percent = percent;
    }

    /**
     * The getter of the percent
     * @return the percent the window is raised
     */
    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        //return super.toString() + percent + "%";
        return super.toString() + ";" + percent;
    }

}
