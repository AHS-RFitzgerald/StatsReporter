
import java.util.Scanner;
import java.util.ArrayList;

public class StatsReporter {
    //Variables for the class

    private String name;
    private int baskets;
    private int foulShots;
    private int totalPoints;

    //Constructor to put values into the class integers
    public StatsReporter(String n, int bas, int foul, int total) {
        name = n;
        baskets = bas;
        foulShots = foul;
        totalPoints = total;
    }

    public StatsReporter() {

    }

    //Method to have the ArrayList sorted by the number of baskets each person on the team has
    public ArrayList<StatsReporter> sortByBaskets(ArrayList<StatsReporter> old) {
        ArrayList<StatsReporter> n = new ArrayList<>();

        for (int x = 0; x < old.size(); x++) {
            int trackHighestBaskets = 0;
            for (int y = 0; y < old.size(); y++) {

                if (old.get(x).getBaskets() > old.get(y).getBaskets() && x != y) {
                    trackHighestBaskets++;
                }
            }
            if (trackHighestBaskets == (old.size() - 1)) {
                n.add(old.get(x));
                old.remove(x);
                old.trimToSize();
                x = 0;
            }
        }
        return n;
    }

    //Method to have the ArrayList sorted by the number of foul shots each person on the team has
    public ArrayList<StatsReporter> sortByFoulShots(ArrayList<StatsReporter> old) {
        ArrayList<StatsReporter> n = new ArrayList<>();

        for (int x = 0; x < old.size(); x++) {
            int trackHighestFoulShots = 0;
            for (int y = 0; y < old.size(); y++) {

                if (old.get(x).getFoulShots() > old.get(y).getFoulShots() && x != y) {
                    trackHighestFoulShots++;
                }
            }
            if (trackHighestFoulShots == (old.size() - 1)) {
                n.add(old.get(x));
                old.remove(x);
                old.trimToSize();
                x = 0;
            }
        }
        return n;
    }

    //Method to have the ArrayList sorted by the number of total points each person on the team has
    public ArrayList<StatsReporter> sortByTotalPoints(ArrayList<StatsReporter> old) {
        ArrayList<StatsReporter> n = new ArrayList<>();

        for (int x = 0; x < old.size(); x++) {
            int trackHighestTotalPoints = 0;
            for (int y = 0; y < old.size(); y++) {
                if (old.get(x).getTotalPoints() > old.get(y).getTotalPoints() && x != y) {
                    trackHighestTotalPoints++;
                }
            }
            if (trackHighestTotalPoints == (old.size() - 1)) {
                n.add(old.get(x));
                old.remove(x);
                old.trimToSize();
                x = 0;
            }
        }
        return n;
    }

    //Method to have the ArrayList sorted Alphabetically
    public ArrayList<StatsReporter> sortAlphabetically(ArrayList<StatsReporter> old) {
        ArrayList<StatsReporter> n = new ArrayList<>();

        for (int x = 0; x < old.size(); x++) {
            int trackAlphabeticalName = 0;
            for (int y = 0; y < old.size(); y++) {

                if (old.get(x).name.compareTo(old.get(y).name) < 0 && x != y) {
                    trackAlphabeticalName++;
                }
            }
            if (trackAlphabeticalName == (old.size() - 1)) {
                n.add(old.get(x));
                old.remove(x);
                old.trimToSize();
                x = 0;
            }
        }
        n.add(old.get(0));
        return n;
    }

    //Method to change the stats of a player
    public void changeStats() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the players number of baskets?");
        baskets = keyboard.nextInt();

        System.out.println("What is the players number of foul shots?");
        foulShots = keyboard.nextInt();

        totalPoints = (baskets * 2) + foulShots;
    }

    //Method to get the line for the chart for a singular player	
    public String getChart() {
        String chart = "";
        chart += name;
        chart += "\t";
        for (int x = 0; x < totalPoints; x++) {
            chart += "*";
        }
        return chart;
    }

    //Method to return a name to the main method
    public String getName() {
        return name;
    }

    //Method to return the number of baskets each person has
    public int getBaskets() {
        return baskets;
    }
    //Method to return the number of foul shots each person has

    public int getFoulShots() {
        return foulShots;
    }

    //Method to return the number of total points each person has
    public int getTotalPoints() {
        return totalPoints;
    }
}
