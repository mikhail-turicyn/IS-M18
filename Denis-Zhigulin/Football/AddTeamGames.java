/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Денис
 */
public class AddTeamGames {
    private static final String url = "jdbc:mysql://localhost:3306/footbal_championat";
    private static final String user = "root";
    private static final String password = "cm6653623";
    
    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
   
    
    public AddTeamGames(){
        
    }
    
    public void add(int id, String name, String tour, String idTeam){
        
    String query = "insert into team_matches (team_code, match_code, tour, team_name) values ("
                +quotate(idTeam)+","
                +id+","
                +quotate(tour)+","
                +quotate(name) +")";
    
    
 
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
               
            int done=stmt.executeUpdate(query);
            
         
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {  }
            
            
        }
        
    }
    
     public String quotate(String content){
    
        return "'"+content+"'";
    }
}
