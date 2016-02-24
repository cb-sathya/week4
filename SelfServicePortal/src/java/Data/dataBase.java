package Data;

import servlets.User;
import java.sql.*;

/**
 *
 * @author cb-sathyanarayanan
 */
public class dataBase {  
    static final String DB_URL = "jdbc:mysql://localhost/SelfServicePortal";
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
        String queryString= "select firstName,lastName,password,emailId,addressLine1,addressLine2,city,state,ZIP,country from SelfServicePortal.User where emailId = ? and password= ?";
        try{ 		
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,email);
            queryStatement.setString(2,password);
            rs=queryStatement.executeQuery();
            if(rs.next()){
                user=new User(rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailId"),rs.getString("addressLine1"),rs.getString("addressLine2"),rs.getString("City"),rs.getString("State"),rs.getString("ZIP"),rs.getString("Country"));
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
        String queryString= "select firstName,lastName,password,emailId,addressLine1,addressLine2,city,state,ZIP,country from SelfServicePortal.User where emailId = ?";
        try{ 		
            con=EstablishConnection();
            con.setAutoCommit(false);
            queryStatement = con.prepareStatement(queryString);
            queryStatement.setString(1,email);
            rs=queryStatement.executeQuery();
            if(rs.next()){
                user=new User(rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailId"),rs.getString("addressLine1"),rs.getString("addressLine2"),rs.getString("City"),rs.getString("State"),rs.getString("ZIP"),rs.getString("Country"));
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
    public static void updateUser(String firstName,String lastName,String email,String addressLine1,String addressLine2,String city,String state,String ZIP,String country)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
        con=EstablishConnection();
        con.setAutoCommit(false);
        queryStatement=con.prepareStatement("update SelfServicePortal.User set firstName=? , lastName=? , addressLine1=? , addressLine2=? , city=? , state=? , ZIP=? , country=? where emailId=? ");
        queryStatement.setString(1,firstName);
        queryStatement.setString(2,lastName);
        queryStatement.setString(3,addressLine1);
        queryStatement.setString(4,addressLine2);
        queryStatement.setString(5,city);
        queryStatement.setString(6,state);
        queryStatement.setString(7,ZIP);
        queryStatement.setString(8,country);
        queryStatement.setString(9,email);
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
    public static void deleteUser(String email)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="delete from SelfServicePortal.user where emailId= ?";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,email);
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
    public static void createUser(String firstName,String lastName,String emailId,String password)throws SQLException,ClassNotFoundException{
        PreparedStatement queryStatement=null;
        Connection con=null;
        try{
            con=EstablishConnection();
            con.setAutoCommit(false);
            String query="insert into SelfServicePortal.user (firstName,lastName,password,emailId) values(?,?,?,?)";
            queryStatement=con.prepareStatement(query);
            queryStatement.setString(1,firstName);
            queryStatement.setString(2,lastName);
            queryStatement.setString(3,password);
            queryStatement.setString(4,emailId);
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
}

