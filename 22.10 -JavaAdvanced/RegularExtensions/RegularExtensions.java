import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {

    private static final String EMPTY_STRING = "";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    //Third or fourth result in Google on search "How to escape special character in Java"
    public static String escapeMetaCharacters(String inputString){
        String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&"};

        String outputString = inputString;

        for (int i = 0 ; i < metaCharacters.length ; i++){
            if(inputString.contains(metaCharacters[i])){
                outputString = inputString.replace(metaCharacters[i],"\\"+metaCharacters[i]);
                inputString = outputString;
            }
        }
        return outputString;
    }

    private static String reverse(String fullMatch) {
        StringBuilder resultString = new StringBuilder();

        for (int i = fullMatch.length() - 1; i >= 0; i--) {
            resultString.append(fullMatch.charAt(i));
        }

        return resultString.toString();
    }

    public static void main(String[] args) throws IOException {
        String inputText = reader.readLine();

        String pattern = EMPTY_STRING;

        while (!(pattern = reader.readLine()).equals("Print")) {
            pattern = escapeMetaCharacters(pattern);

            pattern = pattern.replace("%", "[^\\s]*");

            Pattern regexPattern = Pattern.compile(pattern);
            Matcher regexMatcher = regexPattern.matcher(inputText);

            while (regexMatcher.find()) {
                String fullMatch = regexMatcher.group(0);

                inputText = inputText.replace(fullMatch, reverse(fullMatch));
            }
        }

        System.out.println(inputText);
    }
}
