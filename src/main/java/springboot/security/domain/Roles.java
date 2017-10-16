package springboot.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "user_id")
    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL)
    Set<User> users;


    public Roles(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}
