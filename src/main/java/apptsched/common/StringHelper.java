package apptsched.common;

public abstract class StringHelper {

    public static String emailSuffixParser(String string){
        return string.substring(string.indexOf("@"));
    }
}
