import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    final static Integer STEP_SIZE = 4;
    final static Integer ARG1_INDEX = 1;
    final static Integer ARG2_INDEX = 2;
    final static Integer TARGET_INDEX = 3;

    public static HashMap<Integer, Integer> processProgram(HashMap<Integer, Integer> programMap) {
        HashMap<Integer, Integer> localProgramMap = new HashMap<>() {{
            this.putAll(programMap);
        }};
        Boolean terminate = false;
        Integer programCounter = 0;
        while(!terminate) {
            switch (OpCode.forValue(localProgramMap.get(programCounter))) {
                case ADD:
                    Addition addition = new Addition(
                            localProgramMap.get(localProgramMap.get(programCounter + ARG1_INDEX)),
                            localProgramMap.get(localProgramMap.get(programCounter + ARG2_INDEX)),
                            localProgramMap.get(programCounter + TARGET_INDEX)
                    );
                    updateProgramMap(localProgramMap, addition);
                    programCounter+=STEP_SIZE;
                    break;
                case MUL:
                    Multiplication multiplication = new Multiplication(
                            localProgramMap.get(localProgramMap.get(programCounter + ARG1_INDEX)),
                            localProgramMap.get(localProgramMap.get(programCounter + ARG2_INDEX)),
                            localProgramMap.get(programCounter + TARGET_INDEX)
                    );
                    updateProgramMap(localProgramMap, multiplication);
                    programCounter+=STEP_SIZE;
                    break;
                case END:
                    terminate = true;
                    break;
            }
        }
        return localProgramMap;
    }

    public static void updateProgramMap(HashMap<Integer, Integer> programMap, Operation operation) {
        programMap.replace(operation.getTarget(), operation.getResult());
    }

}
