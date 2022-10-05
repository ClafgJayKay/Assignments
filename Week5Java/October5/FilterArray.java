package October5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class FilterArray {
    public static void main(String[] args){
        HashMap<Integer, ArrayList<User>> myHashMap = new HashMap<Integer, ArrayList<User>>();

        ArrayList<User> ArrList1 = new ArrayList<User>();
        ArrList1.add(new User("Aaron", 15, "Tampines"));
        ArrList1.add(new User("Ben", 19, "Bedok"));
        ArrList1.add(new User("Charles", 30, "Orchard"));

        ArrayList<User> ArrList2 = new ArrayList<User>();
        ArrList2.add(new User("Danny", 17, "Jurong East"));
        ArrList2.add(new User("Esther", 50, "Woodlands"));
        ArrList2.add(new User("Gunther", 60, "Bugis"));

        myHashMap.put(1, ArrList1);
        myHashMap.put(2, ArrList2);

        System.out.println("Original Array:");

        for(Integer key: myHashMap.keySet()){
            System.out.println("            ");

            for(User user: myHashMap.get(key)){
                System.out.println(user.getName() + " " + user.getAge() + " " + user.getAddress());
            }
            System.out.println("            ");
        }

        System.out.println("Filter user age below 20:");

        for (ArrayList<User> tmp : myHashMap.values()) {
            List<User> filteredUserList = (tmp.stream().filter(user -> user.getAge() < 20).collect(toList()));

            for (User user : filteredUserList) {
                System.out.println(user.getName() + " " + user.getAge() + " " + user.getAddress());
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Filter first user with 'a' in name:");

        for (ArrayList<User> tmp : myHashMap.values()) {
            User filteredUser = (tmp.stream().filter(user -> user.getName().startsWith("A")).findFirst()).get();

            System.out.println(filteredUser.getName() + " " + filteredUser.getAge() + " " + filteredUser.getAddress());
        }
    }}
