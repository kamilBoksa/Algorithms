public class Path  {
    private final String id;
    private final City source;
    private final City destination;
    private final int price;

     Path(String id, City source, City destination, int price) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public City getDestination() {
        return destination;
    }

    public City getSource() {
        return source;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}