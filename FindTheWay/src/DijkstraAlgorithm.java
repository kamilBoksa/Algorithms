import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

    private final List<City> cities;
    private final List<Path> paths;
    private Set<City> settledCities;
    private Set<City> unSettledCities;
    private Map<City, City> predecessors;
    private Map<City, Integer> prices;

    DijkstraAlgorithm(Graph graph) {
        this.paths = new ArrayList<>(graph.getPaths());
        this.cities = new ArrayList<>(graph.getCities());
    }

    public void execute(City source) {
        settledCities = new HashSet<>();
        unSettledCities = new HashSet<>();
        prices = new HashMap<>();
        predecessors = new HashMap<>();
        prices.put(source, 0);
        unSettledCities.add(source);

        while (unSettledCities.size() > 0) {
            City node = getMinimum(unSettledCities);
            settledCities.add(node);
            unSettledCities.remove(node);
            findMinimalDistances(node);
        }
    }

    public int getTotalPrice(City target) {
        return prices.get(target);
    }

    private void findMinimalDistances(City node) {
        List<City> adjacentNodes = getNeighbors(node);
        for (City target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                prices.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledCities.add(target);
            }
        }
    }

    private int getDistance(City node, City target) {
        for (Path path : paths) {
            if (path.getSource().equals(node)
                    && path.getDestination().equals(target)) {
                return path.getPrice();
            }
        }
        throw new RuntimeException("Cannot get path price.");
    }

    private List<City> getNeighbors(City node) {
        List<City> neighbors = new ArrayList<>();
        for (Path path : paths) {
            if (path.getSource().equals(node)
                    && !isSettled(path.getDestination())) {
                neighbors.add(path.getDestination());
            }
        }
        return neighbors;
    }

    private City getMinimum(Set<City> cities) {
        City minimum = null;
        for (City city : cities) {
            if (minimum == null) {
                minimum = city;
            } else {
                if (getShortestDistance(city) < getShortestDistance(minimum)) {
                    minimum = city;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(City city) {
        return settledCities.contains(city);
    }

    private int getShortestDistance(City destination) {
        Integer d = prices.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public LinkedList<City> getPath(City target) {
        LinkedList<City> path = new LinkedList<>();
        City step = target;

        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}