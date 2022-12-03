package zadanie2.assertions.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CanVoteInPolandTest {

    @Test
    void canVoteInPoland() {
        Integer age = 18;
        assertThat(age, CanVoteInPolandMatcher.canVoteInPoland());
    }

    @Test
    void cannotVoteInPoland() {
        Integer age = 17;
        assertThrows(AssertionError.class, () -> assertThat(age, CanVoteInPolandMatcher.canVoteInPoland()));
    }

    @Test
    void cannotVoteInPolandWhenAgeIsNull() {
        Integer age = null;
        assertThrows(AssertionError.class, () -> assertThat(age, CanVoteInPolandMatcher.canVoteInPoland()));
    }

}
