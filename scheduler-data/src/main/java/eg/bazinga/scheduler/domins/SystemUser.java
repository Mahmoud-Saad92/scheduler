package eg.bazinga.scheduler.domins;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SE_USERS")
@Getter
@Setter
@NoArgsConstructor
public class SystemUser extends Person implements Serializable {

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD")
    private Character[] password;

    @Column(name = "CURRENT_VIEW")
    private String currentView;

    @Column(name = "LAST_VIEW_OWNER_ID")
    private Long lastViewOwnerId;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @Builder
    public SystemUser(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                      String name, String emailAddress, String phoneNumber, Boolean active, UnitType unitType,
                      SubUnitType subUnitType, String username, Character[] password, String currentView,
                      Long lastViewOwnerId, Contact contact) {
        super(id, createdBy, createdDate, updatedBy, updatedDate, name, emailAddress, phoneNumber, active, unitType, subUnitType);
        this.username = username;
        this.password = password;
        this.currentView = currentView;
        this.lastViewOwnerId = lastViewOwnerId;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemUser that = (SystemUser) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
