import java.util.ArrayList;
import java.util.List;

public class ArrayFlatterer {

    private List<Object> flatList;

    ArrayFlatterer() {
        this.flatList = new ArrayList<>();
    }

    public Object[] getFlattenList(Object[] inputArray) {
        if(inputArray == null) { return null; }
        for(Object element : inputArray) {
            if(element instanceof Object[]) {
                getFlattenList((Object[]) element);
            } else {
                flatList.add(element);
            }
        }
        return flatList.toArray(new Object[flatList.size()]);
    }
}
