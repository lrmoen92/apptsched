package apptsched.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Logan.Moen on 7/24/2017.
 */

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @ManyToMany
    private List<Appointment> appointmentHistory;

    public Person(){}

    public Person(String firstName, String middleName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(List<Appointment> appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }
}
