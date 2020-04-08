package eg.bazinga.scheduler.domin;

public class Person extends BaseEntity {

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private boolean active;

    private Unit unitType;

    private Unit subUnitType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Unit getUnitType() {
        return unitType;
    }

    public void setUnitType(Unit unitType) {
        this.unitType = unitType;
    }

    public Unit getSubUnitType() {
        return subUnitType;
    }

    public void setSubUnitType(Unit subUnitType) {
        this.subUnitType = subUnitType;
    }
}
