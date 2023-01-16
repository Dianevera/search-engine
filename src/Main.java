import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        Reader reader = new Reader();
        reader.setLines( "resource/paris.txt" );
        Indexes indexes = new Indexes();
        indexes.setIndexes( reader.getLineList() );
        String request = "";

        while ( request != null ) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter your request please : ");
            try {
                request = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<String> linesFound = Search.run( request, indexes, reader ) ;
            linesFound.forEach( System.out::println );
            System.out.println();
        }

    }
}
