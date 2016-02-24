
package servlets;

public class User {
    String firstName;
    String lastName;
    String email;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String ZIP;
    String country;

    public User(String firstName,String lastName,String email,String addressLine1,String addressLine2,String city,String state,String ZIP,String country){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.city=city;
        this.state=state;
        this.ZIP=ZIP;
        this.country=country;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAddressLine1(){
        return this.addressLine1;
    }
    public String getAddressLine2(){
        return this.addressLine2;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getZIP(){
        return this.ZIP;
    }
    public String getCountry(){
        return this.country;
    }
    public String getAddress(){
        String address="";
        if(getAddressLine1()!=null){
            address+=" "+addressLine1;
        }
        if(getAddressLine2()!=null){
            address+=" "+addressLine2;
        }
        if(getCity()!=null){
            address+=" "+city;
        }
        if(getZIP()!=null){
            address+=" "+ZIP;
        }
        if(getState()!=null){
            address+=" "+state;
        }
        if(getCountry()!=null){
            address+=" "+country;
        }
        return address;
    }
    
    public void setUser(String firstName,String lastName,String addressLine1,String addressLine2,String city,String state,String ZIP,String country){
        this.firstName=firstName;
        this.lastName=lastName;
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.city=city;
        this.state=state;
        this.ZIP=ZIP;
        this.country=country;
    } 
}
