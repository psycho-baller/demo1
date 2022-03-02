// Names: Maximilian Kaczmarek, Rami Maalouf
// UCID: 30151219, 30151862
// Date: March 01, 2022
// Tutorials: 01, 02
// Instructor: Johnathan Hudson
package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo1 {

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    //just a hashmap where the key is a string and the value is another hashmap
    //first hashmap = players(name, player (hashmap(string,string))
    static HashMap<String, HashMap<String, String>> players = new HashMap<String, HashMap<String, String>>();

    public static void addPlayer(String name, String fam_name, String pos, String team) {
        HashMap<String, String> player = new HashMap<String, String>();
        player.put("Name", capitalize(name));
        player.put("fam name", capitalize(fam_name));
        player.put("position", pos.toUpperCase());
        player.put("team", capitalize(team));
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

        //adding it to the overall hashmap which is called player, we are going to access using name
        players.put(fam_name, player);
    }

    //TODO: Add rest of functions
    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.print("""
                    Welcome to Basketball player statistics, What would you like to do:
                    1: Add data
                    2: View stored data
                    3: view calculated data
                    4: exit\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                    """);

            //getting input from the terminal
            Scanner input = new Scanner(System.in);

            //converting input to integer
            int response1 = parseInt(input.nextLine());
            if (response1 == 1) {
                System.out.print(
                        """
                                What data would you like to add:
                                1: add new player
                                2: add player data
                                3: back to menu
                                """);

                int response2 = parseInt(input.nextLine());
                if (response2 == 1) {
                    System.out.println("What is the player's first name?");
                    String name = capitalize(input.nextLine());
                    System.out.println("What is the player's last name?");
                    String fam_name = capitalize(input.nextLine());
                    System.out.println("What is the player's position?");
                    String pos = input.nextLine().toUpperCase();
                    System.out.println("What team does the player play at?");
                    String team = capitalize(input.nextLine());

                    addPlayer(name, fam_name, pos, team);
                }
                //adding to the arrayList
                //how are we planning on adding to the arraylist
                if (response2 == 2) {
                    System.out.println("Which player do you want to add to (family name)?");
                    String fam_name = capitalize(input.nextLine());

                    boolean found = false;
                    for (Map.Entry<String, HashMap<String, String>> entry : players.entrySet()) {
                        if (fam_name.equals(entry.getKey())) {
                            found = true;
                            break;
                        }
                    }
                    if (found){//TODO: get error if int is negative
                        System.out.println("How many free throws were missed?");
                        int missed_ft = parseInt(input.nextLine());
                        System.out.println("How many free throws were made?");
                        int made_ft = parseInt(input.nextLine());
                        System.out.println("How many missed 2 pointers?");
                        int missed_2pt = parseInt(input.nextLine());
                        System.out.println("How many made 2 pointers?");
                        int made_2pt = parseInt(input.nextLine());
                        System.out.println("How many missed 3 pointers?");
                        int missed_3pt = parseInt(input.nextLine());
                        System.out.println("How many made 3 pointers?");
                        int made_3pt = parseInt(input.nextLine());
                        System.out.println("How many assists?");
                        int assists = parseInt(input.nextLine());
                        System.out.println("How many rebounds?");
                        int rebounds = parseInt(input.nextLine());
                        System.out.println("How many steals?");
                        int steals = parseInt(input.nextLine());
                        System.out.println("How many blocks?");
                        int blocks = parseInt(input.nextLine());


                        //players are overall hashmap(list of players) the .get is accessing whatever name is in the player list, the .put is putting in the whole database
                        players.get(fam_name).put("missed ft", String.valueOf(missed_ft + parseInt(players.get(fam_name).get("missed ft"))));
                        players.get(fam_name).put("made ft", String.valueOf(made_ft + parseInt(players.get(fam_name).get("made ft"))));
                        players.get(fam_name).put("missed 2pt", String.valueOf(missed_2pt + parseInt(players.get(fam_name).get("missed 2pt"))));
                        players.get(fam_name).put("made 2pt", String.valueOf(made_2pt + parseInt(players.get(fam_name).get("made 2pt"))));
                        players.get(fam_name).put("missed 3pt", String.valueOf(missed_3pt + parseInt(players.get(fam_name).get("missed 3pt"))));
                        players.get(fam_name).put("made 3pt", String.valueOf(made_3pt + parseInt(players.get(fam_name).get("made 3pt"))));
                        players.get(fam_name).put("assists", String.valueOf(assists + parseInt(players.get(fam_name).get("assists"))));
                        players.get(fam_name).put("rebounds", String.valueOf(rebounds + parseInt(players.get(fam_name).get("rebounds"))));
                        players.get(fam_name).put("steals", String.valueOf(steals + parseInt(players.get(fam_name).get("steals"))));
                        players.get(fam_name).put("blocks", String.valueOf(blocks + parseInt(players.get(fam_name).get("blocks"))));
                    }else {
                        System.err.println("Could not find player");
                    }
                }
                if (response2 == 3){
                    continue;
                }
            }
            if (response1 == 2) {
                System.out.println(players);
            }
            if (response1 == 3) {
                //TODO: add calculated data option menu
            }
            //if user types in exit, while loop should close
            //for exit
            if (response1 == 4) {
                loop = false;
            }
        }
    }
}
