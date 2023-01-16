import java.util.*;

/**
 * Class used for the search engine
 */
public class Search {

    /**
     * Searches a list of word in the file
     * For each word in the request, search the word in the indexes then retrieve the line to display
     * @param wordsToFind The words to find
     * @param indexes The list of words and indexes in the file
     * @param reader The file content
     * @return Lines containing words in the request
     */
    public static List<String> run( final String wordsToFind, final Indexes indexes, final Reader reader ){
        Set<Integer> lineNumberSet = new HashSet<>();
        List<String> wordToFindList = List.of( wordsToFind.split( " ") );

        for ( String word : wordToFindList ) {
            word = Helper.removeSpecialCharacters( word ).toLowerCase();
            Set<Integer> lineNumberList = indexes.getLineNumberList( word );
            if ( lineNumberList != null )
                lineNumberSet.addAll( lineNumberList );
        }

        List<String> linesFound = new ArrayList<>();
        lineNumberSet.forEach( lineNumber -> linesFound.add( reader.getLine( lineNumber ) ) );

        return linesFound;
    }
}
