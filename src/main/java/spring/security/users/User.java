package spring.security.users;


import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.security.roles.Role;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Users_Roles",
    joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<Role> roles;

    @Id
    @GeneratedValue
    private int id;

    @Size(min=5, message = "Не меньше 5 знаков")
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min=5, message = "Не меньше 5 знаков")
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
