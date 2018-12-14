/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;



/**
 *
 * @author Денис
 */
public class DataGames {
    private String id;
   private String game;
     private String score;
     private String tournament;
     private String location;
     private String tour;
     private String date;

    public String getDate() {
        return date;
    }

    public String getGame() {
        return game;
    }

    public String getLocation() {
        return location;
    }

    public String getScore() {
        return score;
    }

    public String getTour() {
        return tour;
    }

    public String getTournament() {
        return tournament;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
