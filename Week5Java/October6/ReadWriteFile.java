package October6;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadWriteFile {
    public static void main(String[] args) {
        ArrayList<User> myArrList = new ArrayList<>();
        myArrList.add(new User("Aaron", "Tampines"));
        myArrList.add(new User("Ben", "Pasir Ris"));
        myArrList.add(new User("Charles", "Bedok"));
        myArrList.add(new User("Danny", "Orchard"));
        myArrList.add(new User("Esther", "Jurong East"));

        try (FileOutputStream fo = new FileOutputStream("C:\\Users\\phang\\Documents\\GitHub\\Assignments\\Week5Java\\October6\\sample.txt", true)) {
            for (User user : myArrList) {
                LocalDateTime timestamp = LocalDateTime.now();
                String formatTimeStamp = timestamp.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
                String input = formatTimeStamp + " - Name: " + user.getName() + ", Address: " + user.getAddress() + "\n";
                fo.write(input.getBytes());
            }
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

}
