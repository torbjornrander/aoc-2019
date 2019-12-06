import java.util.List;
import java.util.function.IntFunction;

public class Processor {

    public static Long processFuelList(List<Integer> fuelList) {
        IntFunction<Integer> fuelElement = a -> Math.floorDiv(a, 3) - 2;
        return fuelList.stream().mapToLong(fuelElement::apply).sum();
    }

}
