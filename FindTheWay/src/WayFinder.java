import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WayFinder {
    private Scanner reader;
    private City currentStart;
    private City currentTarget;
    private List<City> cities;
    private List<Path> paths;
    private InfoDisplay view;

     WayFinder() {
        cities = new ArrayList<>();
        paths = new ArrayList<>();
        view = new InfoDisplay();
    }

    public void start() {
        boolean isRuntime = true;
        reader = new Scanner(System.in);
        handleUserSession(isRuntime);
    }

    private void handleUserSession(boolean isRuntime) {
        while (isRuntime) {
            view.displayMenu(currentStart, currentTarget);
            String userChoice = reader.next();
            switch (userChoice) {
                case "0":
                    isRuntime = false;
                    break;
                case "1":
                    createNewPath();
                    break;
                case "2":
                    changeCurrentStartLocation();
                    break;
                case "3":
                    changeCurrentEndLocation();
                    break;
                case "4":
                    try {
                        view.displayCurrentTrackDetails(paths, cities, currentStart, currentTarget);

                    } catch (NullPointerException e) {
                        System.out.println("Cannot resolve given path");
                    }
                    break;
                default:
                    System.out.println("No such option exists!");
                    break;
            }
        }
     }

    private void createNewPath() {
        City pathStart = getCity("Enter path start: ");
        City pathEnd = getCity("Enter path end: ");
        int price = getPrice();
        String laneId = pathStart.getName() + " - " + pathEnd.getName();
        addNewPath(laneId,Integer.parseInt(pathStart.getId()), Integer.parseInt(pathEnd.getId()), price);
        System.out.println("Start id" + pathStart.getId() + " End id: " + pathEnd.getId());
    }

    private int getPrice() {
        boolean isInputCorrect = false;
        int price = 0;

        while(!isInputCorrect) {
            System.out.println("Enter path price.");
            try {
                price = Integer.parseInt(reader.next());
                isInputCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Price should be all numbers");
            }

        }
        return price;
    }

    private City getCity(String message) {
         City city;
         System.out.println(message);
         String cityName = reader.next();

        if(isNewCityGiven(cityName)) {
            city = new City(String.valueOf(cities.size()), cityName);
            cities.add(city);
        } else {
            city = getExistingCityByName(cityName);
        }
        return city;
    }

    private City getExistingCityByName(String cityName) {
        for (City city : cities) {
            if(city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }

    private boolean isNewCityGiven(String cityName) {
        for(City actual : cities) {
            if (actual.getName().equals(cityName)){
                return false;
            }
        }
        return true;
    }

    private void changeCurrentStartLocation() {
        view.showAvailableLocations(cities);
        String message = "Enter start locaction or '0' to back to menu.";
        handleSettingLocationProcess(message, "start");
    }

    private void changeCurrentEndLocation() {
        view.showAvailableLocations(cities);
        String message = "Enter end locaction or '0' to back to menu.";
        handleSettingLocationProcess(message, "target");
    }

    private void handleSettingLocationProcess(String message, String location) {
        boolean isProcessFinished = false;
        while(!isProcessFinished) {
            System.out.println(message);
            String userChoice = reader.next();
            for(City city : cities) {
                if(userChoice.equals(city.getName())){
                    if(location.equals("start")) {
                        currentStart = city;
                    } else if(location.equals("target")) {
                        currentTarget = city;
                    }
                    isProcessFinished = true;
                }
            }
            if(userChoice.equals("0")) {
                isProcessFinished = true;
            } else if(!isProcessFinished) {
                System.out.println("No city with that name found!");
            }
        }
    }

    private void addNewPath(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Path lane = new Path(laneId,cities.get(sourceLocNo), cities.get(destLocNo), duration );
        paths.add(lane);
    }
}
