import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataFormatter {

    static final String COMMA_SEPARATOR = ",";

    static final List<Integer> strListToIntList(List<String> input) {
        return input.stream().map(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));
    }

    static final List<Integer> commatizedStringToIntList(String input) {
        return Arrays.stream(input.split(COMMA_SEPARATOR)).map(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));
    }

    static final HashMap<Integer, Integer> intListToPositionMap(List<Integer> input) {
        Integer position = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer value : input) {
            map.put(position, value);
            position++;
        }
        return map;
    }

}
