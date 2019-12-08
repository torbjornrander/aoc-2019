import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class DayOneTest {

    private static final Integer MODULE_MASS = 100756;
    private static final Integer EXPECTED_MASS = 50346;

    @Test
    public void testFuelForFuel() {
        assertThat(Processor.fuelForFuel(MODULE_MASS) - MODULE_MASS, is(equalTo(EXPECTED_MASS)));
    }

    @Test
    public void processFuelListWithFuelIncluded() {
        // With
        List<Integer> moduleMass = singletonList(MODULE_MASS);

        assertThat(Processor.processFuelListWithFuelIncluded(moduleMass), is(equalTo(EXPECTED_MASS)));
    }
}