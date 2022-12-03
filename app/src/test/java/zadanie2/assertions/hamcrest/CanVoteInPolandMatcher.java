package zadanie2.assertions.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CanVoteInPolandMatcher extends TypeSafeMatcher<Integer> {

    public static Matcher<Integer> canVoteInPoland() {
        return new CanVoteInPolandMatcher();
    }

    @Override
    protected boolean matchesSafely(Integer age) {
        if (age == null) {
            throw new NullPointerException();
        }

        return age >= 18;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("must be at least of age 18");
    }
}
