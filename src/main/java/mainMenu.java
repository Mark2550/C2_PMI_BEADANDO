import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        String file = "src/main/resources/DataOfStudents.xml";
        ArrayList<Students> students = xmlReadStudents.readStudentsFromXml(file);
        menuInterface(students);
        xmlWriteStudents.saveToXml(students,file);
    }
    private static void menuInterface(ArrayList<Students> students) throws InterruptedException {
        int userNumber = -1;
        while (userNumber != 0){
            System.out.println(
                    "1 - List students\r\n" +
                    "2 - Add new Student\r\n" +
                    "3 - Modify Students\r\n" +
                    "4 - Delete Students\r\n" +
                    "0 - Exit\n"
            );

            try {
                System.out.println("Select an option: ");
                userNumber = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid option");
            }
            scanner.nextLine();
            switch (userNumber){
                case 1:
                    listStudents(students);     TimeUnit.SECONDS.sleep(3);
                    break;
                case 2:
                    addNewStudent(students);    TimeUnit.SECONDS.sleep(3);
                    break;
                case 3:
                    modifyStudent(students);    TimeUnit.SECONDS.sleep(3);
                    break;
                case 4:
                    deleteStudent(students);    TimeUnit.SECONDS.sleep(3);
                    break;
            }
        }
        System.out.println("");
    }
    private static void listStudents(ArrayList<Students> students) throws InterruptedException {
        System.out.println("List of students:\n");
        for (int i = 0; i <students.size(); i++) {
            System.out.println(i+1+". "+students.get(i).getName());
        }
        System.out.println("\nEnd of students list");
    }
    private static void addNewStudent(ArrayList<Students> students){

        String name ="",    birthPlace="",  birthDate="",
               address="",  phoneNumber="", email ="",
               nameOfCaretaker ="",         numberOfCaretaker="";

        System.out.println("Enter name of student:");
        name = scanner.nextLine();
        System.out.println("Enter place of birth:");
        birthPlace = scanner.nextLine();

        System.out.println("Enter date of birth:");
        birthDate = scanner.nextLine();
        while (!validator.validateBirthDate(birthDate)){
            System.out.println("Enter a valid date of birth:");
            birthDate = scanner.nextLine();
        }

        System.out.println("Enter address:");
        address = scanner.nextLine();
        System.out.println("Enter phone number:");
        phoneNumber = scanner.nextLine();

        while (!validator.validatePhoneNum(phoneNumber)){
            System.out.println("Enter a valid phone number:");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Enter email:");
        email = scanner.nextLine();

        while (!validator.validateEmail(email)){
            System.out.println("Enter a valid email:");
            email = scanner.nextLine();
        }

        System.out.println("Enter name of caretaker:");
        nameOfCaretaker = scanner.nextLine();

        System.out.println("Enter phone number of caretaker:");
        numberOfCaretaker = scanner.nextLine();

        while (!validator.validatePhoneNum(numberOfCaretaker)){
            System.out.println("Enter a valid phone number:");
            phoneNumber = scanner.nextLine();
        }

        students.add(
                new Students(
                name, birthPlace, birthDate, address, phoneNumber,
                email, nameOfCaretaker, numberOfCaretaker
        ));
        System.out.println("Successfully added!\n");
    }
    private static void modifyStudent(ArrayList<Students> students) throws InterruptedException {
        int selectedStudent = -1;
        String name ="", birthPlace="",birthDate="", address="", mobileNumber="",
                email ="", nameOfCaretaker ="", numberOfCaretaker="";
        listStudents(students);
        try {
            System.out.println("Select a student you wish to modify: ");
            selectedStudent = scanner.nextInt();

            int selectedType = 0;

            Students modifiedSt = findStudent(students, selectedStudent);

            System.out.println("Select what you want to modify: ");
            System.out.println("1. name: "          +   modifiedSt.getName());
            System.out.println("2. address: "       +   modifiedSt.getAddress());
            System.out.println("3. phone number: "  +   modifiedSt.getPhoneNumber());
            System.out.println("4. email: "         +   modifiedSt.getEmail());
            System.out.println("5. caretaker's name: "  + modifiedSt.getNameOfCaretaker());
            System.out.println("6. caretaker's phone number: "  + modifiedSt.getNumberOfCaretaker());
            System.out.println("\r\n Please select (0 to exit): ");

                selectedType = scanner.nextInt();

                while (selectedType < 0 && selectedType > 6){
                    System.out.println("\r\n Invalid option, please choose again: ");
                    selectedType = scanner.nextInt();
                }

                scanner.nextLine();
                String userChoice ="";

                switch (selectedType){
                    case 0: break;
                    case 1:
                        System.out.println("Enter new name:");
                        userChoice = scanner.nextLine();
                        modifiedSt.setName(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;

                    case 2:
                        System.out.println("Enter new address:");
                        userChoice = scanner.nextLine();
                        modifiedSt.setAddress(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;

                    case 3:
                        System.out.println("Enter new phone number:");
                        userChoice = scanner.nextLine();
                        while (!validator.validatePhoneNum(userChoice)){
                            System.out.println("Enter a valid phone number:");
                            userChoice = scanner.nextLine();
                        }
                        modifiedSt.setPhoneNumber(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;

                    case 4:
                        System.out.println("Enter new email:");
                        userChoice = scanner.nextLine();
                        while (!validator.validateEmail(userChoice))
                        {
                            System.out.println("Enter a valid email:");
                            userChoice = scanner.nextLine();
                        }
                        modifiedSt.setEmail(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;

                    case 5:
                        System.out.println("Enter new name of caretaker:");
                        userChoice = scanner.nextLine();
                        modifiedSt.setNameOfCaretaker(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;

                    case 6:
                        System.out.println("Enter new number of caretaker:");
                        userChoice = scanner.nextLine();

                        while (!validator.validatePhoneNum(userChoice)){
                            System.out.println("Enter a valid phone number:");
                            userChoice = scanner.nextLine();
                        }
                        modifiedSt.setNumberOfCaretaker(userChoice);
                        System.out.println("Successfully changed!\n");
                        break;
                }
            }catch (Exception e) {   System.out.println("Not a valid option\n");   }
        }
    private static void deleteStudent(ArrayList<Students> students) throws InterruptedException {
        listStudents(students);
        System.out.printf("ID of student you want to remove: ");
        try {
            students.remove(findStudent(students, scanner.nextInt()));
            System.out.println("Successfully removed!\n");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static Students findStudent (ArrayList<Students> students, int index) throws IllegalArgumentException{
        if (index > 0 && index <= students.size()){
            return students.get(index-1);
        }
        throw new IllegalArgumentException("No student with index "+index);
    }
}
