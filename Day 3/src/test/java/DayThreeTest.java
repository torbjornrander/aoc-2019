import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DayThreeTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testClosestDistances(int testNumber) {
        StringBuilder testName = new StringBuilder("wires").append(testNumber).append(".txt");
        StringBuilder resultName = new StringBuilder("result").append(testNumber).append(".txt");

        // With
        TxtFileReader inputReader = new TxtFileReader(testName.toString());
        List<String> wireOneList = DataFormatter.commatizedStringToStringList(inputReader.getLines().get(0));
        List<String> wireTwoList = DataFormatter.commatizedStringToStringList(inputReader.getLines().get(1));

        // Expect
        TxtFileReader outputReader = new TxtFileReader(resultName.toString());
        Integer expectedOutput = DataFormatter.commatizedStringToIntList(outputReader.getLines().get(0)).get(0);

        assertThat(Router.findClosestIntersectionDistance(wireOneList, wireTwoList), is(equalTo(expectedOutput)));

    }
}
