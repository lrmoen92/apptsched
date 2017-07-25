package apptsched.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Logan.Moen on 7/24/2017.
 */

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends Person{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ClientId")
//    private Integer id;

    private Date customerSince;

    public Client(){}

    public Client(String firstName, String lastName, String middleName, String email, String phone, Date customerSince){
        super.setFirstName(firstName);
        super.setMiddleName(middleName);
        super.setLastName(lastName);
        super.setEmailAddress(email);
        super.setPhoneNumber(phone);
        this.setCustomerSince(customerSince);
    }

    public Client(Date customerSince) {
        this.customerSince = customerSince;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Date getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Date customerSince) {
        this.customerSince = customerSince;
    }

}
