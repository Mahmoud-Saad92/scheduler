package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UNIT_ID")
    private UnitType unitType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUB_UNIT_ID")
    private SubUnitType subUnitType;

    public Person(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                  String name, String emailAddress, String phoneNumber, Boolean active, UnitType unitType,
                  SubUnitType subUnitType) {
        super(id, createdBy, createdDate, updatedBy, updatedDate);
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.unitType = unitType;
        this.subUnitType = subUnitType;
    }
}
