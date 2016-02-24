/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author cb-sathyanarayanan
 */
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String ZIP;
    private String country;
    public Address(String addressLine1,String addressLine2,String city,String state,String ZIP,String country){
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.city=city;
        this.state=state;
        this.ZIP=ZIP;
        this.country=country;
    }
    public String getAddressLine1(){
        return addressLine1;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZIP(){
        return ZIP;
    }
    public String getCountry(){
        return country;
    }
    public void setAddressLine1(String addressLine1){
        this.addressLine1=addressLine1;
    }public void setAddressLine2(String addressLine2){
        this.addressLine2=addressLine2;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setZIP(String ZIP){
        this.ZIP=ZIP;
    }
    public void setCountry(String country){
        this.country=country;
    }
    @Override
    public String toString(){
        return getAddressLine1()+","+getAddressLine2()+","+getCity()+","+getState()+","+getZIP()+","+getCountry();
    }
}
