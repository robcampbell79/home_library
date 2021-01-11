package org.campbell.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static Connection connection;
    public Connect() {}

    public static Connection connectDB() {
        try {
		//the driver to be loaded
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        // Class.forName("com.mysql.jdbc.Driver");
		System.out.println("working");
	
		//ta1.appendText("Driver Loaded\n");
				
		//connecting to the database
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homelibrary", "homelib", "abc123.?!@#DEF456ghi789");
        System.out.println("Also working");

        } catch(Exception ex) {
            System.out.println("Unable to connect, son.");
            ex.printStackTrace();
          }

          return connection;
    }
}