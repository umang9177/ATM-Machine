package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

    Connection conn;
    Statement stmt;
    public Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","root");
            stmt = conn.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

