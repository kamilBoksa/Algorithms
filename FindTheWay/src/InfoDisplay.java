import java.util.LinkedList;
import java.util.List;

public class InfoDisplay {

    public void displayCurrentTrackDetails(List<Path> paths, List<City> cities,
                                           City currentStart, City currentTarget) {
        Graph graph = new Graph(paths, cities);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(currentStart);
        LinkedList<City> path = dijkstra.getPath(currentTarget);
        int counter = 0;

        System.out.println("Track Details");
        for (City vertex : path) {
            counter++;
            System.out.println(counter + " - " + vertex);
        }
        System.out.println("Total price: " + dijkstra.getTotalPrice(currentTarget));
    }

    public void showAvailableLocations(List<City> cities) {
        for(City city : cities) {
            System.out.println("- " + city);
        }
    }

    public void displayMenu(City currentStart, City currentTarget) {
        System.out.println("---------------------" +
                "\nCurrent start: " +currentStart +
                "\nCurrent target: " + currentTarget +
                "\n---------------------" +
                "\nOPTIONS" +
                "\n1. Add new path." +
                "\n2. Change current start location." +
                "\n3. Change current end location." +
                "\n4. Display current track details." +
                "\n0. Exit app." +
                "\n---------------------");
    }
}
