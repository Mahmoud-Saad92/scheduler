package eg.bazinga.scheduler.domin;

public class SystemUser extends Person {

    private String username;
    private char[] password;
    private String currentView;
    private Long lastViewOwnerId;

    private Contact contact;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getCurrentView() {
        return currentView;
    }

    public void setCurrentView(String currentView) {
        this.currentView = currentView;
    }

    public Long getLastViewOwnerId() {
        return lastViewOwnerId;
    }

    public void setLastViewOwnerId(Long lastViewOwnerId) {
        this.lastViewOwnerId = lastViewOwnerId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
