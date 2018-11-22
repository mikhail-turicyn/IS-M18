/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Денис
 */
public class ReadDataGames {
       private static final String url = "jdbc:mysql://localhost:3306/footbal_championat";
    private static final String user = "root";
    private static final String password = "cm6653623";
    
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private ArrayList<DataGames> listDP;
    
     public ArrayList<DataGames> ReadData(){
        String query = "select * from games";
        
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
               
            rs = stmt.executeQuery(query);
            
            listDP = new ArrayList<>();
           
            while (rs.next()) {
                DataGames ft=new DataGames();
                 ft.setId(rs.getString(1));
                 ft.setGame(rs.getString(2));
                 ft.setScore(rs.getString(3));
                 ft.setTournament(rs.getString(4));
                 ft.setLocation(rs.getString(5));
                 ft.setTour(rs.getString(6));
                 ft.setDate(rs.getString(7));
                 listDP.add(ft);
                
              // System.out.println("Name : " +ft.putName());
           }
            
           
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
            return listDP;
        }
    }
}
