package zadanie2.assertions.assertj;

import org.assertj.core.api.AbstractAssert;
import zadanie2.Person;

public class CanVoteInPolandAssert extends AbstractAssert<CanVoteInPolandAssert, Person> {

    public CanVoteInPolandAssert(Person person) {
        super(person, CanVoteInPolandAssert.class);
    }

    public static CanVoteInPolandAssert assertThat(Person person) {
        return new CanVoteInPolandAssert(person);
    }

    public CanVoteInPolandAssert canVote() {
        isNotNull();
        if (actual.getAge() < 18) {
            failWithMessage("Cannot vote in Poland because age is below 18");
        }
        return this;
    }

}
