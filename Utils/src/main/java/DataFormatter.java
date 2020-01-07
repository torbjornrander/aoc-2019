import java.util.*;
import java.util.stream.Collectors;

public class DataFormatter {

    static final String COMMA_SEPARATOR = ",";

    static List<Integer> strListToIntList(List<String> input) {
        return input.stream().map(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));
    }

    static List<Integer> commatizedStringToIntList(String input) {
        return Arrays.stream(input.split(COMMA_SEPARATOR)).map(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));
    }

    static HashMap<Integer, Integer> intListToPositionMap(List<Integer> input) {
        Integer position = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer value : input) {
            map.put(position, value);
            position++;
        }
        return map;
    }

    static List<String> commatizedStringToStringList(String input) {
        return Arrays.stream(input.split(COMMA_SEPARATOR)).collect(Collectors.toCollection(LinkedList::new));
    }

}
