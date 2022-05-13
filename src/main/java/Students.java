public class Students {
    private String name;
    private String birthPlace;
    private String birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private String nameOfCaretaker;
    private String numberOfCaretaker;

    public Students
            (
            String name,            String birthPlace,
            String birthDate,       String address,
            String phoneNumber,     String email,
            String nameOfCaretaker, String numberOfCaretaker
            )
    {
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nameOfCaretaker = nameOfCaretaker;
        this.numberOfCaretaker = numberOfCaretaker;
    }

    /** Start of Get- and Setters
     */

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNameOfCaretaker() {
        return nameOfCaretaker;
    }
    public void setNameOfCaretaker(String nameOfCaretaker) {
        this.nameOfCaretaker = nameOfCaretaker;
    }
    public String getNumberOfCaretaker() {
        return numberOfCaretaker;
    }
    public void setNumberOfCaretaker(String numberOfCaretaker) {
        this.numberOfCaretaker = numberOfCaretaker;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "Name: "                     + name +
                "Place of birth:  "         + birthPlace +
                "Date of birth: "           + birthDate +
                "Address: "                 + address +
                "Phone number: "            + phoneNumber +
                "Email: "                   + email +
                "Caretaker: "               + nameOfCaretaker +
                "Phone number (caretaker): "+ numberOfCaretaker
                ;
    }
}
