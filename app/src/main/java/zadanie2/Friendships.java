package zadanie2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();
    private final Pattern invalidNamePattern = Pattern.compile(".*[^aA-zZ\\s].*");

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        if (invalidNamePattern.matcher(person1).matches() || invalidNamePattern.matcher(person2).matches()) {
            throw new IllegalArgumentException("Name contains illegal characters");
        }
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }

    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        List<String> person1Friendlist = friendships.get(person1);
        List<String> person2FriendList = friendships.get(person2);

        return person1Friendlist.contains(person2) && person2FriendList.contains(person1);
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        friendships.computeIfAbsent(person, s -> new ArrayList<>()).add(friend);
    }
}
