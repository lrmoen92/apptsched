package apptsched.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Logan.Moen on 7/24/2017.
 */

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AppointmentId")
    private Integer id;

    @Version
    private Integer version;

    private String type;
    private Date date;
    private String roomNumber;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Client client;



    public Appointment(){}

    public Appointment(String type, Date date, String roomNumber, Employee employee, Client client) {
        this.type = type;
        this.date = date;
        this.roomNumber = roomNumber;
        this.employee = employee;
        this.client = client;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
