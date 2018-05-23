import java.util.Arrays;

public class BinarySearch {

    public boolean search(int[] numbers, int x) {
        int leftBorder = 0;
        int rightBorder = numbers.length - 1;
        Arrays.sort(numbers);

        while(leftBorder <= rightBorder) {
            int mid = leftBorder + ((rightBorder - leftBorder) / 2);
            if(numbers[mid] == x) {
                return true;
            } else if(x < numbers[mid]) {
                rightBorder = mid - 1;
            } else {
                leftBorder = mid + 1;
            }
        }
        return false;
    }
}
