package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo1 {

    //static ArrayList<HashMap<String, String>> players = new ArrayList<HashMap<String, String>>();

    //just a hashmap where the key is a string and the value is another hashmap
    //first hashmap = players(name, player (hashmap(string,string))
    static HashMap<String, HashMap<String, String>> players = new HashMap<String, HashMap<String, String>>();




    public static void addPlayer(String name, String famName, String pos, String team) {
        HashMap<String, String> player = new HashMap<String, String>();
        player.put("Name", name);
        player.put("fam name", famName);
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

        //adding it to the overall hashmap which is called player, we are going to access using name
        players.put(famName, player);
    }

    //TODO: Add rest of functions
    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.print("""
                    Welcome to Basketball, What would you like to do:
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
                    String name = input.nextLine();
                    System.out.println("What is the player's last name?");
                    String famName = input.nextLine();
                    System.out.println("What is the player's position?");
                    String pos = input.nextLine();
                    System.out.println("What team does the player play at?");
                    String team = input.nextLine();
//                    System.out.println("What are the players missed free throws?");
//                    String missed_ft = input.nextLine();
//                    System.out.println("What are the players made free throws?");
//                    String made_ft = input.nextLine();
//                    System.out.println("What are the players missed 2 pointers?");
//                    String missed_2pt = input.nextLine();
//                    System.out.println("What are the players made 2 pointers?");
//                    String made_2pt = input.nextLine();
//                    System.out.println("What are the players missed 3 pointers?");
//                    String missed_3pt = input.nextLine();
//                    System.out.println("What are the players made 3 pointers?");
//                    String made_3pt = input.nextLine();
//                    System.out.println("What are the players assists?");
//                    String assists = input.nextLine();
//                    System.out.println("What are the players rebounds?");
//                    String rebounds = input.nextLine();
//                    System.out.println("What are the players steals?");
//                    String steals = input.nextLine();
//                    System.out.println("What are the players blocks");
//                    String blocks = input.nextLine();

                    addPlayer(name, famName, pos, team);
                }

                //adding to the arrayList
                //how are we planning on adding to the arraylist
                if (response2 == 2) {
                    System.out.println("Which player do you want to add to?");
                    String name = input.nextLine();
                    System.out.println("How many free throws were missed?");
                    String missed_ft = input.nextLine();
                    System.out.println("How many free throws were made?");
                    String made_ft = input.nextLine();
                    System.out.println("How many missed 2 pointers?");
                    String missed_2pt = input.nextLine();
                    System.out.println("How many made 2 pointers?");
                    String made_2pt = input.nextLine();
                    System.out.println("How many missed 3 pointers?");
                    String missed_3pt = input.nextLine();
                    System.out.println("How many made 3 pointers?");
                    String made_3pt = input.nextLine();
                    System.out.println("How many assists?");
                    String assists = input.nextLine();
                    System.out.println("How many rebounds?");
                    String rebounds = input.nextLine();
                    System.out.println("How many steals?");
                    String steals = input.nextLine();
                    System.out.println("How many blocks?");
                    String blocks = input.nextLine();


                    //players are overall hashmap(list of players) the .get is accessing whatever name is in the player list, the .put is putting in the whole data base
                    players.get(name).put("missed ft", missed_ft);
                    players.get(name).put("made ft", made_ft);
                    players.get(name).put("missed 2pt", missed_2pt);
                    players.get(name).put("made 2pt", made_2pt);
                    players.get(name).put("missed 3pt", missed_3pt);
                    players.get(name).put("made 3pt", made_3pt);
                    players.get(name).put("assists", assists);
                    players.get(name).put("rebounds", rebounds);
                    players.get(name).put("steals", steals);
                    players.get(name).put("blocks", blocks);

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
