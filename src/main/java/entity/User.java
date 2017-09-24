package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "DELIVERY_ADDRESS", nullable = false)
    private String deliveryAddress;
    @Column(name = "CONTACT_PHONE", nullable = false, unique = true)
    private String contactPhone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", unique = true)
    private Address userAddress;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_HOBBY",
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"),
            joinColumns = @JoinColumn(name = "USER_ID")
    )
    private List<Hobby> hobbies;

    public User() {
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public User setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
