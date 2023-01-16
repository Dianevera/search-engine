import java.util.*;

public class Indexes {

    /**
     * Map containing the position of a word in the file
     */
    private final Map<String, Set<Integer>> indexes;

    /**
     * Default constructor
     */
    public Indexes(){
        indexes = new HashMap<>();
    }

    /**
     * Returns list of lines where a word appears
     * @param word The word to search
     * @return The line number list
     */
    public Set<Integer> getLineNumberList( final String word ){
        return indexes.get( word );
    }

    /**
     * Populates the map of indexes for each unique word of a line
     * @param linesList The line list
     */
    public void setIndexes ( final List<String> linesList ) {
        for( int lineNumber = 0; lineNumber < linesList.size(); lineNumber++ ){
            Set<String> uniqueWords = new HashSet<>( List.of( linesList.get( lineNumber ).split(" " ) ) );
            put( uniqueWords, lineNumber );
        }
    }

    /**
     * Adds word in the indexes map
     * For each word, if it exists in the map otherwise create a new one.
     * @param words The list of word to add in the map
     * @param lineNumber The number line to
     */
    private void put ( Set<String> words, Integer lineNumber ){

        for ( String word : words ) {
            String key = Helper.removeSpecialCharacters(word).toLowerCase();
            if ( !key.equals("") ) {
                Set<Integer> linesNumbersList = indexes.get( key );
                if (linesNumbersList == null)
                    linesNumbersList = new HashSet<>();

                linesNumbersList.add(lineNumber);
                indexes.put(key, linesNumbersList);
            }
        }
    }

}
