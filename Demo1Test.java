package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Demo1Test {


    @Test
    void capitalize() {
    }

    @Test
    void add_player() {
    }

    @Test
    void add_data() {
    }

    @Test
    void above_certain() {
    }

    @Test
    void get_best_worst() {
    }



    @Test
    void best_team() {
        List<String> best_team = project.Demo1.best_team();
        List<String> best_team_test = new ArrayList<String>();

                //best_team_test is expected, best_team actual
                assertEquals(best_team_test, best_team);

    }


    @Test
    void best_defender() {
        List<String> best_defender = project.Demo1.best_defender();
        List<String> best_defender_test = new ArrayList<String>();

        //best_team_test is expected, best_team actual
        assertEquals(best_defender_test, best_defender);

    }
}
