/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.Statistics;
/**
 *
 * @author airassof
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    

    @Test
    public void searchingReturnsRigthPlayer() {
        
        Player player = stats.search("Semenko");
        
        assertEquals("Semenko              EDM  4 + 12 = 16", player.toString());
    }
    
   
    @Test
    public void topScorersReturnsRightPlayers() {
        
        ArrayList<Player> top3Players = new ArrayList<>();
            
            top3Players.add(new Player("Gretzky", "EDM", 35, 89));
            top3Players.add(new Player("Lemieux", "PIT", 45, 54));
            top3Players.add(new Player("Yzerman", "DET", 42, 56));
            
        
            assertEquals(top3Players.toString(), stats.topScorers(2).toString());
    }
    
    @Test
    public void teamReturnsRightPlayers() {
        
        ArrayList<Player> edmPlayers = new ArrayList<>();
            edmPlayers.add(new Player("Semenko", "EDM", 4, 12));
            edmPlayers.add(new Player("Kurri", "EDM", 37, 53));
            edmPlayers.add(new Player("Gretzky", "EDM", 35, 89));            
        
            assertEquals(edmPlayers.toString(), stats.team("EDM").toString());
    }
    
    @Test
    public void searchingReturnsNullIfPlayerNotExist() {
        assertEquals(null, stats.search("Selanne"));
    }
}
