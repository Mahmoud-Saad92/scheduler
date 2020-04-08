package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Type;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Unit extends BaseEntity {

    private String name;
    private boolean active;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
