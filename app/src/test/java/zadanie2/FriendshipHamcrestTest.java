package zadanie2;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class FriendshipHamcrestTest {

    @Test
    void shouldAddFriend() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");

        List<String> alicjasFriends = friendships.getFriendsList("alicja");
        List<String> bobsFriends = friendships.getFriendsList("bob");


        assertThat(alicjasFriends, hasSize(1));
        assertThat(alicjasFriends, contains("bob"));


        assertThat(bobsFriends, hasSize(1));
        assertThat(bobsFriends, contains("alicja"));
    }

    @Test
    void shouldCheckIfAreFriends() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");

        assertThat(friendships.areFriends("alicja", "bob"), Matchers.is(true));
    }

    @Test
    void shouldCheckIfAreNotFriends() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");
        friendships.makeFriends("celina", "bob");

        assertThat(friendships.areFriends("alicja", "celina"), Matchers.is(false));
    }
}
