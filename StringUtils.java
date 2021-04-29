import java.util.regex.Pattern;

public class StringUtils {

    public static Pattern integerNumbersPattern = Pattern.compile("\\d+");

    public static boolean canParseInteger(String str){
        return str != null && integerNumbersPattern.matcher(str).matches();
    }

    public static boolean allStrIsNumbers(String... strings){
        for (String el:strings) {
            if (!canParseInteger(el))return false;
        }
        return true;
    }

}
