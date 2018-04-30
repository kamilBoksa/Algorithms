import java.util.List;

public class Graph {
    private final List<Path> paths;
    private final List<City> cities;

    public Graph(List<Path> paths, List<City> cities) {
        this.paths = paths;
        this.cities = cities;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public List<City> getCities() {
        return cities;
    }
}