import java.util.List;

public class DayTwo {

    private final static TxtFileReader READER = new TxtFileReader("input.txt");

    public static void main(String[] args) {
        List<Integer> program = DataFormatter.commatizedStringToIntList(READER.getLines().get(0));
        System.out.print(Processor.processProgram(program));
    }

}
