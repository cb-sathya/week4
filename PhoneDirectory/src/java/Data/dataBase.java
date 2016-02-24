package Data;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author cb-sathyanarayanan
 */
public class dataBase {  
    static final String DB_URL = "jdbc:mysql://localhost/PhoneDirectory";
    static final String USER = "root";
    static final String PASS = "";
    public static Connection EstablishConnection()throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(DB_URL,USER,PASS);
        return con;
    }
    public static User checkUser(String email,String password)throws ClassNotFoundException,SQLException{
        User user=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        Connection con=null;
        String queryString= "select email from PhoneDirectory.user where email = ? and password= ?";
        try{ 		
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,email);
            queryStatement.setString(2,password);
            rs=queryStatement.executeQuery();
            if(rs.next()){
                user=new User(rs.getString("email"));
            }
            con.commit();
        }
        finally{
            if(rs!=null){
                rs.close();
            }if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return user;
    }
    public static User checkIfUserExists(String email)throws ClassNotFoundException,SQLException{
        User user=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        Connection con=null;
        String queryString= "select * from PhoneDirectory.user where email = ?";
        try{ 		
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,email);
            rs=queryStatement.executeQuery();
            if(rs.next()){
                user=new User(rs.getString("email"));
            }
            con.commit();
        }
        finally{
            if(rs!=null){
                rs.close();
            }if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return user;
    }
    public static boolean createUser(String email,String password)throws SQLException,ClassNotFoundException{
        boolean flag=false;
        PreparedStatement queryStatement=null;
        Connection con=null;
        String queryString= "insert into PhoneDirectory.user values(?,?);";
        try{ 		
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,email);
            queryStatement.setString(2,password);
            queryStatement.executeUpdate();
            con.commit();
        }
        finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return flag;
    }   
    public static ArrayList<Person> setContact()throws SQLException,ClassNotFoundException{
        Connection con=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        String queryString= "select * from contact";
        ArrayList<Person> persons=new ArrayList<>();
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            rs=queryStatement.executeQuery();
            persons=FillDetails.addContacts(rs);
            con.commit();
        }
        finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return persons;
    }
    public static Person getContact(String contactId)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        ResultSet rs=null;
        Person person=null;
        Address address;
        LinkedList<Phone> phoneList=new LinkedList<Phone>();
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="select * from PhoneDirectory.contact where contactId= ?";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,contactId);
            rs=queryStatement.executeQuery();
            while(rs.next()){
                address=new Address(rs.getString("addressLine1"),rs.getString("addressLine2"),rs.getString("city"),rs.getString("state"),rs.getString("ZIP"),rs.getString("country"));
                phoneList.add(new Phone("Home",rs.getString("home")));
                phoneList.add(new Phone("Work",rs.getString("work")));
                phoneList.add(new Phone("Mobile",rs.getString("mobile")));
                person=new Person(rs.getString("firstName"),rs.getString("lastName"),rs.getString("contactID"),address,phoneList);
            }
            con.commit();
        }finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        } 
        return person;
    }
    public static void updateContact (String firstName,String lastName,String contactId,String addressLine1,String addressLine2,String city,String state,String ZIP,String country,String home,String work,String mobile)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="insert into PhoneDirectory.contact values(?,?,?,?,?,?,?,?,?,?,?,?)";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,firstName);
            queryStatement.setString(2,lastName);
            queryStatement.setString(3,contactId);
            queryStatement.setString(4,addressLine1);
            queryStatement.setString(5,addressLine1);
            queryStatement.setString(6,city);
            queryStatement.setString(7,state);
            queryStatement.setString(8,ZIP);
            queryStatement.setString(9,country);
            queryStatement.setString(10,home);
            queryStatement.setString(11,work);
            queryStatement.setString(12,mobile);
            queryStatement.executeUpdate();
            con.commit();
        }finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
    public static void updateOldContact (String firstName,String lastName,String contactId,String addressLine1,String addressLine2,String city,String state,String ZIP,String country,String home,String work,String mobile)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="update PhoneDirectory.contact set firstName=?, lastName=?, addressLine1=?, addressLine2=?, city=?, state=?, ZIP=?, country=?, home=?, work=?, mobile=? where contactId=? ";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,firstName);
            queryStatement.setString(2,lastName);
            queryStatement.setString(3,addressLine1);
            queryStatement.setString(4,addressLine2);
            queryStatement.setString(5,city);
            queryStatement.setString(6,state);
            queryStatement.setString(7,ZIP);
            queryStatement.setString(8,country);
            queryStatement.setString(9,home);
            queryStatement.setString(10,work);
            queryStatement.setString(11,mobile);            
            queryStatement.setString(12,contactId);

            queryStatement.executeUpdate();
            con.commit();
        }finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
    public static void deleteUser(String userName)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="delete from PhoneDirectory.user where email= ?";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,userName);
            queryStatement.executeUpdate();
            con.commit();
        }finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
    public static ArrayList<Person> setContactNameMatch(String name)throws SQLException,ClassNotFoundException{
        Connection con=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        String queryString= "select * from contact where firstName=? or lastName=?";
        ArrayList<Person> persons=new ArrayList<>();
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,name);
            queryStatement.setString(2,name);
            rs=queryStatement.executeQuery();
            persons=FillDetails.addContacts(rs);
            con.commit();
        }
        finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return persons;
    }
    public static ArrayList<Person> setContactPartialMatch(String name)throws SQLException,ClassNotFoundException{
        Connection con=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        String queryString= "select * from contact where firstName like ? or lastName like ? ";
        ArrayList<Person> persons=new ArrayList<>();
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            name=name+"%";
            queryStatement.setString(1,name);
            queryStatement.setString(2,name);
            rs=queryStatement.executeQuery();
            persons=FillDetails.addContacts(rs);
            con.commit();
        }
        finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return persons;
    }
    public static ArrayList<Person> setContactNumberMatch(String number)throws SQLException,ClassNotFoundException{
        Connection con=null;
        PreparedStatement queryStatement=null;
        ResultSet rs= null;
        String queryString= "select * from contact where home=? or  work=? or mobile=? ";
        ArrayList<Person> persons=new ArrayList<>();
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,number);
            queryStatement.setString(2,number);
            queryStatement.setString(3,number);
            rs=queryStatement.executeQuery();
            persons=FillDetails.addContacts(rs);
            con.commit();
        }
        finally{
            if(queryStatement!=null){
                queryStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return persons;
    }
}

