import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    final static Integer STEP_SIZE = 4;
    final static Integer ARG1_INDEX = 1;
    final static Integer ARG2_INDEX = 2;
    final static Integer TARGET_INDEX = 3;

    public static String processProgram(List<Integer> input) {
        HashMap<Integer, Integer> programMap = DataFormatter.intListToPositionMap(input);
        Boolean terminate = false;
        Integer programCounter = 0;
        while(!terminate) {
            switch (OpCode.forValue(programMap.get(programCounter))) {
                case ADD:
                    Addition addition = new Addition(
                            programMap.get(programMap.get(programCounter + ARG1_INDEX)),
                            programMap.get(programMap.get(programCounter + ARG2_INDEX)),
                            programMap.get(programCounter + TARGET_INDEX)
                    );
                    updateProgramMap(programMap, addition);
                    programCounter+=STEP_SIZE;
                    break;
                case MUL:
                    Multiplication multiplication = new Multiplication(
                            programMap.get(programMap.get(programCounter + ARG1_INDEX)),
                            programMap.get(programMap.get(programCounter + ARG2_INDEX)),
                            programMap.get(programCounter + TARGET_INDEX)
                    );
                    updateProgramMap(programMap, multiplication);
                    programCounter+=STEP_SIZE;
                    break;
                case END:
                    terminate = true;
                    break;
            }
        }
        return programMap.values().stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public static void updateProgramMap(HashMap<Integer, Integer> programMap, Operation operation) {
        programMap.replace(operation.getTarget(), operation.getResult());
    }

}
