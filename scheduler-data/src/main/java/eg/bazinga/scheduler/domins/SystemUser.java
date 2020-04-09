package eg.bazinga.scheduler.domins;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SE_USERS")
@Getter
@Setter
public class SystemUser extends Person implements Serializable {

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD")
    private char[] password;

    @Column(name = "CURRENT_VIEW")
    private String currentView;

    @Column(name = "LAST_VIEW_OWNER_ID")
    private Long lastViewOwnerId;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

}
