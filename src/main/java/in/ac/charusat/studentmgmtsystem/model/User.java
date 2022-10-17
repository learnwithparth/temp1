package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;
    private String emailValidationToken;
    private boolean active;
    private String city;
    private int zipcode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String username, String password, String email, String emailValidationToken, boolean active, String city, int zipcode, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailValidationToken = emailValidationToken;
        this.active = active;
        this.city = city;
        this.zipcode = zipcode;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailValidationToken() {
        return emailValidationToken;
    }

    public void setEmailValidationToken(String emailValidationToken) {
        this.emailValidationToken = emailValidationToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }


}
