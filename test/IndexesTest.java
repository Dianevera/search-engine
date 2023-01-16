import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class IndexesTest {

    private final List<String> lineList = List.of( "This is a TesT" );

    private final static String EXISTING_INDEX = "test";

    private final static String NOT_EXISTING_INDEX =  "existing";

    private Indexes givenIndexes(){

        Indexes indexes = new Indexes();
        indexes.setIndexes( lineList );
        return indexes;
    }

    @Test
    void wordInIndexesTest() {
        Indexes indexes = givenIndexes();
        assertNotNull( indexes.getLineNumberList( EXISTING_INDEX ) );
    }

    @Test
    void wordNotInIndexesTest() {
        Indexes indexes = givenIndexes();
        assertNull( indexes.getLineNumberList( NOT_EXISTING_INDEX ) );
    }
}