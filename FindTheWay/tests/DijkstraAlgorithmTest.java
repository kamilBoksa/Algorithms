import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DijkstraAlgorithmTest {

    private List<City> cities;
    private List<Path> paths;
    LinkedList<City> path;
    Graph graph;
    DijkstraAlgorithm dijkstra;

    @Before
    public void setUp() {
        cities = new ArrayList<>();
        paths = new ArrayList<>();
        addCities();
        addPaths();

        graph = new Graph(paths, cities);
        dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(cities.get(0));
        path = dijkstra.getPath(cities.get(4));
    }

    @Test
    public void testCountCheapestPath_FromWarsawToAthens() {
        int warsawIndex = 0;
        int londonIndex = 1;
        int athensIndex = 2;

        assertTrue("Warsaw".equals(path.get(warsawIndex).getName()));
        assertTrue("London".equals(path.get(londonIndex).getName()));
        assertTrue("Athens".equals(path.get(athensIndex).getName()));
    }

    @Test
    public void testCheapestPathPrice_FromWarsawToAthens() {
        int athensIndex = 4;
        assertEquals(950, dijkstra.getTotalPrice(cities.get(athensIndex)));
    }

    private void addCities() {
        String[] citiesNames = new String[]{"Warsaw", "Paris", "London", "Lisbon", "Athens"};
        for (int i = 0; i < 5; i++) {
            City location = new City("Id -" + i, citiesNames[i]);
            cities.add(location);
        }
    }

    private void addPaths() {
        addLane("Warsaw - Paris", 0, 1, 100);
        addLane("Warsaw - London", 0, 2, 450);
        addLane("Paris - Lisbon", 1, 3, 300);
        addLane("London - Athens", 2, 4, 500);
        addLane("Lisbon - London", 3, 2, 250);
        addLane("Lisbon - Athens", 3, 4, 800);
    }

    private void addLane(String laneId, int sourceIndex, int destIndex,
                         int duration) {
        Path lane = new Path(laneId,cities.get(sourceIndex), cities.get(destIndex), duration );
        paths.add(lane);
    }
}