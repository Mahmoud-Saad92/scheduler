package eg.bazinga.scheduler.domins;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SE_USERS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "USER_NAME"),
                @UniqueConstraint(columnNames = "EMAIL_ADDRESS")
        })
@Getter
@Setter
@NoArgsConstructor
public class SystemUser extends Person implements Serializable {

    @NotBlank
    @Size(max = 20)
    @Column(name = "USER_NAME")
    private String username;

    @Size(max = 120)
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CURRENT_VIEW")
    private String currentView;

    @Column(name = "LAST_VIEW_OWNER_ID")
    private Long lastViewOwnerId;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    @Builder
    public SystemUser(Long id, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate,
                      String name, String emailAddress, String phoneNumber, Boolean active, UnitType unitType,
                      SubUnitType subUnitType, String username, String password, String currentView,
                      Long lastViewOwnerId, Contact contact, Set<Role> roles) {
        super(id, createdBy, createdDate, updatedBy, updatedDate, name, emailAddress, phoneNumber, active, unitType, subUnitType);
        this.username = username;
        this.password = password;
        this.currentView = currentView;
        this.lastViewOwnerId = lastViewOwnerId;
        this.contact = contact;
        this.roles = roles;
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
