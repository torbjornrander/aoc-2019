import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class DayTwoTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testPrograms(int testNumber) {
        StringBuilder programName = new StringBuilder("program").append(testNumber).append(".txt");
        StringBuilder resultName = new StringBuilder("result").append(testNumber).append(".txt");
        // With
        TxtFileReader inputReader = new TxtFileReader(programName.toString());
        List<Integer> program = DataFormatter.commatizedStringToIntList(inputReader.getLines().get(0));

        // Expect
        TxtFileReader outputReader = new TxtFileReader(resultName.toString());
        String expectedOutput = outputReader.getLines().get(0);

        assertThat(Processor.processProgram(program), is(equalTo(expectedOutput)));
    }

}