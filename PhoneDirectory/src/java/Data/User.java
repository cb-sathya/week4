/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author cb-sathyanarayanan
 */
public class User {
    String userName;
    private ArrayList<Person> contacts = new ArrayList<>();
    public User(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }
    public void setContacts(ArrayList<Person> contacts){
        this.contacts=contacts;
    }
    public ArrayList<Person> getContacts(){
        return contacts;
    }
}
