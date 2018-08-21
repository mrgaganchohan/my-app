package com.mycompany.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class App{
    public static void main(String args[]){
        System.out.println("hello");
        try{
//step1 load the driver class

            Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
            Connection con= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/centos?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true","gagan","dent");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("show tables");
            /**  Format of Table is given
            CREATE TABLE Employees (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,

); */

            rs = stmt.executeQuery("select  firstname,lastname from Employees");

            System.out.print("It works");
            while(rs.next())
                System.out.println(rs.getString("firstname")+"  "+rs.getString("lastname"));

//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);
        e.printStackTrace();
        }

    }
}
