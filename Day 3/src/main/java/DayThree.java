import java.util.List;

public class DayThree {

    public static void main(String[] args) {
        TxtFileReader inputReader = new TxtFileReader("input.txt");
        List<String> wireOneList = DataFormatter.commatizedStringToStringList(inputReader.getLines().get(0));
        List<String> wireTwoList = DataFormatter.commatizedStringToStringList(inputReader.getLines().get(1));

        System.out.println(Router.findClosestIntersectionDistance(wireOneList, wireTwoList));
    }

}
