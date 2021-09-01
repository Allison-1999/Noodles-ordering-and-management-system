package control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Class Name: Validation.java
 *  Intro: A control class to validate input content.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Validation {
    private static String test = "";

    /**
     * Method Name: validatePwd()
     * Intro: validate password
     * @return valid or not
     */
    public static boolean validatePwd(){
        boolean result = true;
        boolean hasSmallLetter = false;
        boolean hasUpperLetter = false;
        boolean hasDigit = false;
        if (test.length() < 6 || test.length() > 10)
            result = false;
        for (int i = 0; i < test.length(); i++){
            if ((test.charAt(i) < 'a' || test.charAt(i) > 'z') && (test.charAt(i) < 'A' || test.charAt(i) > 'Z') && (test.charAt(i) < '0' || test.charAt(i) > '9')) {
                result = false;
                break;
            }
        }
        for (int i = 0; i < test.length(); i++){
            if (test.charAt(i) >= 'a' && test.charAt(i) <= 'z')
                hasSmallLetter = true;
            if (test.charAt(i) >= '0' && test.charAt(i) <= '9')
                hasDigit = true;
            if (test.charAt(i) >= 'A' && test.charAt(i) <= 'Z')
                hasUpperLetter = true;
        }
        if (!hasDigit || !hasSmallLetter || !hasUpperLetter)
            result = false;
        return result;
    }

    /**
     * Method Name: validatePhone()
     * Intro: validate phone
     * @return valid or not
     */
    public static boolean validatePhone(){
        boolean result = true;
        if (null==test || "".equals(test)){
            return true;
        }
        if (test.length() != 14)
            return false;
        if(test.charAt(1) == '8' && test.charAt(3) != '1')
            result = false;
        if(test.charAt(1) == '4' && test.charAt(3) != '0')
            result = false;
        for (int i = 1; i < test.length(); i++){
            if (test.charAt(i) < '0' || test.charAt(i) > '9') {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Method Name: validateEmail()
     * Intro: validate email
     * @return valid or not
     */
    public static boolean validateEmail(){
        if (null==test || "".equals(test)){
            return true;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(test);
        return m.matches();
    }

    /**
     * Method Name: validateName()
     * Intro: validate name
     * @return valid or not
     */
    public static boolean validateName(){
        boolean result = test.matches("[a-zA-Z ]+");
        if (test.charAt(0) < 'A' || test.charAt(0) > 'Z')
            result = false;
        return result;
    }

    /**
     * Method Name: setTest()
     * Intro: setter of test
     * @param test test
     */
    public static void setTest(String test){Validation.test = test;}
}
