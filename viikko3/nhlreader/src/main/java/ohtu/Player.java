
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;
    private int total;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return this.nationality;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return this.team;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return this.goals;
    } 

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return this.assists;
    }
    
    public int getTotal() {
        return this.assists + this.goals;
    }
    
    
    @Override
    public String toString() {
        return name + " team " + team + " " + goals + " + " + assists + " = " + (goals + assists);
    }
      
}
