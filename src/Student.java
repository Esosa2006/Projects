import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String _name;
    private int _year;
    private String _ID;
    private final ArrayList<String> enrolledCourses = new ArrayList<>();
    private int _balance;
    private boolean hasPaid = false;

    public Student() {
    }

    public Student(String name, int year) {
        set_name(name);
        set_year(year);
    }

    public void set_name(String name) {
        _name = name;
    }

    public void set_year(int year) {
        _year = year;
    }

    public void set_balance(int balance) {
        _balance = balance;
    }

    public int get_balance() {
        return _balance;
    }

    public String get_name() {
        return _name;
    }

    public int get_year() {
        return _year;
    }

    public String get_ID() {
        return _ID;
    }

    public boolean get_hasPaid() {
        return hasPaid;
    }

    public void enrollCourses(int no) {
        if (_balance > 600) {
            int count = 0;
            Scanner scanner = new Scanner(System.in);
            boolean isDone = false;
            while(!isDone) {
                System.out.println("Which course would you like to enroll");
                String user_input = scanner.nextLine().toLowerCase();
                if (user_input.equalsIgnoreCase("History") || user_input.equalsIgnoreCase("Mathematics") || user_input.equalsIgnoreCase("English") || user_input.equalsIgnoreCase("Chemistry") || user_input.equalsIgnoreCase("Computer Science")) {
                    String new_input = user_input + " 101";
                    enrolledCourses.add(new_input);
                    count++;
                    _balance -= 600;
                    if(no == count){
                        isDone = true;
                    }
                }
                else {
                    System.out.println("Course not available");
                }
            }
        } else {
            System.out.println("Balance too low");
        }
        if (!enrolledCourses.isEmpty()) {
            hasPaid = true;
        }
    }

    int counter = 0;

    public void set_ID() {
        counter++;
        String year = Integer.toString(_year);
        _ID = year.charAt(0) + "CU" + counter;
    }
}
