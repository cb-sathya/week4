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
public class Phone {
    private String number;
    private String type;
    Phone(String type,String number){
        this.number=number;
        this.type=type;
    }
    public String getNumber(){
        return number;
    }
    public String getType(){
        return type;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setType(String type){
        this.type=type;
    }
    @Override
    public String toString(){
        return getNumber()+"("+getType()+")";
    }
}
