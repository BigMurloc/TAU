package zadanie2.assertions.assertj;

import org.junit.jupiter.api.Test;
import zadanie2.Person;

import static org.junit.jupiter.api.Assertions.assertThrows;


class CanVoteInPolandAssertTest {

    @Test
    void canVoteInPoland() {
        Person person = new Person(18);
        CanVoteInPolandAssert.assertThat(person).canVote();
    }

    @Test
    void cannotVoteInPoland() {
        Person person = new Person(17);
        assertThrows(AssertionError.class, () -> CanVoteInPolandAssert.assertThat(person).canVote());
    }

    @Test
    void cannotVoteInPolandWhenAgeIsNull() {
        Person person = new Person(null);
        assertThrows(NullPointerException.class, () -> CanVoteInPolandAssert.assertThat(person).canVote());
    }


}
