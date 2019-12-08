import java.util.HashMap;
import java.util.List;

public class DayTwo {

    private final static TxtFileReader READER = new TxtFileReader("input.txt");

    public static void main(String[] args) {
        // Part 1
        HashMap<Integer, Integer> programMap = DataFormatter.intListToPositionMap(DataFormatter.commatizedStringToIntList(READER.getLines().get(0)));
        System.out.print(Processor.processProgram(programMap));

        // Part 2
        for (Integer noun = 0; noun < 100; noun++) {
            programMap.replace(1, noun);
            for (Integer verb = 0; verb < 100; verb++) {
                programMap.replace(2, verb);
                if (Processor.processProgram(programMap).get(0) == 19690720)
                    System.out.println("noun: " + noun + " verb: " + verb + " result: " + (100 * noun + verb));
            }
        }
    }

}
