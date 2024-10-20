package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//  it is example of singleton
public class ConnectionFactory {

    public static ConnectionFactory obj = null;
    private ConnectionFactory(){

    }
    public Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ParkingLot", "root", "root");
        } catch (SQLException e){
            e.printStackTrace();
        }

        return con;
    }
    public static ConnectionFactory getInstance(){
        if(obj==null){
            obj = new ConnectionFactory();
        }
        return obj;
    }
}
