package eg.bazinga.scheduler.domins;

import eg.bazinga.scheduler.domins.enums.Type;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Unit extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_ACTIVE")
    private boolean active;

    @Enumerated(value = EnumType.STRING)
    private Type type;

}
