package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Country")
    private String country;
    @Column(name = "UserAddress")
    private String userAddress;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "COUNTRY: " + this.country + " USER ADDRESS: " + this.userAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getId() == address.getId() &&
                getCountry().equals(address.getCountry()) &&
                getUserAddress().equals(address.getUserAddress()) &&
                getUser().equals(address.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getUserAddress(), getUser());
    }
}
