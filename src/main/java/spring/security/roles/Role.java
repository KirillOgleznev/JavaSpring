package spring.security.roles;

import org.springframework.security.core.GrantedAuthority;
import spring.security.users.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false)
    private String name;


    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
