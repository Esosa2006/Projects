import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            File newFile = new File("StudentDetails.txt");
            if(newFile.createNewFile()){
                System.out.println("File was created");
            } else if (newFile.exists()) {
                System.out.println("File already exists");
            } else{
                System.out.println("Error");
            }
        }
        catch (Exception e){
            System.out.println("Error Occurred: " + e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many students are you adding to the database: ");
        int number_of_students = scanner.nextInt();
        for(int i = 0; i < number_of_students; i++){
            Student student = new Student();
            scanner.nextLine();
            System.out.printf("What is the name of the %d student\n", i + 1);
            student.set_name(scanner.nextLine());
            System.out.println("In what year: ");
            student.set_year(scanner.nextInt());
            student.set_ID();
            System.out.println("How much is your balance: ");
            student.set_balance(scanner.nextInt());
            System.out.println("How many courses would you like to enroll: ");
            int number_of_courses = scanner.nextInt();
            for(int j = 0; j < number_of_courses; j++){
                student.enrollCourses(number_of_courses);
            }
            student.set_ID();
            try (FileWriter studentFile = new FileWriter("studentDetails.txt")) {
                studentFile.write("Name: " + student.get_name());
                studentFile.write("Year: " + student.get_year());
                studentFile.write("ID: " + student.get_ID());
                studentFile.write("Balance: " + student.get_balance());
                studentFile.write("Payment status: " + student.get_hasPaid());
            } catch (Exception e) {
                System.out.println("Error Occurred: " + e.getMessage());
            }
        }
    }
}