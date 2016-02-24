/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author cb-sathyanarayanan
 */
public class Person {
    private String firstName;
    private String lastName;
    private String contactId;
    private Address address;
    private LinkedList<Phone> phoneList= new LinkedList<>();
    public Person(String firstName,String lastName,String contactId,Address address,LinkedList<Phone> phoneList){
        this.firstName=firstName;   
        this.lastName=lastName;
        this.address=address;
        this.phoneList=phoneList;  
        this.contactId=contactId;
    }
    public String getName(){
        return firstName+" "+lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getContactId(){
        return contactId;
    }
    public Address getAddress(){
        return address;
    }
    public LinkedList<Phone> getPhoneNumbers(){
        return phoneList;
    }
}
