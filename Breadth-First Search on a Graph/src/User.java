import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Integer> friendsIds;
    private List<User> friends;

    public User(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friends = new ArrayList<>();
        this.friendsIds = new ArrayList<>();
    }

    public void addFriendId(Integer friendId) {
        this.friendsIds.add(friendId);
    }

    public Integer getId() {
        return id;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setUserFriends(List<User> allUsers) {
        for(Integer friendId : friendsIds) {
            for(User user : allUsers) {
                if(friendId.equals(user.getId())) {
                    friends.add(user);
                }
            }
        }
    }
}
