package org.campbell.search;

import java.util.ArrayList;
import java.sql.*;

import org.campbell.connect.Connect;

public class Search {

    public Search() {}

    public ArrayList allBooks() {

        ArrayList<String[]> results = new ArrayList<String[]>();

        try {

        Connect conn = new Connect();


        String query = "select title, author_lname, author_fname from books";

        Statement stmt = conn.connectDB().createStatement();

            ResultSet rs = stmt.executeQuery(query);

            int i = 0;
            int j = 1;

            while(rs.next()) {
                String[] info = new String[3];

                for(int x = 0; x < 3; x++) {
                    info[x] = rs.getString(x+1);
                }
                results.add(info);

                i++;
            }

        } catch(Exception ex) {
            System.out.println("Got a problem here, son.");
            ex.printStackTrace();
          }

          return results;

    }

    public ArrayList findBook(String[] args) {

        String query;
        ArrayList<String> results = new ArrayList<String>();

        try {

            Connect conn = new Connect();

            if(args.length == 2) {
                query = "select * from books where ? = ?";

                PreparedStatement prep = conn.connectDB().prepareStatement(query);

                prep.setString(1, args[0]);
                prep.setString(2, args[1]);

                ResultSet rs = prep.executeQuery(query);

                int i = 1;

                while(rs.next()) {
                    results.add(rs.getString(i));

                    i++;
                }

            } else {
                query = "select * from books where ? = ?";

                for(int i = 0; i < args.length; i++) {
                    query = query + " and ? = ? ";
                }

                PreparedStatement prep = conn.connectDB().prepareStatement(query);

                int j = 1;

                for (int i = 0; i < args.length; i ++) {
                    prep.setString(j, args[i]);

                    j++;
                }

                ResultSet rs = prep.executeQuery(query);

                int i = 1;

                while(rs.next()) {
                    results.add(rs.getString(i));

                    i++;
                }

            }

        } catch(Exception ex) {
            System.out.println("Got a problem here, son.");
            ex.printStackTrace();
          }

          return results;

    }
    
}