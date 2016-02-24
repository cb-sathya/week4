/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author cb-sathyanarayanan
 */
public class FillDetails {
    public static ArrayList<Person> addContacts(ResultSet rs)throws SQLException{
        ArrayList<Person> persons=new ArrayList<>();
        while(rs.next()){
            LinkedList<Phone> phoneList=new LinkedList<>();
            if(!rs.getString("home").equals("")){
                phoneList.add(new Phone("Home",rs.getString("home")));
            }
            if(!rs.getString("work").equals("")){
                phoneList.add(new Phone("Work",rs.getString("work")));
            }
            if(!rs.getString("mobile").equals("")){
                phoneList.add(new Phone("Mobile",rs.getString("mobile")));
            }
            Address address=new Address(rs.getString("addressLine1"),rs.getString("addressLine2"),rs.getString("city"),rs.getString("state"),rs.getString("ZIP"),rs.getString("country"));
            Person person=new Person(rs.getString("firstName"),rs.getString("lastName"),rs.getString("ContactId"),address,phoneList);
            persons.add(person);
        }
        return persons;
    }
}
