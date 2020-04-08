package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@Getter
@Setter
public class Person extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "IS_ACTIVE")
    private boolean active;

    @OneToOne
    @JoinColumn(name = "UNIT_ID")
    private UnitType unitType;

    @OneToOne
    @JoinColumn(name = "SUB_UNIT_ID")
    private SubUnitType subUnitType;

}
