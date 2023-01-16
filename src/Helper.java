/**
 * Class helper for methods used throughout the programme
 */
public class Helper {

    /**
     * Removes special character as punctuation in a String
     * @param word The word
     * @return String without special character as punctuation
     */
    public static String removeSpecialCharacters( final String word ) {

        String tmpWord = (word.contains( "'" )) ? word.substring( word.indexOf( '\'' ) ) : word;

        String wordWithoutPunctuation = "";
        for ( Character character : tmpWord.toCharArray() ) {
            if( character == '-' || Character.isLetterOrDigit( character ) )
                wordWithoutPunctuation += character;
        }
        return wordWithoutPunctuation;
    }

}
