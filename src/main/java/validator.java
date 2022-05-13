import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator {

    public static boolean validatePhoneNum(String number){
        String regex = "^(?:\\d ?){6,14}\\d$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean validateEmail(String email){
        String regex = "^(.{3,32})@(\\S+).com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validateBirthDate(String birtDate){
        String regex ="^\\d{4}.(0[1-9]|1[0-2]).(0[1-9]|[12][0-9]|3[01])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birtDate);
        return matcher.matches();
    }
}
