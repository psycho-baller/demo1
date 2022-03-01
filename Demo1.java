package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo1 {

    static ArrayList<HashMap<String, String>> players = new ArrayList<HashMap<String, String>>();

    public static void addPlayer(String name, String pos, String team){
        HashMap<String, String> player = new HashMap<String, String>();
        player.put("Name", name);
        player.put("position", pos);
        player.put("team", team);
        player.put("missed ft", "0");
        player.put("made ft", "0");
        player.put("missed 2pt", "0");
        player.put("made 2pt", "0");
        player.put("missed 3pt", "0");
        player.put("made 3pt", "0");
        player.put("assists", "0");
        player.put("rebounds", "0");
        player.put("steals", "0");
        player.put("blocks", "0");

        players.add(player);
    }
    //TODO: Add rest of functons
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
Welcome to Basketball, What would you like to do:
1: Add data
2: View stored data
3: view calculated data
""");
        int response1 = parseInt(input.nextLine());
        if (response1 == 1){
            System.out.println(
    """
    What data would you like to add:
    1: add new player
    2: 
    """);//TODO: Finish menu 2
            int response2 = parseInt(input.nextLine());
            if(response2 == 1){
                System.out.println("What is the player's name?");
                String name = input.nextLine();
                System.out.println("What is the player's position?");
                String pos = input.nextLine();
                System.out.println("What team does the player play at?");
                String team = input.nextLine();

                addPlayer(name, pos, team);
            }
        }
        if(response1 == 2){
            System.out.println(players);
        }
        if(response1 == 3){
            //TODO: add calculated data option menu
        }
    }
}
