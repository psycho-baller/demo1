/**
 * @Names: Maximilian Kaczmarek, Rami Maalouf
 * @UCID: 30151219, 30151862
 * @Tutorials: 01, 02
 * @Date: March 01, 2022
 * @Instructor: Johnathan Hudson
 */
package project;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Demo1 {

    /**
     * @param str
     * it will take the str from the parameter and
     * @return the parameter 'str' with it's first being capitalized
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    //just a hashmap where the key is a string (fam name) and the value is another hashmap
    //first hashmap = players(name, player (hashmap(string,string))
    static HashMap<String, HashMap<String, String>> players = new HashMap<>();

    public static void add_player(String name, String fam_name, String pos, String team) {
        HashMap<String, String> player = new HashMap<>();
        player.put("Name", capitalize(name));
        player.put("fam name", capitalize(fam_name));
        player.put("position", pos.toUpperCase());
        player.put("team", capitalize(team));
        //we initialize the rest of the key-value pairs to 0
        player.put("games played", "0");
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

        //adding it to the overall hashmap which is called player, we are going to access each player using the key "fam name"
        players.put(fam_name, player);
    }

    public static void add_data(String fam_name, int games_played, int missed_ft, int made_ft, int missed_2pt, int made_2pt, int missed_3pt, int made_3pt, int assists, int rebounds, int steals, int blocks){

        //parsing turns String into an integer
        //players are overall hashmap(list of players) the .get is accessing whatever name is in the player list, the .put is putting in the whole database
        players.get(fam_name).put("games played", String.valueOf(games_played + parseInt(players.get(fam_name).get("games played"))));
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

    public static void get_data() throws InterruptedException {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Which player do you want to add to (family name)?");
        String fam_name = capitalize(input2.nextLine());

        //goes through the hashmap, and if it finds the name it breaks
        boolean found = false;
        for (Map.Entry<String, HashMap<String, String>> id : players.entrySet()) {
            if (fam_name.equals(id.getKey())) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("How many games has the player played?");
            int games_played = parseInt(input2.nextLine());
            if (games_played < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many free throws were missed?");
            int missed_ft = parseInt(input2.nextLine());
            if (missed_ft < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many free throws were made?");
            int made_ft = parseInt(input2.nextLine());
            if (made_ft < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many missed 2 pointers?");
            int missed_2pt = parseInt(input2.nextLine());
            if (missed_2pt < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many made 2 pointers?");
            int made_2pt = parseInt(input2.nextLine());
            if (made_2pt < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many missed 3 pointers?");
            int missed_3pt = parseInt(input2.nextLine());
            if (missed_3pt < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many made 3 pointers?");
            int made_3pt = parseInt(input2.nextLine());
            if (made_3pt < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many assists?");
            int assists = parseInt(input2.nextLine());
            if (assists < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many rebounds?");
            int rebounds = parseInt(input2.nextLine());
            if (rebounds < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many steals?");
            int steals = parseInt(input2.nextLine());
            if (steals < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            System.out.println("How many blocks?");
            int blocks = parseInt(input2.nextLine());
            if (blocks < 0) {
                input2.close();
                System.err.println("Only positive integers are accepted");
                Thread.sleep(1500);
                return;
            }
            add_data(fam_name, games_played, missed_ft, made_ft, missed_2pt, made_2pt, missed_3pt, made_3pt, assists, rebounds, steals, blocks);
        } else {
            System.err.println("Could not find player");
        }
    }
    static ArrayList<String> top_players;
    /**
     *
     * @param points_cutoff
     * @param assists_cutoff
     * @param rebounds_cutoff
     */
    public static void above_certain(int points_cutoff, int assists_cutoff, int rebounds_cutoff) {
        float points;
        int assists;
        int rebounds;
        top_players = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, String>> id : players.entrySet()) {
            points = (float) (parseInt(players.get(id.getKey()).get("made ft")) + (2 * (parseInt(players.get(id.getKey()).get("made 2pt"))) + (3 * (parseInt(players.get(id.getKey()).get("made 3pt"))))))/(parseInt(players.get(id.getKey()).get("games played")));
            System.out.println(points);
            assists = parseInt(players.get(id.getKey()).get("assists"));
            rebounds = parseInt(players.get(id.getKey()).get("rebounds"));
            if ((int) points >= points_cutoff && assists >= assists_cutoff && rebounds >= rebounds_cutoff) {
                top_players.add(id.getKey());
            }
        }
        //prints the names
        System.out.println("List of players with " + points_cutoff + "+ points, " + assists_cutoff + "+ assists, and " + rebounds_cutoff + "+ rebounds on average per game:");

        //----------------------------------------------------------first name----------------------------last name
        top_players.forEach((top_player) -> System.out.println(players.get(top_player).get("name") + " " + top_player));
    }

    /**
     * Generate best team (top 5 players). Best players are defined by who has the most made ft, made 2pt, made 3pt
     *
     */
    public static void best_team(){
        //players.keySet is making a key set of all the players we have, then putting that into a list called names
        List<String> names = new ArrayList<>(players.keySet());

        //creating two array lists
        List<String> best_team = new ArrayList<>();
        List<Integer> best_team_score = new ArrayList<>();

        //try and catch statement so that when there is less than 5 players still works
        try {

            //doing this 5 times to get the top 5 players
            for (int j = 0; j < 5; j++) {

                //set to zero because it gives first player
                int best_scores = 0;

                //setting initial value and checking if it's better than the previous one
                String best_shooter = names.get(0);

                //going through all the names that are in the hashmap
                //this is getting the best player out of the remaining players
                for (String name : names) {

                    int current_ft = Integer.parseInt(players.get(name).get("made ft"));
                    int current_2pt = Integer.parseInt(players.get(name).get("made 2pt"));
                    int current_3pt = Integer.parseInt(players.get(name).get("made 3pt"));
                    int current_score = current_ft + current_2pt + current_3pt;

                    //must check current_score first
                    if (current_score > best_scores) {
                        best_shooter = name;
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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("You should have at least 5 players added to generate the best team");
        }
        System.out.println("Best Team" + best_team);
        System.out.println("Best Team Score" + best_team_score);
    }

    /**
     * we find the best defenders by getting the largest number of steals and blocks(summed up)
     *
     */
    public static void best_defender(){
        List<String> names = new ArrayList<>(players.keySet());
        //set to zero because it gives first player
        int best_defence = 0;

        //setting initial value and checking if it's better than the previous one
        String best_defender = names.get(0);


        //going through all the names that are in the hashmap
        for (String name : names) {

            //System.out.println(players.get(names.get(i)).get("steals"));
            int current_steals = Integer.parseInt(players.get(name).get("steals"));
            int current_blocks = Integer.parseInt(players.get(name).get("blocks"));

            int current_defence = current_steals + current_blocks;

            //must check current_defence first
            if (current_defence > best_defence) {
                best_defender = name;
                best_defence = current_defence;
            }
        }
        System.out.println("Best defender: " + best_defender);
        System.out.println("Defender score: " + best_defence);
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        while (loop) {
            System.out.println("""
                    ______________________________________________________________________
                        Welcome to Basketball player statistics, What would you like to do:
                        1: Add data
                        2: View stored data
                        3: View calculated data
                        4: Exit
                    ______________________________________________________________________
                    """);

            //getting input from the terminal
            Scanner input = new Scanner(System.in);

            //converting input to integer
            int response1 = 0;
            if (input.hasNextLine()){
                response1 = parseInt(input.nextLine());
            }else{
                loop = false;
            }
            if (response1 == 1) {

                //menu
                System.out.print(
                        """
                                _____________________________________________
                                    What data would you like to add:
                                    1: add new player
                                    2: add player data
                                    Press Enter if you want to go back to menu
                                _____________________________________________
                                """);
                //sub menu is response2, main menu is response1
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

                    add_player(name, fam_name, pos, team);
                }
                //adding to the arrayList
                //how are we planning on adding to the arraylist ----> turn all into integers and parse them
                if (response2 == 2) {
                    get_data();
                }
            } else if (response1 == 2) {
                for (String key : players.keySet()) {
                    System.out.println(key + " = " + players.get(key));
                    Thread.sleep(2000);
                }
                //System.out.println(players);
            } else if (response1 == 3) {
                System.out.print(
                        """
                                _______________________________________________________________________________________
                                    What data would you like to add:
                                    1: Generate best team
                                    2: Best defenders
                                    3: Generate list of players averaging 25+ points, 5+ assists, 5+ rebounds per game
                                    4: Generate list of players averaging above certain points, assists, rebounds
                                    Press Enter if you want to go back to menu
                                _______________________________________________________________________________________
                                """);
                int response2 = parseInt(input.nextLine());
                if (response2 == 1) {
                    best_team();
                } else if (response2 == 2) {
                    best_defender();
                } else if (response2 == 3) {
                    above_certain(25, 5, 5);
                } else if (response2 == 4) {
                    System.out.println("What is the cutoff points per game do you want?");
                    int points_cutoff = parseInt(input.nextLine());
                    System.out.println("What is the cutoff assists per game do you want?");
                    int assist_cutoff = parseInt(input.nextLine());
                    System.out.println("What is the cutoff rebounds per game do you want?");
                    int rebounds_cutoff = parseInt(input.nextLine());

                    above_certain(points_cutoff, assist_cutoff, rebounds_cutoff);
                }
            }
            //if user types in exit, while loop should close
            //for exit
            else if (response1 == 4) {
                loop = false;
            }
        }
    }
}
