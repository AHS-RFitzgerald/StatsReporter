
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.*;

public class StatsReporterRunner {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Object for StatsReporter Class
        StatsReporter obj = new StatsReporter();
        
        //Variables needed for program
        String answer = "";
        String name = "";
        int baskets = 0;
        int foulShots = 0;
        int totalPoints = 0;
        //ArrayList needed to store players and stats
        ArrayList<StatsReporter> team = new ArrayList<>();

        //Reads existing file to get stats and names of players
        File file = new File("Z:\\Programming IV\\Notepad++\\points.txt");

        //Scanner to read file and the way to be able to input data by asking the user
        Scanner src = new Scanner(file);
        Scanner keyboard = new Scanner(System.in);

        //While loop to read the file and add the players into the ArrayList
        while (src.hasNextLine()) {
            name = src.nextLine();
            baskets = Integer.parseInt(src.nextLine());
            foulShots = Integer.parseInt(src.nextLine());
            totalPoints = Integer.parseInt(src.nextLine());
            team.add(new StatsReporter(name, baskets, foulShots, totalPoints));
        }
        
        //Asks the user how they want the list to be sorted
        System.out.println("How would you like to have the team's data sorted?");
        System.out.println("Alphabetical, Baskets, Foul Shots, Total Points.");
        
        switch(keyboard.next()){
            case "alphabetical":
                team = obj.sortAlphabetically(team);
                break;
            case "baskets":
                team = obj.sortByBaskets(team);
                break;
            case "foul shots":
                team = obj.sortByFoulShots(team);
                break;
            case "total points":
                team = obj.sortByTotalPoints(team);
        }
       
        //Asks the user if they want to change somebodies stats
        System.out.println("Would you like to change somebodies' stats? Y/N");
        answer = keyboard.next();

        //If the user entered yes, they go through the while loop and decide who they would like to change the stats for
        while (answer.equalsIgnoreCase("Y")) {
            System.out.println("Who would you like to change the stats for?");
            String response = keyboard.next();

            //for loop to see who was wanted to have their stats changed
            for (int x = 0; x < team.size(); x++) {
                if (team.get(x).getName().equalsIgnoreCase(response)) {
                    team.get(x).changeStats();
                }
            }

            //Asks the user if they want to be able to change another players stats
            System.out.println("Would you like to modify another person's stats? Y/N");
            answer = keyboard.next();
        }
        
        //New file to store the chart of the points for the players
        File chart = new File("Z:\\Programming IV\\Notepad++\\chart.txt");
        PrintWriter print = new PrintWriter(chart);
        print.println("Name\t1234567890123456789012345678901234567890123456789012345678901234567890");
        for (int x = 0; x < team.size(); x++) {
            print.println(team.get(x).getChart());
        }
        print.close();
        
        //Delete the file points to create a new one with the same name
        file.delete();
        
        //New file to insert the teams data into
        PrintWriter newPrint = new PrintWriter(new File("Z:\\Programming IV\\Notepad++\\points.txt"));
        for (int x = 0; x < team.size(); x++) {
            newPrint.write(team.get(x).getName());
            newPrint.write(team.get(x).getBaskets());
            newPrint.write(team.get(x).getFoulShots());
            newPrint.write(team.get(x).getTotalPoints());
        }
        print.close();
    }
}
