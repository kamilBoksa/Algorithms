import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FriendsOfFriendsFinderTest {
    private List<User> allUsers;

    @Before
    public void setUp() {
        this.allUsers = new ArrayList<>();
    }

    @Test
    public void test_distanceBetweenFriendsShouldReturnOne() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Marin");
        allUsers.add(first);
        allUsers.add(second);

        first.addFriendId(2);
        first.setUserFriends(allUsers);
        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first, second);
        Integer expected = 1;

        finder.calculate();
        Integer actual = finder.getDistance();
        assertEquals(expected, actual);
    }

    @Test
    public void test_distanceShouldReturnTwo() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Marin");
        User third = new User(3, "Thomas", "Rosicky");
        allUsers.add(first);
        allUsers.add(second);
        allUsers.add(third);

        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first, third);
        first.addFriendId(2);
        second.addFriendId(3);
        first.setUserFriends(allUsers);
        second.setUserFriends(allUsers);

        Integer expected = 2;

        finder.calculate();
        Integer actual = finder.getDistance();
        assertEquals(expected, actual);
    }

    @Test
    public void test_distanceShouldReturnThree() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Marin");
        User third = new User(3, "Thomas", "Rosicky");
        User fourth = new User(4, "Marco", "Reus");

        allUsers.add(first);
        allUsers.add(second);
        allUsers.add(third);
        allUsers.add(fourth);

        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first,  fourth);
        first.addFriendId(2);
        first.setUserFriends(allUsers);
        second.addFriendId(3);
        second.setUserFriends(allUsers);
        third.addFriendId(4);
        third.setUserFriends(allUsers);

        Integer expected = 3;

        finder.calculate();
        Integer actual = finder.getDistance();
        assertEquals(expected, actual);
    }

    @Test
    public void test_distanceShouldReturnOneWhenMoreThanOneFriend() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Reus");
        User third = new User(3, "Thomas", "Rosicky");

        allUsers.add(first);
        allUsers.add(second);
        allUsers.add(third);

        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first, third);
        first.addFriendId(2);
        first.addFriendId(3);
        first.setUserFriends(allUsers);
        finder.calculate();

        Integer actual = finder.getDistance();
        Integer expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void test_fiendsOfFriendsShouldContainNoUsers() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Marin");
        allUsers.add(first);
        allUsers.add(second);

        first.addFriendId(2);
        first.setUserFriends(allUsers);
        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first, second);
        User expected = second;

        finder.calculate();
        Set<User> actual = finder.getFriendsOfFriends();
        assertEquals(expected, actual.toArray()[0]);
    }

    @Test
    public void test_friendsOfFriendsShouldContainTwoUsers() {
        User first = new User(1, "John", "Doe");
        User second = new User(2, "Marco", "Reus");
        User third = new User(3, "Thomas", "Rosicky");

        allUsers.add(first);
        allUsers.add(second);
        allUsers.add(third);

        FriendsOfFriendsFinder finder = new FriendsOfFriendsFinder(allUsers, first, third);
        first.addFriendId(2);
        second.addFriendId(3);
        first.setUserFriends(allUsers);
        second.setUserFriends(allUsers);
        finder.calculate();

        int expected = 2;
        int actual = finder.getFriendsOfFriends().size();
        assertEquals(expected,actual);
    }
}