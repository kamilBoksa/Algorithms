public class Main {

    public static void main(String[] args) {
        NearbyElements nearbyElements = new NearbyElements();
        for(int i : nearbyElements.nearby(0,2,2)){
            System.out.println(i);
        }
    }
}
