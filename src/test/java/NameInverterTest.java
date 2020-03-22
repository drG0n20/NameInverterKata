import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameInverterTest {

    public static final String EMPTY_STRING = "";
    private NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    void shouldThrowExceptionWhenNullProvided() {
        Assertions.assertThrows(NullPointerException.class, () ->
                nameInverter.invert(null));
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyStringGiven() {
        String inverted = nameInverter.invert("");
        assertThat(inverted).isEqualTo(EMPTY_STRING);
    }

    @Test
    void shouldReturnEmptyStringWhenSpacesGiven() {
        String inverted = nameInverter.invert("   ");
        assertThat(inverted).isEqualTo(EMPTY_STRING);
    }

    @Test
    void shouldReturnInvertedFirstAndLastName() {
        String inverted = nameInverter.invert("Jan Kowalski");
        assertThat(inverted).isEqualTo("Kowalski, Jan");
    }

    @Test
    void shouldReturnInvertedFirstAndLastNameWithoutMaleHonorific() {
        String inverted = nameInverter.invert("Pan Jan Kowalski");
        assertThat(inverted).isEqualTo("Kowalski, Jan");
    }

    @Test
    void shouldReturnInvertedFirstAndLastNameWithoutFemaleHonorific() {
        String inverted = nameInverter.invert("Pani Janina Kowalska");
        assertThat(inverted).isEqualTo("Kowalska, Janina");
    }

    @Test
    void shouldReturnInvertedFirstAndLastNameWithTitleWithoutFemaleHonorific() {
        String inverted = nameInverter.invert("Pani Dr Janina Kowalska");
        assertThat(inverted).isEqualTo("Kowalska, Janina, Dr");
    }
}