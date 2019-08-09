package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SubEmployee")

public class SubEmployee extends Employee
{

    private long id;
    private String firstName;


    public SubEmployee()
    {

    }

    public SubEmployee(String firstName, String lastName, String emailId)
    {
        this.firstName = firstName;

    }

    @Id
    @Column(name = "id",nullable = false)
    public long getId()
    {
        return id;
    }
    public void setId(String lastName)
    {

        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String toString()
    {
        return "SubEmployee [id=" + id + ", firstName=" + firstName + "]";
    }

}
