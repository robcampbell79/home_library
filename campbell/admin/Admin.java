package org.campbell.admin;

import java.util.ArrayList;
import java.sql.*;

import org.campbell.connect.Connect;

public class Admin {

    public Admin() {}

    public void addBooks(String[] args) {

        try {

        Connect conn = new Connect();

        String query = "insert into books (title, author_lname, author_fname, genre, subgenre, lcc, isbn10, isbn13, key_words, summary, room, location)"
        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prep = conn.connectDB().prepareStatement(query);

        prep.setString(1, args[0]);
        prep.setString(2, args[1]);
        prep.setString(3, args[2]);
        prep.setString(4, args[3]);
        prep.setString(5, args[4]);
        prep.setString(6, args[5]);
        prep.setString(7, args[6]);
        prep.setString(8, args[7]);
        prep.setString(9, args[8]);
        prep.setString(10, args[9]);
        prep.setString(11, args[10]);
        prep.setString(12, args[11]);

        prep.execute();

        } catch(Exception ex) {
            System.out.println("Got a problem here, son.");
            ex.printStackTrace();
          }

    }
    
}
