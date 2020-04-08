package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.ContactType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Contact extends Person {

    private String title;

    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;

    private SystemUser systemUser;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
