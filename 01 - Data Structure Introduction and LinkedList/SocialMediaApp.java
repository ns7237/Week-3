import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            for (int id : user.friendIds) {
                User friend = findUserById(id);
                if (friend != null) System.out.print(friend.name + " ");
            }
            System.out.println();
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            List<Integer> mutual = new ArrayList<>();
            for (int id : user1.friendIds) {
                if (user2.friendIds.contains(id)) mutual.add(id);
            }
            System.out.print("Mutual friends: ");
            for (int id : mutual) {
                User friend = findUserById(id);
                if (friend != null) System.out.print(friend.name + " ");
            }
            System.out.println();
        }
    }

    public void searchUserById(int userId) {
        User user = findUserById(userId);
        if (user != null) System.out.println("User Found: " + user.name + ", Age: " + user.age);
    }

    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID=" + temp.userId + ", Age=" + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User Not Found");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 21);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 23);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);
        sm.displayFriends(1);
        sm.displayFriends(3);
        sm.findMutualFriends(1, 3);
        sm.searchUserByName("Bob");
        sm.searchUserById(4);
        sm.countFriends();
        sm.removeFriend(1, 3);
        sm.displayFriends(1);
        sm.displayAllUsers();
    }
}
