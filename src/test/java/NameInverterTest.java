import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NameInverterTest {

    private NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    void shouldThrowExceptionWhenNullProvided() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            nameInverter.invert(null);
        });
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyStringGiven() {
        String inverted = nameInverter.invert("");
        org.assertj.core.api.Assertions.assertThat(inverted).isEqualTo("");
    }
}