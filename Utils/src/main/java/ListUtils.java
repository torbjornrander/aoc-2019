import java.util.*;

public class ListUtils {

    public static <T> List<T> getCommonElements(final List<T> listA, final List<T> listB) {
        final Map<Integer, List<T>> hashA = new HashMap<>(listA.size());
        for (T item : listA) {
            List<T> subList = hashA.computeIfAbsent(item.hashCode(), k -> new ArrayList<>(4));
            subList.add(item);
        }
        final List<T> results = new ArrayList<>();
        for (T item : listB) {
            final List<T> list = hashA.get(item.hashCode());
            if (list != null && list.contains(item))
                results.add(item);
        }
        return results;
    }
}
