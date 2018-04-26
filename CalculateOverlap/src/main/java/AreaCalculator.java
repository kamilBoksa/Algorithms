import static java.lang.Math.abs;

public class AreaCalculator {


    public int calculateRectangleArea(int topRightX, int topRightY, int bottomLeftX, int bottomLeftY) {
       if(isCalculatedAreaIntegerValue(topRightX, topRightY, bottomLeftX, bottomLeftY)){
           return abs(topRightX - bottomLeftX) * abs(topRightY - bottomLeftY);
       } else {
           return 0;
       }
    }

    public int calculateOverlap(int topRightX, int topRightY, int bottomLeftX, int bottomLeftY,
                                int topRightX2, int topRightY2, int bottomLeftX2, int bottomLeftY2) {
        int commonPartTopRightX;
        int commonPartTopRightY;
        int commonPartBottomLeftX;
        int commonPartBottomLeftY;

        if(!checkIfRectanglesHaveCommonPart(topRightX,  topRightY,  bottomLeftX,  bottomLeftY,
         topRightX2,  topRightY2,  bottomLeftX2,  bottomLeftY2)) {
            return 0;
        }
        commonPartBottomLeftX = Math.max(bottomLeftX, bottomLeftX2);
        commonPartBottomLeftY = Math.max(bottomLeftY, bottomLeftY2);
        commonPartTopRightX = Math.min(topRightX, topRightX2);
        commonPartTopRightY = Math.min(topRightY, topRightY2);
        return calculateRectangleArea(commonPartBottomLeftX, commonPartBottomLeftY, commonPartTopRightX, commonPartTopRightY);
    }

    private boolean checkIfRectanglesHaveCommonPart(int topRightX, int topRightY, int bottomLeftX, int bottomLeftY,
                                                int topRightX2, int topRightY2, int bottomLeftX2, int bottomLeftY2) {
        if(topRightX < bottomLeftX2 || bottomLeftX > topRightX2 || bottomLeftY >= topRightY2 || topRightY <= bottomLeftY2) {
            return false;
        }
        return true;
    }

    private boolean isCalculatedAreaIntegerValue(int topRightX, int topRightY, int bottomLeftX, int bottomLeftY) {
        long ax = (long) topRightX;
        long ay = (long) topRightY;
        long bx = (long) bottomLeftX;
        long by = (long) bottomLeftY;
        long area = abs(ax - bx) * abs(ay - by);

        if(area > Integer.MAX_VALUE || area < Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
