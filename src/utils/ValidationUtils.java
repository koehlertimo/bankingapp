package utils;

import java.util.regex.Pattern;

public class ValidationUtils {
    private ValidationUtils(){};

    public static boolean isValidPassword(String password){
        final Pattern validPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
        final Pattern containsComma = Pattern.compile("[^;]");
        if(!validPassword.matcher(password).matches()){
            if(containsComma.matcher(password).matches()){
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean isValidEMail(String email){
        final Pattern validEmail = Pattern.compile("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
        if(validEmail.matcher(email).matches()){
            return true;
        }
        return false;
    }

    public static boolean containsComma(String str) {
        final Pattern containsComma = Pattern.compile("[^;]");
        if (containsComma.matcher(str).matches()) {
            return true;
        }
        return false;
    }

}
