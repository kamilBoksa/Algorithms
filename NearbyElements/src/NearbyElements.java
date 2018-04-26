import java.util.ArrayList;
import java.util.List;

public class NearbyElements {
    private int leftCounter;
    private int rightCounter;
    private int counter;

    private int[][] multi = new int[][]{
            {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
    };

    public int[] nearby(int x, int y, int range) {
        List<Integer> nearbyElements = new ArrayList<>();
        leftCounter = 0;
        rightCounter = range;
        counter = 0;

        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                getNearbyElements(x, y, range, nearbyElements, i, j);
            }
        }
        return convertListToArray(nearbyElements);
    }

    private void getNearbyElements(int x, int y, int range, List<Integer> nearbyElements, int i, int j) {
        if (i == x && j == y) {
            if (y == 0) {
                handleElementOnFirstIndex(range, nearbyElements, x, j);
            } else if (y == multi[x].length - 1) {
                handleElementOnLastIndex(range, nearbyElements, x, j);
            } else {
                handleElementOnRandomPosition(range, nearbyElements, x, j);
            }
        }
    }

    private void handleElementOnRandomPosition(int range, List<Integer>nearbyElements, int x, int j) {
        while (leftCounter < range && range + leftCounter >= 0) {
            nearbyElements.add(multi[x][j - range + leftCounter]);
            leftCounter++;
            counter++;
        }
        counter = 0;
        while (counter < range) {
            nearbyElements.add(multi[x][j + range - rightCounter + 1]);
            rightCounter--;
            counter++;
        }
    }

    private void handleElementOnLastIndex(int range, List<Integer>nearbyElements, int x, int j) {
        if (range > multi[x].length) {
            range = multi[x].length - 1;
        }
        while (leftCounter < range) {
            nearbyElements.add(multi[x][j - range + leftCounter]);
            leftCounter++;
        }
    }

    private void handleElementOnFirstIndex(int range, List<Integer>nearbyElements, int x, int j) {
        while (counter < range) {
            nearbyElements.add(multi[x][j + range - rightCounter + 1]);
            rightCounter--;
            counter++;
        }
    }

    private int[] convertListToArray(List<Integer> nearbyElements) {
        int[] array = new int[nearbyElements.size()];
        for(int i = 0; i < nearbyElements.size(); i++) {
            array[i] = nearbyElements.get(i);
        }
        return array;
    }
}
