package cloud;

public class VirtualDevice {
    private int key;
    private int unitNumber;
    private Description description;

    public VirtualDevice(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @return the unitNumber
     */
    public int getUnitNumber() {
        return unitNumber;
    }

    /**
     * @param unitNumber the unitNumber to set
     */
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * @return the description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Description description) {
        this.description = description;
    }
}