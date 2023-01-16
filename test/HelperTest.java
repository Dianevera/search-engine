import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelperTest {

    private static final String WORD_WITH_ACCENT = "l'éducation";

    private static final String WORD_WITH_PUNCTUATION = "France.";

    private static final String WORD_WITH_PARENTHESIS = "(test)";

    private static final String WORD = "WordWithoutSpecialCharacters";

    @Test
    void removeSpecialCharactersAccentTest() {
        assertEquals( Helper.removeSpecialCharacters( WORD_WITH_ACCENT ), WORD_WITH_ACCENT.substring(2) );
    }

    @Test
    void removeSpecialCharactersPunctuationTest(){
        assertEquals( Helper.removeSpecialCharacters( WORD_WITH_PUNCTUATION ),
                WORD_WITH_PUNCTUATION.replaceAll(".$", "" ) );
    }

    @Test
    void removeSpecialCharactersParenthesisTest(){
        assertEquals( Helper.removeSpecialCharacters( WORD_WITH_PARENTHESIS ),
                WORD_WITH_PARENTHESIS.substring(1).replaceAll(".$", "" ));
    }

    @Test
    void removeSpecialCharactersTest(){
        assertEquals( Helper.removeSpecialCharacters( WORD ), WORD );
    }

}