package com.github.wkennedy.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name = "person", schema = "", catalog = "")
public class PersonEntity {
    private Integer id;
    private String lastName;
    private String firstName;
    private AddressEntity addressByAddress;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 36)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 36)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", addressByAddress=" + addressByAddress +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    @RestResource(path = "personAddress", rel="addressByAddress")
    public AddressEntity getAddressByAddress() {
        return addressByAddress;
    }

    public void setAddressByAddress(AddressEntity addressByAddress) {
        this.addressByAddress = addressByAddress;
    }
}
