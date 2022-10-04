package October4;

import java.util.Set;
import java.util.TreeSet;

public class UserTreeSet {
    public static void main(String[] args) {
        Set<User> userTreeSet = new TreeSet<User>();
        User user1 = new User("Benny", 15);
        User user2 = new User("Casper", 30);
        User user3 = new User("Aaron", 25);

        userTreeSet.add(user1);
        userTreeSet.add(user2);
        userTreeSet.add(user3);

        System.out.println(userTreeSet);
    }
}
