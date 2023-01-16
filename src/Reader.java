import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class for file reading
 */
public class Reader {

    /**
     * List of list in the file
     */
    private List<String> linesList;

    /**
     * Default constructor
     */
    public Reader() {
         linesList = new ArrayList<>();
    }

    /**
     * Collects lines in the file from a filename
     * @param fileName the name of the file
     */
    public void setLines( final String fileName ) {

        try ( BufferedReader bufferedReader = new BufferedReader( new FileReader( fileName ) ) ) {
            String line;
            while ( ( line = bufferedReader.readLine() ) != null ) {
                if ( !line.isEmpty() )
                    linesList.add( line );
            }
        } catch ( IOException exception ) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the list of lines
     * @return List of lines
     */
    public List<String> getLineList(){
        return linesList;
    }

    /**
     * Gets line from a given line number
     * @param lineNumber The line number
     * @return The line at position line number
     */
    public String getLine( final Integer lineNumber ){
        return linesList.get( lineNumber );
    }
}
