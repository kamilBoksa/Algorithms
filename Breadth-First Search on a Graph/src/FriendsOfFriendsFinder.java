import java.util.*;

public class FriendsOfFriendsFinder {

    private List<User> allUsers;
    private User start;
    private User goal;
    private int distance;
    private Set<User> friendsOfFriends;

    FriendsOfFriendsFinder(List<User> allUsers, User start, User goal) {
        this.allUsers = allUsers;
        this.start = start;
        this.goal = goal;
        this.friendsOfFriends = new HashSet<>();
    }

    public void calculate() {
        if(this.start.equals(goal)) {
            distance = 0;
            return;
        }

        Queue<User> queue = new LinkedList<>();
        queue.add(start);
        distance++;

        while(!queue.isEmpty()) {
            User current = queue.remove();
            if(current.equals(this.goal)) {
                distance--;
                return;
            } else {
                if(current.getFriends().isEmpty()) {
                    continue;
                } else {
                    friendsOfFriends.addAll(current.getFriends());
                    queue.addAll(current.getFriends());
                }
            }
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public Set<User> getFriendsOfFriends() {
        return friendsOfFriends;
    }
}
