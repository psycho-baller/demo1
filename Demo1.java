// Names: Maximilian Kaczmarek, Rami Maalouf
// UCID: 30151219, 30151862
// Date: March 01, 2022
// Tutorials: 01, 02
// Instructor: Johnathan Hudson

//this connects multiple files together
package project;

import java.util.*;

import static java.lang.Integer.parseInt;

public class DemoGitHub {

    // null just empty, ex.""
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
        //the 0 does not matter can be anything, getting changed anyway
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


        //adding it to the overall hashmap which is called player, we are going to access using fam_name
        players.put(fam_name, player);
    }

    public static void best_3pt(){
        int sum = 0;
        for (Map.Entry<String, HashMap<String, String>> id : players.entrySet()) {
            sum += (parseInt(id.getValue().get("missed 3pt") + parseInt(id.getValue().get("made 3pt"))));
        }

        //get the average number of 3pt attempts of all the players
        float avg_3pt_attempts = (float) sum/(players.size());

        float best_percentage = 0;
        String best_3pt_player = "";
        int best_attempts = 0;
        for (Map.Entry<String, HashMap<String, String>> id : players.entrySet()) {
            int player_attempts = parseInt(id.getValue().get("missed 3pt") + parseInt(id.getValue().get("made 3pt")));
            int tot_attempts = parseInt(id.getValue().get("missed 3pt") + parseInt(id.getValue().get("made 3pt")));
            float percentage = (float) (parseInt(players.get(id.getKey()).get("made 3pt"))/tot_attempts) * 100;
            if (player_attempts > avg_3pt_attempts && percentage > best_percentage){
                best_percentage = percentage;
                best_3pt_player = id.getKey();
                best_attempts = tot_attempts;
            }
        }
        System.out.println("The best 3pt shooter according to our algorithm is " + best_3pt_player + " with a " + best_percentage + "% made out of " + best_attempts + " attempts");
    }

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.print("""
                    Welcome to Basketball player statistics, What would you like to do:
                    1: Add data
                    2: View stored data
                    3: View calculated data
                    4: Exit\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                    """);

            //getting input from the terminal
            Scanner input = new Scanner(System.in);

            //converting input to integer
            int response1 = parseInt(input.nextLine());
            if (response1 == 1) {

                //printing the menu
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

                //adding to the arrayList by turning into integers and parsing them
                if (response2 == 2) {
                    System.out.println("Which player do you want to add to (family name)?");
                    String fam_name = capitalize(input.nextLine());


                    //goes through the hashmap, and if it finds the name it breaks
                    boolean found = false;
                    for (Map.Entry<String, HashMap<String, String>> id : players.entrySet()) {
                        if (fam_name.equals(id.getKey())) {
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

                        //parsing turns String into an integer
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
                    }

                    else {
                        System.err.println("Could not find player");
                    }
                }

                if (response2 == 3){
                    continue;
                }
            }

            else if (response1 == 2) {
                for (String key: players.keySet()){
                    System.out.println(key+ " = " + players.get(key));
                }

            }

            else if (response1 == 3) {
                //TODO: add calculated data option menu
                System.out.print(
                        """
                                What data would you like to add:
                                1: Generate best team
                                2: 25+pts, 5+ assists, 5+rebounds
                                3: Best defenders
                                4: back to menu
                                """);
                int response2 = parseInt(input.nextLine());

                //**Generate best team**(best offensive player and best defensive player is what defines what the best team is)
                if(response2 == 1) {

                    //players.keySet is making a key set of all the players we have, then putting that into a list called names
                    List<String> names = new ArrayList<String>(players.keySet());



                    //creating two array lists
                    List<String> best_team = new ArrayList<String>();
                    List<Integer> best_team_score = new ArrayList<Integer>();

                    //doing this 5 times to get the top 5 players
                    for (int j = 0; j < 5; j++) {

                        //set to zero because it gives first player
                        //setting initial value and checking if it's better than the previous one
                        int best_scores = 0;
                        String best_shooter = names.get(0);


                        // going through all the names that are in the hashmap
                        // this is getting the best player out of the remaining players
                        for (int i = 0; i < names.size(); i++) {

                            int current_ft = Integer.parseInt(players.get(names.get(i)).get("made ft"));
                            int current_2pt = Integer.parseInt(players.get(names.get(i)).get("made 2pt"));
                            int current_3pt = Integer.parseInt(players.get(names.get(i)).get("made 3pt"));
                            int current_score = current_ft + current_2pt + current_3pt;


                            //remembering the name of the person
                            String current_player = names.get(i);


                            //must check current_score first
                            if (current_score > best_scores) {
                                best_shooter = current_player;
                                best_scores = current_score;

                            }


                        }
                        best_team.add(best_shooter);
                        best_team_score.add(best_scores);


                        //only happens in the j loop,
                        //this doesn't touch the hashmap
                        //8 players removes 1 then 7 players removes one....etc
                        names.remove(best_shooter);


                    }
                    System.out.println("Best Team" + best_team);
                    System.out.println("Best Team Score" + best_team_score);
                }

                //**Best defenders**(largest number of steals and blocks(summed up)
                //sub menu is response 2 main menu is response is 1
                if(response2 == 3){



                    //players.keySet is making a key set of all the players we have, then putting that into a list called names
                    List<String> names = new ArrayList<String>(players.keySet());

                    //setting initial value and checking if it's better than the previous one
                    int best_defence = 0;
                    //set to zero because it gives first player
                    String best_defender = names.get(0);


                    //going through all the names that are down(in the hashmap)
                    for (int i = 0; i<names.size(); i ++){
                        //System.out.println(players.get(names.get(i)).get("steals"));
                        int current_steals = Integer.parseInt(players.get(names.get(i)).get("steals"));
                        int current_blocks = Integer.parseInt(players.get(names.get(i)).get("blocks"));


                        //remembering the name of the person
                        String current_player = names.get(i);

                        int current_defence = current_steals + current_blocks;
                        //must check current_defence first
                        if (current_defence > best_defence){
                            best_defender = current_player;
                            best_defence = current_defence;

                        }

                    }
                    System.out.println("Best defender: " + best_defender);
                    System.out.println("Defender score: " + best_defence);

                }


                //**For Junit testing**
                //no testing for inputs, just the functions

            }

            //if user types in exit, while loop should close
            //for exit
            else if (response1 == 4) {
                loop = false;
            }
        }
    }
}
