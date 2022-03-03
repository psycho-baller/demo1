package project;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Demo1Test {

    @Test
    void capitalize() {
        String str = "canada";
        assertEquals("Canada", Demo1.capitalize(str));
    }

    @Test
    void add_player() {
        Demo1.add_player("Rami", "Maalouf", "SG", "Warriors");
        assertEquals("{Maalouf={games played=0, rebounds=0, made ft=0, missed 2pt=0, missed 3pt=0, blocks=0, team=Warriors, steals=0, Name=Rami, fam name=Maalouf, made 3pt=0, made 2pt=0, assists=0, missed ft=0, position=SG}}",Demo1.players.toString());
    }

    @Test
    void add_data() {
        Demo1.add_player("Rami", "Maalouf", "SG", "Warriors");

        Demo1.add_data("Maalouf", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        assertEquals("{Maalouf={games played=5, rebounds=5, made ft=5, missed 2pt=5, missed 3pt=5, blocks=5, team=Warriors, steals=5, Name=Rami, fam name=Maalouf, made 3pt=5, made 2pt=5, assists=5, missed ft=5, position=SG}}",Demo1.players.toString());
    }

    @Test
    void above_certain1() {
        Demo1.add_player("Rami", "Maalouf", "SG", "Warriors");
        Demo1.add_data("Maalouf", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        // checks if fam name will be added to top_players arrayList when cutoff is lower than player's data
        Demo1.above_certain(5,4,4);
        assertEquals("[Maalouf]",Demo1.top_players.toString());
    }

    @Test
    void above_certain2() {
        Demo1.add_player("Rami", "Maalouf", "SG", "Warriors");
        Demo1.add_data("Maalouf", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        // Checks if the cutoff is also included
        Demo1.above_certain(6,5,5);
        assertEquals("[Maalouf]",Demo1.top_players.toString());
    }

    @Test
    void above_certain3() {
        Demo1.add_player("Rami", "Maalouf", "SG", "Warriors");
        Demo1.add_data("Maalouf", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

         // checks if fam name will be added to top_players arrayList when cutoff is higher than player's data
        Demo1.above_certain(7,5,5);
        assertEquals("[]",Demo1.top_players.toString());
    }
}
