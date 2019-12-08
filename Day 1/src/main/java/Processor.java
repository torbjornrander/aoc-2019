import java.util.List;
import java.util.function.IntFunction;

public class Processor {

    public static IntFunction<Integer> fuelElement = a -> Math.floorDiv(a, 3) - 2;

    public static Long processFuelList(List<Integer> fuelList) {
        return fuelList.stream().mapToLong(fuelElement::apply).sum();
    }

    public static Integer processFuelListWithFuelIncluded(List<Integer> fuelList) {
        return fuelList.stream().mapToInt(e -> fuelForFuel(e) - e).sum();
    }

    public static Integer fuelForFuel(Integer mass) {
        if (mass < 0)
            return 0;
        else {
            return  mass + fuelForFuel(fuelElement.apply(mass));
        }
    }

}
