package zadanie2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FriendshipsTest {

    @Test
    void shouldAddFriend() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");

        List<String> alicjasFriends = friendships.getFriendsList("alicja");
        List<String> bobsFriends = friendships.getFriendsList("bob");

        assertThat(alicjasFriends)
                .hasSize(1)
                .contains("bob");

        assertThat(bobsFriends)
                .hasSize(1)
                .contains("alicja");
    }

    @Test
    void shouldCheckIfAreFriends() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");

        assertThat(friendships.areFriends("alicja", "bob")).isTrue();
    }

    @Test
    void shouldCheckIfAreNotFriends() {
        Friendships friendships = new Friendships();

        friendships.makeFriends("alicja", "bob");
        friendships.makeFriends("celina", "bob");

        assertThat(friendships.areFriends("alicja", "celina")).isFalse();
    }

    @Test
    void shouldNotAllowNameWithNumbers() {
        Friendships friendships = new Friendships();

        assertThatThrownBy(() -> friendships.makeFriends("alicja", "bob2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> friendships.makeFriends("alicja2", "bob")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldNotAllowNameWithSpecialCharactesr() {
        Friendships friendships = new Friendships();

        assertThatThrownBy(() -> friendships.makeFriends("alicja!", "bob")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> friendships.makeFriends("alicja", "bob!")).isInstanceOf(IllegalArgumentException.class);
    }
}
