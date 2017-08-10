package apptsched.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Logan.Moen on 7/24/2017.
 */

@Entity
public class Employee extends Person{

    private Date hireDate;
    private String position;
    private boolean isEmployed;

    @ElementCollection
    private List<Date> pto;

    public Employee(){}

    public Employee(String firstName, String lastName, String middleName, String email, String phone, Date hireDate, String position){
        super.setFirstName(firstName);
        super.setMiddleName(middleName);
        super.setLastName(lastName);
        super.setEmailAddress(email);
        super.setPhoneNumber(phone);
        this.setHireDate(hireDate);
        this.setPosition(position);
        this.isEmployed = true;
    }


    public Employee(Date hireDate, String position) {
        this.hireDate = hireDate;
        this.position = position;
        this.isEmployed = true;
    }

    public Employee(Date hireDate, String position, List<Date> pto) {
        this.hireDate = hireDate;
        this.position = position;
        this.isEmployed = true;
        this.pto = pto;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    public List<Date> getPto() {
        return pto;
    }

    public void setPto(List<Date> pto) {
        this.pto = pto;
    }
}
